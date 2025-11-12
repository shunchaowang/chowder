package me.oopdesign.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;

class Library {

  private final Map<String, Book> books;
  private final List<User> users;

  Library() {
    books = new HashMap<>();
    users = new ArrayList<>();
  }

  private void registerBook(Book book) {
    if (!books.containsKey(book.id)) {
      books.put(book.id, book);
    }
  }

  private List<Book> lookupBooks(Predicate<Book> lookupFn) {
    List<Book> result = new ArrayList<>();
    for (Book book : books.values()) {
      if (lookupFn.test(book)) {
        result.add(book);
      }
    }
    return result;
  }

  private void outputBooks(List<Book> bookList, List<String> output,
      Function<List<Book>, List<String>> multipleMatchOutput) {
    if (bookList.isEmpty()) {
      output.add("No such book exists");
    } else if (bookList.size() == 1) {
      output.add(bookList.getFirst().toString());
      output.add(String.format("ID: %s", bookList.getFirst().id));
      if (bookList.getFirst().borrowedBy != null) {
        output.add(String.format("Borrowed by: %s", bookList.getFirst().borrowedBy));
      }
    } else {
      if (multipleMatchOutput == null) {
        return;
      }
      output.addAll(multipleMatchOutput.apply(bookList));
    }
  }

  private void borrowBook(Book book, User user) {
    // check if the user has borrowed a book
    // check if the book id is borrowed by others
    if (!user.books.isEmpty()) {
      return;
    }
    if (book == null || book.borrowedBy != null) {
      return;
    }
    user.books.add(book);
    book.borrowedBy = user;
  }

  private void returnBook(User user) {
    if (user == null || user.books.isEmpty()) {
      return;
    }
    Book book = user.books.getFirst();
    user.books.remove(book);
    book.borrowedBy = null;
  }

  private void tagBook(Book book, Set<String> tags) {
    book.tags.addAll(tags.stream().filter(t -> !Book.disallowedTags.contains(t)).toList());
  }

  private void favoriteTag(String tag, User user) {
    user.favoriteTags.add(tag);
  }

