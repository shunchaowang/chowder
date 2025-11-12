package me.algorithm.backtracking;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class SubsetTest {

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