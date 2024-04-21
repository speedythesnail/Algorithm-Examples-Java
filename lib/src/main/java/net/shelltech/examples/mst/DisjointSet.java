/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.mst;

// Class to represent a disjoint set
class DisjointSet {
    int[] rank;
    int[] parent;
    int n;

    // Constructor
    public DisjointSet(int n) {
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        makeSet();
    }

    // Create n sets with single item in each
    void makeSet() {
        for (int i = 0; i < n; i++) {
            // Initially, all elements are in their own set.
            parent[i] = i;
        }
    }

    // Returns representative of x's set
    int find(int x) {
        // Finds the representative of the set that x is an element of
        if (parent[x] != x) {
            // If x is not the parent of itself, then x is not the representative of his set.
            parent[x] = find(parent[x]);
        }

        // So we recursively call Find on the parent of x and then assign it to the parent of x.
        return parent[x];
    }

    // Unites the set that includes x and the set that includes y
    void union(int x, int y) {
        // Find representatives (or the root nodes) for x an y.
        int xRoot = find(x), yRoot = find(y);

        // Elements are in the same set, no need to unite anything.
        if (xRoot == yRoot) return;

        // If x's rank is less than y's rank
        if (rank[xRoot] < rank[yRoot])

            // Then move x under y so that depth of tree remains less
            parent[xRoot] = yRoot;
        else if (rank[yRoot] < rank[xRoot])

            // Else move y under x so that depth of tree remains less
            parent[yRoot] = xRoot;
        else { // if ranks are the same
            // Then move y under x (doesn't matter which one goes where)
            parent[yRoot] = xRoot;

            // And increment the the result tree's rank by 1
            rank[xRoot] = rank[xRoot] + 1;
        }
    }
}
