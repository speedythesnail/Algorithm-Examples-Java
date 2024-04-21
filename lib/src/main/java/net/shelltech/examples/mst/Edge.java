/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.mst;

// Class to represent an edge in the graph
class Edge implements Comparable<Edge> {
    int src;
    int dest;
    int weight;

    // Comparator function used for sorting edges based on their weight
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}
