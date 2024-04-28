package test;

import src.AdjacencyListGraph;

import java.util.List;

public class AdjacencyListGraphTest {

    public static void main(String[] args) {
        testGraph();
        testBFS();
        testDFS();
        testDijkstra();
    }

    public static void testGraph() {
        AdjacencyListGraph graph = new AdjacencyListGraph();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        System.out.println("Graph representation:");
        graph.printGraph();
        System.out.println();
    }

    public static void testBFS() {
        AdjacencyListGraph graph = new AdjacencyListGraph();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        System.out.println("BFS traversal:");
        List<Integer> bfsPath = graph.bfs(1, 3);
        System.out.println("Path from 1 to 3: " + bfsPath);
        System.out.println();
    }

    public static void testDFS() {
        AdjacencyListGraph graph = new AdjacencyListGraph();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        System.out.println("DFS traversal:");
        List<Integer> dfsPath = graph.dfs(1, 3);
        System.out.println("Path from 1 to 3: " + dfsPath);
        System.out.println();
    }

    public static void testDijkstra() {
        AdjacencyListGraph graph = new AdjacencyListGraph();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        System.out.println("Shortest paths using Dijkstra's algorithm:");
        List<Integer> dijkstraPath = graph.dijkstra(1, 3);
        System.out.println("Shortest path from 1 to 3: " + dijkstraPath);
        System.out.println();
    }
}
