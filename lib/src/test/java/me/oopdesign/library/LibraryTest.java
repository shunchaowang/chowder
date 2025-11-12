package me.oopdesign.library;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
class LibraryTest {

  Library library;

  @BeforeEach
  void setUp() {
    library = new Library();
  }

  @Test
  void test1() {
    List<String> instructions = List.of("register book B-001 \"Macbeth\" by W. Shakespeare",
        "register book B-002 \"Hamlet\" by W. Shakespeare",
        "register magazine M-001 \"New York Times\" Issue 2",
        "borrow B-002 John Smith",
        "lookup id B-002",
        "borrow M-001 John Smith",
        "borrow M-001 Jane Doe",
        "lookup title New York Times",
        "lookup author W. Shakespeare",
        "return John Smith",
        "lookup title Hamlet"
    );

    List<String> expected = List.of(
        "\"Hamlet\" by W. Shakespeare",
        "ID: B-002",
        "Borrowed by: John Smith",
        "\"New York Times\" Issue 2",
        "ID: M-001",
        "Borrowed by: Jane Doe",
        "2 books match the author: W. Shakespeare",
        "1 book(s) available",
        "\"Hamlet\" by W. Shakespeare",
        "ID: B-002"
    );
    List<String> results = library.simulate(instructions);
    log.info("actual result: {}", results);
    assertArrayEquals(expected.toArray(new String[0]), results.toArray(new String[0]));
  }

  @Test
  void test2() {
    List<String> instructions = List.of(
        "register book B-001 \"Macbeth\" by W. Shakespeare",
        "register book B-002 \"Hamlet\" by W. Shakespeare",
        "register magazine M-001 \"New York Times\" Issue 2",
        "tag B-001 tragedy play grade-12",
        "tag B-002 tragedy play grade-11",
        "tag M-001 news grade-11",
        "lookup tags play tragedy",
        "favorite traditional-book John Smith",
        "favorite grade-11 John Smith",
        "lookup suggestion John Smith"
    );

    List<String> expected = List.of(
        "2 books match the tag(s): play tragedy",
        "2 book(s) available",
        "\"Hamlet\" by W. Shakespeare",
        "ID: B-002"
    );

    List<String> actual = library.simulate(instructions);
    log.info("actual result: {}", actual);
    assertArrayEquals(expected.toArray(new String[0]), actual.toArray(new String[0]));
  }

  @Test
  void test3() {
    List<String> instructions = List.of(
        "register book O-1 \"1849\" by G. Orvill",
        "register book O-2 \"Animal Ranch\" by G. Orvill",
        "register book L-1 \"Courageous New World\" by A. Luxhey",
        "register book T-1 \"Animal Intersection: The Complete Story\" by N. Tendo",
        "register magazine A-1 \"Animal Intersection: A Comic Series\" Issue 1",
        "register magazine H-1 \"Starving Games\" Issue 2",
        "borrow O-1 Jack",
        "lookup tags dystopia traditional-book",
        "tag O-1 sci-fi dystopia fiction advanced",
        "tag O-2 animals dystopia fiction elementary",
        "tag O-3 politics non-fiction advanced",
        "lookup tags sci-fi fiction",
        "tag L-1 sci-fi dystopia fiction advanced",
        "tag T-1 animal fiction elementary",
        "tag A-1 animal fiction series elementary",
        "tag H-1 sci-fi dystopia fiction elementary",
        "lookup tags dystopia advanced",
        "lookup tags non-fiction",
        "lookup suggestion Jack",
        "favorite dystopia Jack",
        "favorite elementary Jack",
        "lookup suggestion Jack",
        "favorite sci-fi Jack",
        "favorite traditional-book Jack",
        "lookup suggestion Jack"
    );

    List<String> expected = List.of(
        "No such book exists",
        "\"1849\" by G. Orvill",
        "ID: O-1",
        "Borrowed by: Jack",
        "2 books match the tag(s): dystopia advanced",
        "1 book(s) available",
        "No such book exists",
        "No such book exists",
        "2 books are suggested for: Jack",
        "2 book(s) available",
        "4 books are suggested for: Jack",
        "3 book(s) available"
    );

    List<String> actual = library.simulate(instructions);
    log.info("actual result: {}", actual);
    assertArrayEquals(expected.toArray(new String[0]), actual.toArray(new String[0]));
  }
}