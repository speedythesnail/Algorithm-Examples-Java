/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.mst;

/**
 * This class represents an edge in a graph for the purpose of Minimum Spanning Tree (MST) algorithms.
 * Each edge has a source vertex, a destination vertex, and a weight.
 * The class implements the Comparable interface to allow for sorting of edges based on their weight.
 */
class Edge implements Comparable<Edge> {
    /**
     * The source vertex of the edge.
     */
    int src;

    /**
     * The destination vertex of the edge.
     */
    int dest;

    /**
     * The weight of the edge.
     */
    int weight;

    /**
     * Comparator function used for sorting edges based on their weight.
     *
     * @param compareEdge The edge to compare with.
     * @return A negative integer, zero, or a positive integer as this edge's weight is less than, equal to, or greater than the specified edge's weight.
     */
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}
