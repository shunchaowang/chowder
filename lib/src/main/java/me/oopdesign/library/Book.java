package me.oopdesign.library;

import java.util.HashSet;
import java.util.Set;

abstract class Book {

  String id;
  String title;
  User borrowedBy;
  static final Set<String> disallowedTags = Set.of("traditional-book", "magazine");
  Set<String> tags;

  Book(String title) {
    this.title = title;
    id = null;
    borrowedBy = null;
    tags = new HashSet<>();
  }
}
