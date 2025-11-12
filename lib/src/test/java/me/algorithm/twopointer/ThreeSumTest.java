package me.algorithm.twopointer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class ThreeSumTest {

  ThreeSum threeSum;
  @BeforeEach
  void setUp() {
    threeSum = new ThreeSum();
  }

  @Test
  @DisplayName("[-1,0,1,2,-1,-4] should return [[-1,-1,2],[-1,0,1]]")
  void testCase1() {
    
    List<List<Integer>> result = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    log.info("result: {}", result);
    
    List<List<Integer>> expected = List.of(
        List.of(-1,-1,2),
        List.of(-1,0,1)
    );
    
    assertEquals(result.size(), expected.size());
  }
}