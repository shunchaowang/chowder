package me.algorithm.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import me.algorithm.dp.dualsequence.ShortCommonSupersequence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ShortCommonSupersequenceTest {

  private final Logger log = LoggerFactory.getLogger(this.getClass());
  ShortCommonSupersequence shortCommonSupersequence;

  @BeforeEach
  void setup() {
    shortCommonSupersequence = new ShortCommonSupersequence();
  }

  @Test
  @DisplayName("abac and cab should return cabac")
  void testCaseRecursion1() {
    assertEquals("cabac", shortCommonSupersequence.dfs("abac", "cab"));
  }

  @Test
  @DisplayName("large strings")
  void testCaseRecursion2() {
    var str1 = "babbbbaa";
    var str2 = "baabbbbba";
    var expected = "baabbbbbaa";
    var actual = shortCommonSupersequence.dfs(str1, str2);
    log.info("actual is {}", actual);
    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("abac and cab should return cabac")
  void testCaseDp1() {
    assertEquals("cabac", shortCommonSupersequence.dp("abac", "cab"));
  }

  @Test
  @DisplayName("large strings")
  void testCaseDp2() {
    var str1 = "babbbbaa";
    var str2 = "baabbbbba";
    var expected = "baabbbbbaa";
    var actual = shortCommonSupersequence.dp(str1, str2);
    log.info("actual is {}", actual);
    assertEquals(expected, actual);
  }
}