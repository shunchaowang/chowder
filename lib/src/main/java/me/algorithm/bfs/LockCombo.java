package me.algorithm.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ou are faced with a 4-wheel lock where each wheel contains the numbers '0' through '9'. Turning a
 * wheel can either increase or decrease its number by one, wrapping around from '9' to '0' or vice
 * versa. A single move involves rotating any one of the wheels by one slot.
 * <p>
 * The lock starts with the combination '0000'. However, there are specific combinations termed as
 * "deadends". If the lock lands on any of these deadend combinations, the wheels jam, making it
 * impossible to proceed.
 * <p>
 * Your task is to determine the least number of moves needed to reach a given target combination
 * from the starting point without hitting any deadend. If reaching the target is impossible due to
 * deadends, return -1.
 * <p>
 * Input target_combo: a string representing the four digit combination to open the lock.
 * trapped_combos: a list of strings representing the trapped combinations. Output An integer
 * representing the number of steps it takes to open the lock, or -1 if you can't open it without
 * triggering the trap.
 * <p>
 * Examples Example 1: Input:
 * <p>
 * target_combo = "0202" trapped_combos = ["0201","0101","0102","1212","2002"] Output: 6
 * <p>
 * Explanation:
 * <p>
 * 0000 -> 1000 -> 1100 -> 1200 -> 1201 -> 1202 -> 0202, a total of 6 steps.
 * <p>
 * Constraints The starting combination (0000) and the final combination is not trapped because that
 * defeats the purpose of the lock.
 */
public class LockCombo {

  // for the next digits
  private final Map<Character, Character> nextDigit = Map.of(
      '0', '1',
      '1', '2',
      '2', '3',
      '3', '4',
      '4', '5',
      '5', '6',
      '6', '7',
      '7', '8',
      '8', '9',
      '9', '0'
  );

  private final Map<Character, Character> prevDigit = nextDigit.entrySet().stream()
      .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

  private List<String> getNeighbors(String s) {
    List<String> neighbors = new ArrayList<>();
    // turn string into char array
    // create 8 strings by changing 1 bit each time
    for (int i = 0; i < s.length(); i++) {
      String beginning = s.substring(0, i);
      char mutant = s.charAt(i);
      String ending = s.substring(i + 1);
      neighbors.add(beginning.concat(nextDigit.get(mutant).toString()).concat(ending));
      neighbors.add(beginning.concat(prevDigit.get(mutant).toString()).concat(ending));
    }
    return neighbors;
  }

  public int tryUnlockCombo(String targetCombo, List<String> trappedCombos) {
    int steps = 0;

    Deque<String> queue = new ArrayDeque<>();
    Set<String> visited = new HashSet<>();
    queue.add("0000");
    visited.add("0000");

    while (!queue.isEmpty()) {
      int n = queue.size();
      for (int i = 0; i < n; i++) {
        String cur = queue.pop();
        if (cur.equals(targetCombo)) {
          return steps;
        }
        // all 1 moves
        List<String> adjs = getNeighbors(cur);
        for (String s : adjs) {
          if (trappedCombos.contains(s)
              || visited.contains(s)) {
            continue;
          }
          queue.add(s);
          visited.add(s);
        }
      }
      steps++;
    }

    return -1;
  }


}
