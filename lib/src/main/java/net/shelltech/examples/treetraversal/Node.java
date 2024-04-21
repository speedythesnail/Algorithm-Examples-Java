/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.treetraversal;

/**
 * This class represents a node in a binary tree.
 * Each node has a value and two children: left and right.
 */
public class Node {
    /**
     * The value stored in this node.
     */
    int value;

    /**
     * The left child of this node.
     */
    Node left;

    /**
     * The right child of this node.
     */
    Node right;

    /**
     * Constructor for the Node class.
     * Initializes the node with a value and sets the left and right children to null.
     *
     * @param item The value to be stored in this node.
     */
    public Node(int item) {
        value = item;
        left = right = null;
    }
}
