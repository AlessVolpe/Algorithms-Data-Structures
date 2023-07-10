package MST.PrimJarvik;

// Class representing an edge in the graph
class Edge {
    Vertex src, dest;
    int weight;

    Edge(Vertex src, Vertex dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}