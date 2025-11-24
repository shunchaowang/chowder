package me.playground.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class CharConversionTest {

  private final Logger log = LoggerFactory.getLogger(this.getClass());

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
    log.debug("convert a into the unicode by getNumericValue  returns {}",
        CharConversion.convertCharToUnicode('a'));
    assertEquals(10, CharConversion.convertCharToUnicode('a'));
  }

  @Test
  void convertUnicodeToChar() {
    assertEquals('a', CharConversion.convertUnicodeToChar(97));
  }
}