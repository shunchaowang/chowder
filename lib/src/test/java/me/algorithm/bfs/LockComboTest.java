package me.algorithm.bfs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class LockComboTest {

  @Test
  void testTryUnlockCombo() {
    String target = "0202";
    List<String> trappedCombos = List.of(
        "0201",
        "0101",
        "0102",
        "1212",
        "2002"
    );

    LockCombo lockCombo = new LockCombo();
    int steps = lockCombo.tryUnlockCombo(target, trappedCombos);
    log.info("Steps to unlock {}", steps);
    assertEquals(6, steps);
  }

}