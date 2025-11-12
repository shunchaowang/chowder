package me.algorithm.dp.dualsequence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EditDistanceTest {

  EditDistance editDistance;

  @BeforeEach
//  @BeforeAll
  void setup() {
    editDistance = new EditDistance();
  }

  @Test
  @DisplayName("intention and execution should have min edit distance of 5")
  void case1() {
    assertEquals(5, editDistance.minDistance("intention", "execution"));
  }

  @Test
  @DisplayName("park and spake should have min edit distance of 3")
  void case2() {
    assertEquals(3, editDistance.minDistance("park", "spake"));
  }

}