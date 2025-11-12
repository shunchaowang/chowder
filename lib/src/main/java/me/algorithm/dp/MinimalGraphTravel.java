package me.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Minimum Cost to Visit Every Node in a Graph Output the minimum cost to traverse every node in a
 * directed weighted graph. The graph will be in the form of a 2D list where each element [i,j] in
 * the array denotes the weight of the directed edge from i to j. If the value is 0, then the edge
 * doesn't exist. You do not have to end at the starting node. All edges are guaranteed to be in the
 * range [0,1000]; there will not be more than 15 nodes in the graph. The starting node will always
 * be node 0. If a solution does not exist, return -1.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * [ [0, 100, 100, 1], [0, 0, 100, 0], [0, 1, 0, 0], [0, 20, 1, 0] ]
 * <p>
 * <p>
 * Output:
 * <p>
 * 3
 * <p>
 * Explanation:
 * <p>
 * We need to traverse each node with the minimum possible cost.
 * <p>
 * Starting at node 0, we have the following possibilities:
 * <p>
 * 0 -> 3 -> 2 -> 1: Cost from 0 to 3 = 1 Cost from 3 to 2 = 1 Cost from 2 to 1 = 1 Total Cost = 3
 * Any direct route from node 0 to nodes 1 or 2 has a cost of 100, which is already much higher than
 * the previous total.
 * <p>
 * Another possible route could be:
 * <p>
 * 0 -> 3 -> 1 -> 2: Cost from 0 to 3 = 1 Cost from 3 to 1 = 20 Cost from 1 to 2 = 100 Total Cost =
 * 121 Given the above, the minimum cost to traverse every node in the graph is via the route 0 -> 3
 * -> 2 -> 1 with a total cost of 3.
 */
public class MinimalGraphTravel {

  private boolean allVisited(boolean[] visited) {

    for (boolean v : visited) {
      if (!v) {
        return false;
      }
    }

    return true;
  }

  private List<Integer> findNextNodes(List<Integer> node, boolean[] visited) {
    List<Integer> res = new ArrayList<Integer>();
    for (int i = 0; i < node.size(); i++) {
      if (node.get(i) != 0 && !visited[i]) {
        res.add(i);
      }
    }

    return res;
  }

  private int dfs(List<List<Integer>> graph, int start, int cost, boolean[] visited) {
    if (allVisited(visited)) {
      return cost;
    }

    List<Integer> node = graph.get(start);
    List<Integer> nextNodes = findNextNodes(node, visited);

    // no move available, -1
    if (nextNodes.isEmpty()) {
      return -1;
    }

    //all the next moves, we find the least one
    int ans = Integer.MAX_VALUE;
    visited[start] = true;
    for (Integer n : nextNodes) {
      // start with node n with the cost added
      int c = dfs(graph, n, cost + node.get(n), visited);
      if (c != -1) {
        ans = Math.min(ans, c);
      }
    }
    visited[start] = false;

    return ans;
  }

  //todo: fix this
  public int minCostToVisitEveryNode(List<List<Integer>> graph) {
    // WRITE YOUR BRILLIANT CODE HERE
    boolean[] visited = new boolean[graph.size()];
    return dfs(graph, 0, 0, visited);
  }
}
