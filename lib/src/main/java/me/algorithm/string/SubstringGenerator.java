package me.algorithm.string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubstringGenerator {

  public List<String> generateSubstring(String s) {
    Set<String> set = new HashSet<>();
    generateSubstring(s, 0, "", set);
    return set.stream().toList();
  }


  private void generateSubstring(String s, int index, String existed, Set<String> set) {
    if (index == s.length()) {
      return;
    }

    // excluding the char at index
    set.add(existed);
    generateSubstring(s, index + 1, existed, set);

    // including the char at index
    String existedWithCurrentIndex = existed + s.charAt(index);
    set.add(existedWithCurrentIndex);
    generateSubstring(s, index + 1, existedWithCurrentIndex, set);
  }


}
