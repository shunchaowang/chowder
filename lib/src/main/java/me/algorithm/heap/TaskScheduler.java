package me.algorithm.heap;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Supplier;

/**
 * You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n. Each
 * CPU interval can be idle or allow the completion of one task. Tasks can be completed in any
 * order, but there's a constraint: there has to be a gap of at least n intervals between two tasks
 * with the same label.
 * <p>
 * Return the minimum number of CPU intervals required to complete all tasks.
 * <p>
 * Example 1:
 * <p>
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * <p>
 * Output: 8
 * <p>
 * Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
 * <p>
 * After completing task A, you must wait two intervals before doing A again. The same applies to
 * task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th interval, you
 * can do A again as 2 intervals have passed.
 * <p>
 * Example 2:
 * <p>
 * Input: tasks = ["A","C","A","B","D","B"], n = 1
 * <p>
 * Output: 6
 * <p>
 * Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.
 * <p>
 * With a cooling interval of 1, you can repeat a task after just one other task.
 * <p>
 * Example 3:
 * <p>
 * Input: tasks = ["A","A","A", "B","B","B"], n = 3
 * <p>
 * Output: 10
 * <p>
 * Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.
 * <p>
 * There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads
 * to idling twice between repetitions of these tasks.
 * <p>
 * Constraints:
 * <p>
 * 1 <= tasks.length <= 104 tasks[i] is an uppercase English letter. 0 <= n <= 100
 */
public class TaskScheduler {

  // when we need to pick up the next task to execute,
  // we should find the the available task with the most occurence to execute,
  // this will make sure
  public int leastInterval(char[] tasks, int n) {

    if (n == 0) {
      return tasks.length;
    }
    class Task {

      char c;
      int runs;

      Task(char c, int runs) {
        this.c = c;
        this.runs = runs;
      }
    }

    Map<Character, Task> taskMap = new HashMap<>();
    int ans = 0;

    Deque<Character> taskWindow = new LinkedList<>();

    PriorityQueue<Task> maxQueue = new PriorityQueue<>((t1, t2) -> (t2.runs - t1.runs));

    Supplier<Boolean> finished = () -> {

      for (Task t : taskMap.values()) {
        if (t.runs > 0) {
          return false;
        }
      }
      return true;
    };

    for (char task : tasks) {
      if (!taskMap.containsKey(task)) {
        taskMap.put(task, new Task(task, 0));
      }
      taskMap.get(task).runs++;
    }

    maxQueue.addAll(taskMap.values());

    // fill the n window
    for (int i = 0; i < n; i++) {
      if (finished.get()) {
        return ans;
      }
      if (maxQueue.isEmpty()) {
        taskWindow.add('i');
      } else {
        Task t = maxQueue.poll();
        taskWindow.add(t.c);
        // all runs should be at least 1, no need to check 0
        t.runs--;
      }
      ans++;
    }

    // now we need to shift the running windows and check if all tasks are finished
    while (!finished.get()) {

      if (maxQueue.isEmpty()) {
        taskWindow.addLast('i');
      } else {
        Task t = maxQueue.poll();
        taskWindow.addLast(t.c);
        t.runs--;
      }

      Character firstTask = taskWindow.pollFirst();

      if (firstTask != 'i' && taskMap.get(firstTask).runs > 0) {
        maxQueue.offer(taskMap.get(firstTask));
      }

      ans++;
    }

    return ans;
  }
}
