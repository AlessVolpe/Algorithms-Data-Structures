package MST.PrimJarvik;

import java.util.*;

public class PrimJarnik {
    List<Edge> prim(Graph graph) {
        // Create a heap-based priority queue
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.key));

        // Select a starting vertex
        Vertex s = graph.vertices.get(0);

        for (Vertex v : graph.vertices) {
            if (v == s) {
                v.key = 0;
            } else {
                v.key = Integer.MAX_VALUE;
            }
            v.visited = false;
            v.parent = null;
            pq.add(v);
        }

        while (!pq.isEmpty()) {
            Vertex u = pq.poll();
            u.visited = true;

            for (Edge e : graph.edges) {
                if (e.src == u || e.dest == u) {
                    Vertex z = (e.src == u) ? e.dest : e.src;

                    if (!z.visited && e.weight < z.key) {
                        z.key = e.weight;
                        z.parent = e;
                        pq.remove(z);
                        pq.add(z);
                    }
                }
            }
        }

        List<Edge> minimumSpanningTree = new ArrayList<>();
        for (Vertex v : graph.vertices) {
            if (v.parent != null) {
                minimumSpanningTree.add(v.parent);
            }
        }
        return minimumSpanningTree;
    }
}
