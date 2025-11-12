package me.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * a graph represented by adjacency list, both directed and undirected are supported.
 */
public class Graph<K, V> {

  private Map<GraphNode<K, V>, List<GraphNode<K, V>>> nodes;

  public Graph() {
    nodes = new HashMap<>();
  }

  public Graph(Map<GraphNode<K, V>, List<GraphNode<K, V>>> nodes) {
    this.nodes = nodes;
  }

  public static void main(String[] args) {

    // initialize a graph
    GraphNode<Character, Character> a = new GraphNode<>('a');
    GraphNode<Character, Character> b = new GraphNode<>('b');
    GraphNode<Character, Character> c = new GraphNode<>('c');
    GraphNode<Character, Character> d = new GraphNode<>('d');
    GraphNode<Character, Character> e = new GraphNode<>('e');
    GraphNode<Character, Character> f = new GraphNode<>('f');

    Map<GraphNode<Character, Character>, List<GraphNode<Character, Character>>> map = new HashMap<>();
    map.put(a, Arrays.asList(b, c));
    map.put(b, Arrays.asList(d));
    map.put(c, Arrays.asList(e));
    map.put(d, new ArrayList<>());
    map.put(e, Arrays.asList());
    map.put(f, Arrays.asList(d));

    Graph<Character, Character> graph = new Graph<>(map);

    // depth first traversal iteratively
    System.out.println("depth first traversal iteratively " + graph.depthFirstTraversal(a));
    graph.reset();
    System.out.println();
    System.out.println(
        "depth first traversal recursively " + graph.depthFirstTraversalRecursively(a));
    graph.reset();
    // breadth first traversal iteratively
    System.out.println();
    System.out.println("breadth first traversal iteratively " + graph.breadthFirstTraversal(a));
    // check if has path
    System.out.printf("can a reach to d %b\n", graph.hasPath(a, d));
    System.out.printf("can a reach to f %b\n", graph.hasPath(a, f));
  }

  public void reset() {
    Set<GraphNode<K, V>> keys = nodes.keySet();
    for (GraphNode<K, V> k : keys) {
      k.visited(false);
    }
  }

  // consider a directed graph
  // a -> c
  // |    |
  // >    >
  // b    e
  // |
  // >
  // d <- f
  // depth first travesal starts from a would be
  // a b d c e or a c e b d
  public List<K> depthFirstTraversal(GraphNode<K, V> start) {
    if (start == null) {
      return List.of();
    }
    // stack is used here
    List<K> l = new ArrayList<>();

    Deque<GraphNode<K, V>> stack = new LinkedList<>();
    stack.push(start);
    while (!stack.isEmpty()) {
      GraphNode<K, V> node = stack.pop();
      if (!node.isVisited()) {
        node.visited(true);
        l.add(node.key());
      }
      for (GraphNode<K, V> n : nodes.get(node)) {
        stack.push(n);
      }
    }

    return l;
  }

  public List<K> depthFirstTraversalRecursively(GraphNode<K, V> start) {

    if (start == null) {
      return List.of();
    }

    List<K> l = new ArrayList<>();

    if (!start.isVisited()) {
      start.visited(true);
      l.add(start.key());
    }

    // if start has connections traverse them
    for (GraphNode<K, V> n : nodes.get(start)) {
      l.addAll(depthFirstTraversalRecursively(n));
    }

    return l;
  }

  public List<K> breadthFirstTraversal(GraphNode<K, V> start) {
    if (start == null) {
      return List.of();
    }
    List<K> l = new ArrayList<>();
    // queue can be used here
    Queue<GraphNode<K, V>> queue = new LinkedList<>();
    queue.add(start);
    while (!queue.isEmpty()) {
      GraphNode<K, V> node = queue.poll();
      if (!node.isVisited()) {
        node.visited(true);
        l.add(node.key());
      }

      for (GraphNode<K, V> n : nodes.get(node)) {
        queue.add(n);
      }
    }
    return l;
  }

  public boolean hasPath(GraphNode<K, V> src, GraphNode<K, V> dest) {
    if (src == null || dest == null) {
      return false;
    }
    if (src.key() == dest.key()) {
      return true;
    }
    for (GraphNode<K, V> node : nodes.get(src)) {
      // recursively check from every neighbor
      return hasPath(node, dest);
    }
    return false;
  }

  //todo
  public int connectedComponent() {
    return 0;
  }

  //todo
  public int shortestPath(GraphNode<K, V> src, GraphNode<K, V> dest) {
    return -1;
  }

  public int countIsland() {
    return 0;
  }
}
