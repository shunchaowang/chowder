package me.algorithm.array;

import static me.algorithm.array.DuplicateNumbers.findDuplicates;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class DuplicateNumbersTest {

  @Test
  void testFindDuplicates() {

    int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
    List<Integer> actual = findDuplicates(nums);
    assertEquals(Arrays.asList(2, 3), actual);
  }
}
