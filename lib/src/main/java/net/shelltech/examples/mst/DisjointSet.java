/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.mst;

/**
 * This class represents a disjoint set data structure.
 * It provides operations for creating sets, finding the representative of a set, and uniting two sets.
 */
class DisjointSet {
    /**
     * The rank of each set, used to keep the tree balanced during union operations.
     */
    int[] rank;

    /**
     * The parent pointer for each element in the set.
     */
    int[] parent;

    /**
     * The total number of elements in the disjoint set.
     */
    int n;

    /**
     * Constructor for the DisjointSet class.
     * Initializes the rank and parent arrays and creates n sets with single item in each.
     *
     * @param n The total number of elements in the disjoint set.
     */
    public DisjointSet(int n) {
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        makeSet();
    }

    /**
     * Creates n sets with single item in each.
     * Initially, all elements are in their own set.
     */
    void makeSet() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    /**
     * Returns the representative of x's set.
     * Finds the representative of the set that x is an element of.
     *
     * @param x The element to find the representative for.
     * @return The representative of the set containing x.
     */
    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    /**
     * Unites the set that includes x and the set that includes y.
     * If the sets are already the same, no action is taken.
     * Otherwise, the two sets are combined and the rank is adjusted to keep the tree balanced.
     *
     * @param x An element in the first set to unite.
     * @param y An element in the second set to unite.
     */
    void union(int x, int y) {
        int xRoot = find(x), yRoot = find(y);

        if (xRoot == yRoot) return;

        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[yRoot] < rank[xRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
        }
    }
}
