/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.mst;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class represents Kruskal's Algorithm on a graph.
 * The algorithm is used to find the Minimum Spanning Tree (MST) of a graph.
 */
class KruskalAlgorithm {
    /**
     * The number of vertices in the graph.
     */
    int V;

    /**
     * The number of edges in the graph.
     */
    int E;

    /**
     * Collection of all edges in the graph.
     */
    Edge[] edge;

    /**
     * Constructor for the KruskalAlgorithm class.
     * Initializes the graph with V vertices and E edges.
     *
     * @param v The number of vertices in the graph.
     * @param e The number of edges in the graph.
     */
    KruskalAlgorithm(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i) edge[i] = new Edge();
    }

    /**
     * The main function to construct MST using Kruskal's algorithm.
     * It finds the MST of the graph and returns it as a list of edges.
     *
     * @return A list of edges forming the MST.
     */
    ArrayList<Edge> KruskalMST() {
        // This will store the resultant MST
        ArrayList<Edge> mst = new ArrayList<>();

        // Sort all the edges in non-decreasing order of their weight.
        Arrays.sort(edge);

        // Allocate memory for creating V subsets
        DisjointSet ds = new DisjointSet(V);

        // Iterate through all sorted edges
        for (Edge next_edge : edge) {
            int x = ds.find(next_edge.src);
            int y = ds.find(next_edge.dest);

            // Check if the picked edge is creating a cycle
            // If cycle is not formed, include this edge. Else discard it.
            if (x != y) {
                mst.add(next_edge);
                ds.union(x, y);
            }
            // Else discard the next_edge
        }

        return mst;
    }
}
