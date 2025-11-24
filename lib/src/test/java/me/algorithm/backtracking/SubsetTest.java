package me.algorithm.backtracking;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class SubsetTest {

  private final Logger log = LoggerFactory.getLogger(SubsetTest.class);

  @Test
  @DisplayName("test case for [1,2,3]")
  void subsets() {
    var list = List.of(1, 2, 3);
    Subset subset = new Subset();
    List<List<Integer>> res = subset.subsets(list);
    log.info("subsets are {}", res);
    assert res.size() == 8;
    assert res.contains(List.of(1, 2, 3));
    assert res.containsAll(List.of(List.of(1, 2, 3), List.of(1, 2)));
  }
}