/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.graph;

public class FloydWarshallAlgorithm {
    static final int INF = 99999, V = 4;

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
