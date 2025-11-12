package me.oopdesign.library;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class User {

  String name;
  List<Book> books;
  Set<String> favoriteTags;

  User(String name) {
    this.name = name;
    books = new ArrayList<>();
    favoriteTags = new HashSet<>();
  }

  @Override
  public String toString() {
    return name;
  }
}
