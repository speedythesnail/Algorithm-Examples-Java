/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.graph;

/**
 * This class represents Floyd Warshall Algorithm on a graph.
 * The algorithm is used to find the shortest paths between all pairs of vertices in a graph.
 */
public class FloydWarshallAlgorithm {
    // Maximum possible value, used as infinity
    static final int INF = 99999;
    // Number of vertices in the graph
    static final int V = 4;

    /**
     * Method to perform Floyd Warshall Algorithm on a given graph.
     * It finds the shortest paths between all pairs of vertices.
     *
     * @param graph The adjacency matrix representation of the graph.
     * @return A 2D array of minimum distances between all pairs of vertices.
     */
    public int[][] floydWarshall(int graph[][]) {
        int dist[][] = new int[V][V];
        int i, j, k;

        // Initialize the solution matrix same as input graph matrix.
        for (i = 0; i < V; i++) for (j = 0; j < V; j++) dist[i][j] = graph[i][j];

        // Pick all vertices one by one as the source
        for (k = 0; k < V; k++) {
            // Pick all vertices as destination for the above picked source
            for (i = 0; i < V; i++) {
                // If vertex k is on the shortest path from i to j, then update the value of dist[i][j]
                for (j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        // Return the constructed distance array
        return dist;
    }
}
