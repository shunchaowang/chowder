package me.algorithm.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TextJustificationTest {

  TextJustification textJustification;

  @BeforeEach
  void setUp() {

    textJustification = new TextJustification();
  }

  @Test
  @DisplayName("[\"This\", \"is\", \"an\", \"example\", \"of\", \"text\", \"justification.\"] with max width of 16 should give us [\"This    is    an\",\"example  of text\",\"justification.  \"]")
  void testCase1() {

    List<String> words = List.of("This", "is", "an", "example", "of", "text", "justification.");
    int maxWidth = 16;
    List<String> expected = List.of("This    is    an", "example  of text", "justification.  ");

    List<String> actual = textJustification.fullJustify(words.toArray(new String[0]), maxWidth);

    assertArrayEquals(expected.toArray(), actual.toArray());
  }

  @Test
  @DisplayName("[\"What\",\"must\",\"be\",\"acknowledgment\",\"shall\",\"be\"] with max width of 16 should give us [\"What   must   be\",\"acknowledgment  \",\"shall be        \"]")
  void testCase2() {

    String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
    int maxWidth = 16;
    List<String> expected = List.of(
        "What   must   be",
        "acknowledgment  ",
        "shall be        "
    );

    List<String> actual = textJustification.fullJustify(words, maxWidth);

    assertArrayEquals(expected.toArray(), actual.toArray());
  }
}