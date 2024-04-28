package src;

import java.util.*;
import java.util.LinkedList;

class GraphNode {
    int value;
    List<GraphNode> neighbors;

    GraphNode(int v) {
        this.value = v;
        this.neighbors = new ArrayList<>();
    }

    // Method to add a neighbor to the current node
    public void addNeighbor(GraphNode neighbor) {
        this.neighbors.add(neighbor);
    }
}

public class AdjacencyListGraph {

    private List<GraphNode> nodes;

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
        for (GraphNode node : nodes) {
            System.out.print("GraphNode " + node.value + " neighbors: ");
            for (GraphNode neighbor : node.neighbors) {
                System.out.print(neighbor.value + " ");
            }
            System.out.println();
        }
    }

}
