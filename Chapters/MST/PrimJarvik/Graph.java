package MST.PrimJarvik;

import java.util.*;

// Class representing the graph
class Graph {
    List<Vertex> vertices;
    List<Edge> edges;

    Graph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    void addEdge(Vertex src, Vertex dest, int weight) {
        Edge edge = new Edge(src, dest, weight);
        edges.add(edge);
    }
}
