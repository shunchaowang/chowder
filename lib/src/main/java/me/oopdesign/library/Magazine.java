package me.oopdesign.library;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Magazine extends Book {

  final String number;

  Magazine(String title, String number) {
    super(title);
    this.number = number;
    this.tags.add("magazine");
  }

  static Magazine parseDef(String def) {
    Pattern pattern = Pattern.compile("\"(.*)\" Issue (.*)");
    Matcher matcher = pattern.matcher(def);

    if (matcher.find()) {
      return new Magazine(matcher.group(1), matcher.group(2));
    } else {
      return null;
    }
  }

  @Override
  public String toString() {
    return String.format("\"%s\" Issue %s", title, number);
  }
}
