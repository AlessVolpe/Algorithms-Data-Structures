package Trees.DFS;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    List<List<Integer>> adjList = null;

    Graph(List<Edge>  edges, int n) {
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());

        for (Edge edge: edges) {
            int src = edge.source;
            int dest = edge.dest;
            
            // se è presente solo il primo allora è possibile cercare solo in profondità
            adjList.get(src).add(dest); 
            adjList.get(dest).add(src);
        }
    }
}
