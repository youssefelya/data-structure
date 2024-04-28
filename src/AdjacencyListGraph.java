package src;

import java.util.*;
import java.util.LinkedList;

class Node {
    int value;
    List<Node> neighbors;

    Node(int v) {
        this.value = v;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(Node neighbor) {
        this.neighbors.add(neighbor);
    }
}

public class AdjacencyListGraph {

    private List<Node> nodes;

    public AdjacencyListGraph() {

    }

    public void addNode(int val) {

    }

    public void addEdge(int source, int destination) {

    }

    public List<Integer> bfs(int start, int end) {
        return null;
    }

    public List<Integer> dfs(int start, int end) {
        return null;
    }

    public List<Integer> dijkstra(int start, int end) {
        return null;
    }

    public void printGraph() {
        for (Node node : nodes) {
            System.out.print("Node " + node.value + " neighbors: ");
            for (Node neighbor : node.neighbors) {
                System.out.print(neighbor.value + " ");
            }
            System.out.println();
        }
    }

}
