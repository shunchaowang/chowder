package me.algorithm.array;

import static me.algorithm.array.DisappearedNumbers.findKthMissingPositive;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DisappearedNumbersTest {

  @Test
  public void testFindKthMissingPositive() {
    int[] arr = {2, 3, 4, 7, 11};
    int k = 5;
    int expected = 9;

    int actual = findKthMissingPositive(arr, k);
    assertEquals(expected, actual);
  }

}
