package MST.Boruvka;

import java.util.*;

// Class representing the graph
class Graph {
    int V; // Number of vertices
    List<Edge> edges;

    Graph(int V) {
        this.V = V;
        edges = new ArrayList<>();
    }

    void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge(src, dest, weight);
        edges.add(edge);
    }
}
