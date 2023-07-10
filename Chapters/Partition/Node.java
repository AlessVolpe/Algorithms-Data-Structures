package Partition;

import java.util.LinkedList;

public class Node<V> implements Cloneable {
    public enum Status {UNEXPLORED, EXPLORED, EXPLORING}

    protected V value;
    protected LinkedList<Node<V>> outEdges;

    protected Status state; // tiene traccia dello stato di esplorazione
    protected int map; // utile in partition union e find
    protected int timestamp; // utile per associare valori interi ai vertici
    protected int dist; // utile per memorizzare distanze in algoritmi per cammini minimi

    @Override
    public String toString() {
        return "Node [value=" + value + ", state=" + state + "]";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}