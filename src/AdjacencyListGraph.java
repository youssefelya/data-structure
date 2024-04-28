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
        this.nodes = new ArrayList<>();
    }

    public void addNode(int val) {
        nodes.add(new GraphNode(val));
    }

    public void addEdge(int source, int destination) {
        GraphNode sourceNode = getNode(source);
        GraphNode destNode = getNode(destination);
        if (sourceNode != null && destNode != null) {
            sourceNode.addNeighbor(destNode);
            // Uncomment the line below if the graph is undirected
            // destNode.addNeighbor(sourceNode);
        }
    }

    private GraphNode getNode(int val) {
        for (GraphNode node : nodes) {
            if (node.value == val) {
                return node;
            }
        }
        return null;
    }

    public List<Integer> bfs(int start, int end) {
        Map<GraphNode, GraphNode> parentMap = new HashMap<>();
        GraphNode startNode = getNode(start);
        GraphNode endNode = getNode(end);
        if (startNode == null || endNode == null)
            return null;

        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(startNode);
        parentMap.put(startNode, null);

        while (!queue.isEmpty()) {
            GraphNode current = queue.poll();
            if (current == endNode) {
                return getPath(parentMap, current);
            }
            for (GraphNode neighbor : current.neighbors) {
                if (!parentMap.containsKey(neighbor)) {
                    queue.offer(neighbor);
                    parentMap.put(neighbor, current);
                }
            }
        }
        return null; // No path found
    }

    public List<Integer> dfs(int start, int end) {
        Map<GraphNode, GraphNode> parentMap = new HashMap<>();
        GraphNode startNode = getNode(start);
        GraphNode endNode = getNode(end);
        if (startNode == null || endNode == null)
            return null;

        dfsHelper(startNode, endNode, parentMap);

        return getPath(parentMap, endNode);
    }

    private void dfsHelper(GraphNode current, GraphNode end, Map<GraphNode, GraphNode> parentMap) {
        if (current == end)
            return;

        for (GraphNode neighbor : current.neighbors) {
            if (!parentMap.containsKey(neighbor)) {
                parentMap.put(neighbor, current);
                dfsHelper(neighbor, end, parentMap);
            }
        }
    }

    public List<Integer> dijkstra(int start, int end) {
        PriorityQueue<GraphNode> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
        Map<GraphNode, Integer> distances = new HashMap<>();
        Map<GraphNode, GraphNode> parentMap = new HashMap<>();
        GraphNode startNode = getNode(start);
        GraphNode endNode = getNode(end);
        if (startNode == null || endNode == null)
            return null;

        distances.put(startNode, 0);
        pq.offer(startNode);

        while (!pq.isEmpty()) {
            GraphNode current = pq.poll();
            if (current == endNode) {
                return getPath(parentMap, current);
            }
            int currentDistance = distances.get(current);

            for (GraphNode neighbor : current.neighbors) {
                int newDistance = currentDistance + 1; // Assuming unweighted graph
                if (!distances.containsKey(neighbor) || newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    pq.offer(neighbor);
                    parentMap.put(neighbor, current);
                }
            }
        }

        return null; // No path found
    }

    private List<Integer> getPath(Map<GraphNode, GraphNode> parentMap, GraphNode endNode) {
        List<Integer> path = new ArrayList<>();
        GraphNode current = endNode;
        while (current != null) {
            path.add(current.value);
            current = parentMap.get(current);
        }
        Collections.reverse(path);
        return path;
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