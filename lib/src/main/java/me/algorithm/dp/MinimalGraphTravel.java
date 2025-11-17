package me.algorithm.dp;

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

  // we can use bitmask to store the status of the nodes, 1 means visited, 0 means not visited
  // there will not be more than 15 nodes, so we need at most 15 bits for the node status
  // the step to check node's status is taking 2^n time.
  // if the graph only contains 1 node, the cost should be 0, this is the edge case.
  // for each node cur, the cost should be the min of all neighbor's cost + from 0 to neighbor's cost.
  // we can use dp to solve this dfs problem.
  // each node has at most n neighbors, so the time complexity is n^2, adding the bitmask check of 2^n
  // O(n^2 + 2^n)
  // the max cost if 1000*14
  public int minCostToVisitEveryNode(List<List<Integer>> graph) {
    int[][] dp = new int[1 << graph.size()][graph.size()];

    int ans = dfs(1, 0, graph, dp);
    return ans == 14 * 1000 ? -1 : ans;
  }

  private int dfs(int bitmask, int cur, List<List<Integer>> graph, int[][] dp) {
    // 1 << cur is to shift 1 left cur positions, the bitmask with cur visited
    // the starting point is bitmask 1 with cur at 0
    if (bitmask == (1 << graph.size()) - 1) { // single node. 1 << 1 is 10, -1 becomes 01
      return 0;
    }

    if (dp[bitmask][cur] != 0) {
      return dp[bitmask][cur];
    }

    int ans = 14 * 1000;
    for (int i = 0; i < graph.get(cur).size(); i++) {
      // if i has been visited before, and there is edge between i and cur
      if (graph.get(cur).get(i) != 0 && (bitmask & (1 << i)) == 0) {
        ans = Math.min(ans, dfs(bitmask | (1 << i), i, graph, dp) + graph.get(cur).get(i));
      }
    }
    dp[bitmask][cur] = ans;
    return ans;
  }
}
