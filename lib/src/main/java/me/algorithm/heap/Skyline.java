package me.algorithm.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city
 * when viewed from a distance. Given the locations and heights of all the buildings, return the
 * skyline formed by these buildings collectively. The geometric information of each building is
 * given in the array buildings where buildings[i] = [lefti, righti, heighti]: lefti is the x
 * coordinate of the left edge of the ith building. righti is the x coordinate of the right edge of
 * the ith building. heighti is the height of the ith building. You may assume all buildings are
 * perfect rectangles grounded on an absolutely flat surface at height 0.
 * <p>
 * The skyline should be represented as a list of "key points" sorted by their x-coordinate in the
 * form [[x1,y1],[x2,y2],...]. Each key point is the left endpoint of some horizontal segment in the
 * skyline except the last point in the list, which always has a y-coordinate 0 and is used to mark
 * the skyline's termination where the rightmost building ends. Any ground between the leftmost and
 * rightmost buildings should be part of the skyline's contour.
 * <p>
 * Note: There must be no consecutive horizontal lines of equal height in the output skyline. For
 * instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is not acceptable; the three lines of height
 * 5 should be merged into one in the final output as such: [...,[2 3],[4 5],[12 7],...]
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]] Output:
 * [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]] Explanation: Figure A shows the buildings of
 * the input. Figure B shows the skyline formed by those buildings. The red points in figure B
 * represent the key points in the output list. Example 2:
 * <p>
 * Input: buildings = [[0,2,3],[2,5,3]] Output: [[0,3],[5,0]]
 * <p>
 * Constraints: 1 <= buildings.length <= 104 0 <= lefti < righti <= 231 - 1 1 <= heighti <= 231 - 1
 * buildings is sorted by lefti in non-decreasing order.
 */
public class Skyline {

  private record Point(boolean isStart, int x, Integer height) implements Comparable<Point> {

    /**
     * If we sort all the x points, we need to have the special order for these 3 scenarios: if the
     * point is the start for multi buildings, we should process from high to low buildings, this
     * will make sure lower buildings will not be added to the final result; if the point is both
     * start of the buildings and end of buildings, we should process the start first then end. this
     * will make sure when polling the end building, the (x, 0) will not be in the result; if the
     * point is the end for multi buildings, we should process from low to high buildings, this will
     * make sure when we remove higher buildings from the heap, the lower buildings should not be in
     * the result.
     * <p>
     * To make this work, we need to have a custom comparator for the points (x, y, Status.S|E).
     * When S &&  x1 == x2, we should sort by y2 - y1 when both are starts; when x1==x2, sort by
     * Status.E first then S; when x1==x2, sort by y1 - y2 when both are ends.
     */
    @Override
    public int compareTo(Point o) {
      if (this.x != o.x) {
        return Integer.compare(this.x, o.x);
      }

      // both are starts, higher first
      // if (this.isStart && o.isStart)
      //     return (-this.height) - (-o.height);
      // starts and end, start first
      // if (this.isStart && !o.isStart)
      //     return (-this.height) - o.height;
      // both are ends, lower first
      // if (!this.isStart && !o.isStart)
      //     return this.height - o.height;
      return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
    }
  }

  public static List<List<Integer>> getSkyline(int[][] buildings) {

    int l = buildings.length;
    Point[] points = new Point[l * 2];
    for (int i = 0; i < l; i++) {
      int s = buildings[i][0];
      int e = buildings[i][1];
      int h = buildings[i][2];
      points[2 * i] = new Point(true, s, h);
      points[2 * i + 1] = new Point(false, e, h);
    }
    Arrays.sort(points);

    // whenever a start point encountered, enqueue and update the max;
    // whenever an end point exits, dequeue and update the max
    // whenever the max changes, add the points to the result
    PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> (b - a));
    List<List<Integer>> result = new ArrayList<>();

    int max = 0;
    for (Point p : points) {
      if (p.isStart) {
        heap.offer(p.height);
        if (max != heap.peek()) {
          max = heap.peek();
          result.add(List.of(p.x, max));
        }
      } else {
        heap.remove(p.height);
        int curPeak = heap.isEmpty() ? 0 : heap.peek();
        if (max > curPeak) {
          max = curPeak;
          result.add(List.of(p.x, max));
        }
      }
    }

    return result;
  }
}
