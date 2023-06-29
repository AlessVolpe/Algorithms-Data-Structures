package MST.PrimJarvik;

import java.util.List;

// Main class
class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Create vertices
        Vertex v0 = new Vertex(0, Integer.MAX_VALUE);
        Vertex v1 = new Vertex(1, Integer.MAX_VALUE);
        Vertex v2 = new Vertex(2, Integer.MAX_VALUE);
        Vertex v3 = new Vertex(3, Integer.MAX_VALUE);

        // Add vertices to the graph
        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);

        // Create edges
        graph.addEdge(v0, v1, 4);
        graph.addEdge(v0, v2, 3);
        graph.addEdge(v1, v2, 1);
        graph.addEdge(v1, v3, 2);
        graph.addEdge(v2, v3, 4);

        // Run Prim's algorithm
        PrimJarnik primJarnik = new PrimJarnik();
        List<Edge> minimumSpanningTree = primJarnik.prim(graph);

        System.out.println("Prim-Jarnik's Implementation");
        System.out.println("S -- D : W");
        // Print the minimum spanning tree
        for (Edge edge : minimumSpanningTree) {
            System.out.println(edge.src.id + " -- " + edge.dest.id + " : " + edge.weight);
        }
    }
}
