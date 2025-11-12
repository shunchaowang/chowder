package me.playground.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class CharConversionTest {

  @Test
  void convertCharToAscii() {
    assertEquals(97, CharConversion.convertCharToAscii('a'));
  }

  @Test
  void convertAsciiToChar() {
    assertEquals('a', CharConversion.convertAsciiToChar(97));
  }

  @Test
  void convertCharToUnicode() {
    log.debug("convert a into the unicode by getNumericValue  returns {}", CharConversion.convertCharToUnicode('a'));
    assertEquals(10, CharConversion.convertCharToUnicode('a'));
  }

  @Test
  void convertUnicodeToChar() {
    assertEquals('a', CharConversion.convertUnicodeToChar(97));
  }
}