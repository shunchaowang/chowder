package me.oopdesign.library;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TraditionalBook extends Book {

  final String author;

  TraditionalBook(String title, String author) {
    super(title);
    this.author = author;
    this.tags.add("traditional-book");
  }

  static TraditionalBook parseDef(String def) {
    Pattern pattern = Pattern.compile("\"(.*)\" by (.*)");
    Matcher matcher = pattern.matcher(def);
    if (matcher.find()) {
      return new TraditionalBook(matcher.group(1), matcher.group(2));
    } else {
      return null;
    }
  }

  @Override
  public String toString() {
    return String.format("\"%s\" by %s", title, author);
  }
}
