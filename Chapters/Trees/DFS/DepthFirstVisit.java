package Trees.DFS;

public class DepthFirstVisit {
    public static void DFS (Graph graph, int v, boolean[] discovered) {
        discovered[v] = true;
        System.out.print(v + " ");

        for (int u: graph.adjList.get(v)) {
            if (!discovered[u]) DFS(graph, u, discovered);
        }
    }
}
