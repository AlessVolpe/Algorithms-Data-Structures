package Trees;

public class Edge {
    int source, dest;
    boolean visited;
    
    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
        this.visited = false;
    }

    public boolean getVisited() {
        return this.visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
