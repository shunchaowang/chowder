package me.algorithm.string;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class SubstringGeneratorTest {

  @Test
  @DisplayName("Test substrings of abc to be {a,b,c,ab,ac,bc,abc}")
  void testGenerateSubstring() {

    SubstringGenerator substringGenerator = new SubstringGenerator();
    List<String> actual = substringGenerator.generateSubstring("abc");
    String[] expected = {"", "bc", "a", "ab", "b", "ac", "c", "abc"};

    log.info("actual: {}", actual);
    assertArrayEquals(expected, actual.toArray());
  }

}