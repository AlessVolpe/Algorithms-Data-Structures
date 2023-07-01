package June23.JavaAux;

import java.util.*;

public class GraphServices {

	public static <V> void distances(Graph<V> g) {
		for (Graph.Node<V> node : g.getNodes()) 
			node.state = Graph.Node.Status.UNEXPLORED;
		for (Graph.Node<V> node : g.getNodes()) {
			if (node.state == Graph.Node.Status.UNEXPLORED)
				distancesAUX(g, node);
		}
	}

	public static <V> void distancesAUX(Graph<V> g, Graph.Node<V> node) {
		LinkedList<Graph.Node<V>> queue = new LinkedList<Graph.Node<V>>();
		LinkedList<Graph.Node<V>> path = new LinkedList<Graph.Node<V>>();
		int distance = 0, 
			outNeighborCount = 0; 

		node.timestamp = distance;
		node.state = Graph.Node.Status.EXPLORED;
		queue.add(node);

		while (!queue.isEmpty()) {
			Graph.Node<V> extractedNode = queue.remove();
			path.add(extractedNode); // System.out.println(path.toString());

			if (outNeighborCount == 0) {
				outNeighborCount = g.getOutNeighbors(extractedNode).size() - 1;
				distance++;
			} else outNeighborCount--;
			
			for (Graph.Node<V> outNeighbor : g.getOutNeighbors(extractedNode)) {
				if (outNeighbor.state == Graph.Node.Status.UNEXPLORED) {
					outNeighbor.timestamp = distance;
					outNeighbor.state = Graph.Node.Status.EXPLORED;
					queue.add(outNeighbor);
				}
			}
		}

		printPath(path, node);
		g.resetStatus();
	}

	private static <V> void printPath(LinkedList<Graph.Node<V>> path, Graph.Node<V> node) {
		System.out.print("Nodo " + node.value + "--> {");
		for (Graph.Node<V> vertex : path) {
			if (path.indexOf(vertex) != path.size() - 1)
				System.out.print(vertex.value + ":" + vertex.timestamp + ",");
			else System.out.print(vertex.value + ":" + vertex.timestamp);
		}
		System.out.println("}");
	}
}

