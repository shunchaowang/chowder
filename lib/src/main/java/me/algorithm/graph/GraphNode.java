package me.algorithm.graph;

public class GraphNode<K, V> {

  private final K key;
  private final V val;
  private boolean visited;


  public GraphNode(K key, V val) {
    this.key = key;
    this.val = val;
    visited = false;
  }

  public GraphNode(K key) {
    this.key = key;
    this.val = null;
    visited = false;
  }

  public K key() {
    return this.key;
  }

  public V val() {
    return this.val;
  }

  public void visited(boolean visited) {
    this.visited = visited;
  }

  public boolean isVisited() {
    return this.visited;
  }
}
