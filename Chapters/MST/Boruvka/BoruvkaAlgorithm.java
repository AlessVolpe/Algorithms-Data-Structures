package MST.Boruvka;

import java.util.*;

// Main class implementing Boruvka's algorithm
class BoruvkaAlgorithm {
    List<Edge> boruvka(Graph graph) {
        int n = graph.V; // Number of vertices

        // Create a subgraph T containing just the vertices of G
        List<Edge> minimumSpanningTree = new ArrayList<>();

        // Track the connected components
        int[] parent = new int[n];
        int[] cheapest = new int[n];

        // Initialize the parent and cheapest arrays
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            cheapest[i] = -1;
        }

        // Variable to keep track of the number of edges in T
        int numEdges = 0;

        while (numEdges < n - 1) {
            // Find the smallest weight edge from each component to another component
            for (Edge edge : graph.edges) {
                int u = edge.src;
                int v = edge.dest;
                int setU = find(parent, u);
                int setV = find(parent, v);

                if (setU != setV) {
                    if (cheapest[setU] == -1 || edge.weight < graph.edges.get(cheapest[setU]).weight) {
                        cheapest[setU] = graph.edges.indexOf(edge);
                    }

                    if (cheapest[setV] == -1 || edge.weight < graph.edges.get(cheapest[setV]).weight) {
                        cheapest[setV] = graph.edges.indexOf(edge);
                    }
                }
            }

            // Add the cheapest edges to the minimum spanning tree
            for (int i = 0; i < n; i++) {
                if (cheapest[i] != -1) {
                    Edge edge = graph.edges.get(cheapest[i]);
                    int u = edge.src;
                    int v = edge.dest;
                    int setU = find(parent, u);
                    int setV = find(parent, v);

                    if (setU != setV) {
                        minimumSpanningTree.add(edge);
                        numEdges++;
                        union(parent, setU, setV);
                    }

                    cheapest[i] = -1;
                }
            }
        }

        return minimumSpanningTree;
    }

    int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }

    void union(int[] parent, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);
        parent[xRoot] = yRoot;
    }
}