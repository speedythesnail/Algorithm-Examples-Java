/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.graph;

import java.util.*;

public class DijkstraAlgorithm {
    // Graph represented as an adjacency list
    private HashMap<Integer, List<Integer>> graph;

    public DijkstraAlgorithm() {
        this.graph = new HashMap<>();
    }

    // Method to add an edge to the graph
    public void addEdge(int node, int neighbour) {
        if (!graph.containsKey(node)) {
            graph.put(node, new ArrayList<>());
        }
        graph.get(node).add(neighbour);
    }

    // Method to perform Dijkstra's Algorithm from a given source node
    public int[] dijkstra(int[][] graph, int src) {
        int verticesCount = graph[0].length;

        // dist[i] will hold the shortest distance from src to i
        int[] dist = new int[verticesCount];

        // shortestPathTreeSet[i] will be true if vertex i is included in shortest path tree
        // or shortest distance from src to i is finalized
        boolean[] shortestPathTreeSet = new boolean[verticesCount];

        // Initialize all distances as INFINITE and shortestPathTreeSet[] as false
        for (int i = 0; i < verticesCount; i++) {
            dist[i] = Integer.MAX_VALUE;
            shortestPathTreeSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < verticesCount - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices not yet processed.
            // u is always equal to src in first iteration.
            int u = getMinimumDistanceVertex(dist, shortestPathTreeSet, verticesCount);

            // Mark the picked vertex as processed
            shortestPathTreeSet[u] = true;

            // Update dist value of the adjacent vertices of the picked vertex.
            for (int v = 0; v < verticesCount; v++) {
                // Update dist[v] only if is not in shortestPathTreeSet, there is an edge from u to v,
                // and total weight of path from src to v through u is smaller than current value of dist[v]
                if (!shortestPathTreeSet[v]
                        && graph[u][v] != 0
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // Return the constructed distance array
        return dist;
    }

    // A utility function to find the vertex with minimum distance value,
    // from the set of vertices not yet included in shortest path tree
    private static int getMinimumDistanceVertex(int[] dist, boolean[] shortestPathTreeSet, int verticesCount) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < verticesCount; v++) {
            if (!shortestPathTreeSet[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }
}