  List<String> simulate(List<String> instructions) {
    List<String> output = new ArrayList<>();

    for (String i : instructions) {
      String[] splitResult = i.split(" ", 2); // would be register|lookup ...
      switch (splitResult[0]) {
        case "tag" -> {
          splitResult = splitResult[1].split(" ", 2);
          Set<String> tags = Set.of(splitResult[1].split(" "));
          final String bookId = splitResult[0];
          List<Book> bookList = lookupBooks(book -> book.id.equals(bookId));
          if (!bookList.isEmpty()) {
            tagBook(bookList.getFirst(), tags);
          }
        }
        case "favorite" -> {
          splitResult = splitResult[1].split(" ", 2);
          final String tag = splitResult[0];
          final String username = splitResult[1];
          List<User> userList = users.stream().filter(u -> u.name.equals(username))
              .toList();
          User user;
          if (userList.isEmpty()) {
            user = new User(username);
            users.add(user);
          } else {
            user = userList.getFirst();
          }
          favoriteTag(tag, user);
        }
        case "borrow" -> {
          splitResult = splitResult[1].split(" ", 2);
          final String lookupParameter = splitResult[0];
          final String username = splitResult[1];
          List<User> userList = users.stream().filter(u -> u.name.equals(username))
              .toList();
          User user;
          if (userList.isEmpty()) {
            user = new User(username);
            users.add(user);
          } else {
            user = userList.getFirst();
          }
          List<Book> bookList = lookupBooks(book -> book.id.equals(lookupParameter));
          if (!bookList.isEmpty()) {
            borrowBook(bookList.getFirst(), user);
          }
        }
        case "return" -> {
          final String username = splitResult[1];
          List<User> userList = users.stream().filter(u -> u.name.equals(username))
              .toList();
          if (!userList.isEmpty()) {
            returnBook(userList.getFirst());
          }
        }
        case "register" -> {
          splitResult = splitResult[1].split(" ", 3);
          Book newBook = null;
          if (splitResult[0].equals("book")) {
            newBook = TraditionalBook.parseDef(splitResult[2]);
          } else if (splitResult[0].equals("magazine")) {
            newBook = Magazine.parseDef(splitResult[2]);
          }
          if (newBook != null) {
            newBook.id = splitResult[1];
            registerBook(newBook);
          }
        }
        case "lookup" -> {
          splitResult = splitResult[1].split(" ", 2);
          final String lookupParameter = splitResult[1];
          switch (splitResult[0]) {
            case "tags" -> {
              final String lookupTagsString = splitResult[1];
              final Set<String> lookupTags = Set.of(lookupTagsString.split(" "));
              List<Book> booksList = lookupBooks(book -> book.tags.containsAll(lookupTags));
              outputBooks(booksList, output, (bookList1 -> {
                List<String> result = new ArrayList<>();
                result.add(String.format("%d books match the tag(s): %s", bookList1.size(),
                    lookupTagsString));
                result.add(String.format("%d book(s) available",
                    bookList1.stream().filter(book -> book.borrowedBy == null).count()));
                return result;
              }));
            }
            case "suggestion" -> {
              final String lookupUsername = splitResult[1];
              List<User> userList = users.stream()
                  .filter(user -> user.name.equals(lookupUsername))
                  .toList();
              if (!userList.isEmpty()) {
                User user = userList.getFirst();
                Map<Book, Integer> userFavoriteBooksRanking = new HashMap<>();
                for (final String tag : user.favoriteTags) {
                  for (Book book : books.values().stream()
                      .filter(book -> book.tags.contains(tag))
                      .toList()) {
                    userFavoriteBooksRanking.put(book,
                        userFavoriteBooksRanking.getOrDefault(book, 0) + 1);
                  }
                }

                // create a map for ranking to book list
                final TreeMap<Integer, List<Book>> favoriteBookMaps = new TreeMap<>();
                userFavoriteBooksRanking.forEach((book, ranking) -> {
                  if (!favoriteBookMaps.containsKey(ranking)) {
                    favoriteBookMaps.put(ranking, new ArrayList<>());
                  }
                  favoriteBookMaps.get(ranking).add(book);
                });

                if (!favoriteBookMaps.isEmpty()) {
                  List<Book> favoriteBooks = favoriteBookMaps.lastEntry().getValue();
                  outputBooks(favoriteBooks, output, bookList -> {
                    List<String> result = new ArrayList<>();
                    result.add(String.format("%d books are suggested for: %s", bookList.size(),
                        lookupUsername));
                    result.add(String.format("%d book(s) available",
                        bookList.stream().filter(book -> book.borrowedBy == null).count()));
                    return result;
                  });
                } else {
                  outputBooks(List.of(), output, null);
                }
              } else {
                outputBooks(List.of(), output, null);
              }
            }
            case "id" -> {
              List<Book> bookList = lookupBooks((book -> book.id.equals(
                  lookupParameter))); // lookup by id should be no more than 1 result

              outputBooks(bookList, output, null);
            }
            case "title" -> {
              List<Book> bookList = lookupBooks(
                  (book -> book.title.equals(lookupParameter)));
              outputBooks(bookList, output,
                  (bookList1 -> {
                    List<String> result = new ArrayList<>();
                    result.add(String.format("%d books match the title: %s", bookList1.size(),
                        lookupParameter));
                    result.add(String.format("%d book(s) available",
                        bookList1.stream().filter(b -> b.borrowedBy == null).count()));
                    return result;
                  }
                  ));
            }
            case "author" -> {
              List<Book> bookList = lookupBooks((book -> (book instanceof TraditionalBook)
                  && ((TraditionalBook) (book)).author.equals(lookupParameter)));
              outputBooks(bookList, output,
                  (bookList1 -> {
                    List<String> result = new ArrayList<>();
                    result.add(String.format("%d books match the author: %s", bookList1.size(),
                        lookupParameter));
                    result.add(String.format("%d book(s) available",
                        bookList1.stream().filter(b -> b.borrowedBy == null).count()));
                    return result;
                  }));
            }
          }
        }
      }
    }

    return output;
  }

}
