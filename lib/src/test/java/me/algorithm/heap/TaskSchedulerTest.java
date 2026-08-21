package me.algorithm.heap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskSchedulerTest {

  @Test
  void case1() {

    TaskScheduler scheduler = new TaskScheduler();
    int actual = scheduler.leastInterval(new char[] {'A','A','A','B','B','B'}, 2);
    int expected = 8;
    assertEquals(expected, actual);
  }

}