package MST.Kruskal;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int V = 6; // Number of vertices
        Graph graph = new Graph(V);

        // Add edges to the graph
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);

        KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm();
        List<Edge> minimumSpanningTree = kruskalAlgorithm.kruskal(graph);
        List<Edge> minimumSpanningTreePQ = kruskalAlgorithm.kruskalPQ(graph);

        // Print the minimum spanning tree
        System.out.println("Simple Kruskal Implementation");
        System.out.println("S -- D : W");
        for (Edge edge : minimumSpanningTree) {
            System.out.println(edge.src + " -- " + edge.dest + " : " + edge.weight);
        }

        System.out.println("\nPQ-Based Kruskal Implementation");
        System.out.println("S -- D : W");
        for (Edge edge : minimumSpanningTreePQ) {
            System.out.println(edge.src + " -- " + edge.dest + " : " + edge.weight);
        }
    }
}
