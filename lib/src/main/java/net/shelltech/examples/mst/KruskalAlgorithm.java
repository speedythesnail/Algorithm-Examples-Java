/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.mst;

import java.util.ArrayList;
import java.util.Arrays;

class KruskalAlgorithm {
    int V, E; // V -> no. of vertices & E -> no.of edges
    Edge[] edge; // collection of all edges

    // Creates a graph with V vertices and E edges
    KruskalAlgorithm(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i) edge[i] = new Edge();
    }

    // The main function to construct MST using Kruskal's algorithm
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
