package me.algorithm.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given a stream of numbers, find the median number at any given time (accurate to 1 decimal
 * place).
 * <p>
 * Example:
 * <p>
 * add_number(1) add_number(2) add_number(3) get_median() == 2.0 add_number(4) get_median() == 2.5
 */
public class MedianOfStream {

  // use too priority queues, one for the lower half,
  // the other one for the upper half
  // the lower half is a max priority queue
  // the upper half is a min priority queue
  // the size of max queue should not be less than the min
  // all the time
  // when adding element, compare it with peek of the max queue,
  // add to the max queue if it is smaller than the peek;
  // add to the min queue if it is larger than the peek.
  // adjust the queues to make sure the size of the smaller pile
  // is always equal or 1+ than the size of the larger piles.
  // if the size of larger pile is bigger, poll from the min queue and add it to the smaller pile.
  // if the size of the smaller pile is 2+ than the large pile, poll from the max and add to
  // the larger pile.
  // when retrieving the median, return the max from
  // max queue if max's size is larger
  // return (max+min)/2.0 if sizes are equal

  PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
  PriorityQueue<Integer> minQueue = new PriorityQueue<>();

  public void addNum(int num) {
    // WRITE YOUR BRILLIANT CODE HERE
    if (maxQueue.isEmpty() || num < maxQueue.peek()) {
      maxQueue.add(num);
    } else {
      minQueue.add(num);
    }

    // maintain the balance of the queues
    if (maxQueue.size() - minQueue.size() > 1) {
      minQueue.add(maxQueue.poll());
    } else if (minQueue.size() > maxQueue.size()) {
      maxQueue.add(minQueue.poll());
    }

  }

  public double getMedian() {

    if (maxQueue.isEmpty() && minQueue.isEmpty()) {
      return 0.0;
    }

    if (minQueue.isEmpty()) {
      return maxQueue.peek();
    }

    if (maxQueue.size() > minQueue.size()) {
      return maxQueue.peek();
    }

    return (maxQueue.peek() + minQueue.peek()) / 2.0;

  }
}
