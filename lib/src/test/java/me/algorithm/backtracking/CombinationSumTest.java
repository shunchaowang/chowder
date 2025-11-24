package me.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class CombinationSumTest {

  private final Logger log = LoggerFactory.getLogger(CombinationSumTest.class.getName());

  @Test
  void case1() {

    List<Integer> candidates = List.of(2, 3, 6, 7);
    List<List<Integer>> expected = List.of(List.of(2, 2, 3), List.of(7));
    var combinationSum = new CombinationSum();
    List<List<Integer>> actual = combinationSum.combinationSum(new ArrayList<>(candidates), 7);
    log.info("acutal combination is {}", actual);
//        assertArrayEquals(actual,expected);
  }
}