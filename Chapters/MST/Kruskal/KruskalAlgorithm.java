package MST.Kruskal;

import java.util.*;

// Main class implementing Kruskal's algorithm
class KruskalAlgorithm {
    List<Edge> kruskal(Graph graph) {
        // Sort the edges by weight in non-decreasing order
        Collections.sort(graph.edges, Comparator.comparingInt(a -> a.weight));

        // Create disjoint sets for each vertex
        DisjointSet disjointSet = new DisjointSet(graph.V);

        // Initialize an empty minimum spanning tree
        List<Edge> minimumSpanningTree = new ArrayList<>();

        for (Edge edge : graph.edges) {
            int u = edge.src;
            int v = edge.dest;

            int uRoot = disjointSet.find(u);
            int vRoot = disjointSet.find(v);

            // Check if including this edge forms a cycle
            if (uRoot != vRoot) {
                minimumSpanningTree.add(edge);
                disjointSet.union(uRoot, vRoot);
            }
        }

        return minimumSpanningTree;
    }

    List<Edge> kruskalPQ(Graph graph) {
        // Create disjoint sets for each vertex
        DisjointSet disjointSet = new DisjointSet(graph.V);

        // Create a priority queue and insert all edges
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        pq.addAll(graph.edges);

        // Initialize an empty minimum spanning tree
        List<Edge> minimumSpanningTree = new ArrayList<>();

        while (!pq.isEmpty()) {
            // Get the edge with the minimum weight
            Edge edge = pq.poll();
            int u = edge.src;
            int v = edge.dest;

            // Check if including this edge forms a cycle
            if (disjointSet.find(u) != disjointSet.find(v)) {
                minimumSpanningTree.add(edge);
                disjointSet.union(u, v);
            }
        }

        return minimumSpanningTree;
    }
}