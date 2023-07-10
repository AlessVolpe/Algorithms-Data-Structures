package MST.PrimJarvik;

// Class representing a vertex in the graph
class Vertex {
    int id;
    int key;
    boolean visited;
    Edge parent;

    Vertex(int id, int key) {
        this.id = id;
        this.key = key;
        this.visited = false;
        this.parent = null;
    }
}