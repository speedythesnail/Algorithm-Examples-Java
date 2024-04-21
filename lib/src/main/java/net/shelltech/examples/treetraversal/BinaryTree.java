/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.treetraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This class represents a binary tree.
 * It provides methods for pre-order, in-order, post-order, and level-order tree traversal.
 */
class BinaryTree {
    /**
     * The root node of the binary tree.
     */
    Node root;

    /**
     * A method for the pre-order tree traversal.
     * In this traversal method, the root node is visited first, then the left subtree, and finally the right subtree.
     *
     * @param node The root node of the tree to be traversed.
     * @return A list of nodes in the order they were visited.
     */
    List<Integer> preOrder(Node node) {
        List<Integer> result = new ArrayList<>();
        if (node == null) return result;

        // First add the data of node (root)
        result.add(node.value);

        // Then recur on left subtree
        result.addAll(preOrder(node.left));

        // Now recur on right subtree
        result.addAll(preOrder(node.right));

        return result;
    }

    /**
     * A wrapper over the recursive preOrder(Node) method.
     * This method initiates the pre-order traversal from the root of the tree.
     *
     * @return A list of nodes in the order they were visited.
     */
    List<Integer> preOrder() {
        return preOrder(root);
    }

    /**
     * Method to perform post-order traversal.
     * In this traversal method, the root node is visited last, after the left and right subtrees.
     *
     * @param node The root node of the tree to be traversed.
     * @return A list of nodes in the order they were visited.
     */
    List<Integer> postOrderTraversal(Node node) {
        List<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }

        // Traverse the left subtree
        result.addAll(postOrderTraversal(node.left));

        // Traverse the right subtree
        result.addAll(postOrderTraversal(node.right));

        // Visit the node by adding its value to the result list
        result.add(node.value);

        return result;
    }

    /**
     * A method for the in-order tree traversal.
     * In this traversal method, the root node is visited between the left and right subtrees.
     *
     * @param node The root node of the tree to be traversed.
     * @return A list of nodes in the order they were visited.
     */
    List<Integer> inOrder(Node node) {
        List<Integer> result = new ArrayList<>();
        if (node == null) return result;

        // First recur on left child
        result.addAll(inOrder(node.left));

        // Then add the data of node
        result.add(node.value);

        // Now recur on right child
        result.addAll(inOrder(node.right));

        return result;
    }

    /**
     * A wrapper over the recursive inOrder(Node) method.
     * This method initiates the in-order traversal from the root of the tree.
     *
     * @return A list of nodes in the order they were visited.
     */
    List<Integer> inOrder() {
        return inOrder(root);
    }

    /**
     * Method to perform level-order traversal.
     * In this traversal method, all nodes at a given depth (or level) are visited before the nodes at the next depth.
     *
     * @return A list of nodes in the order they were visited.
     */
    List<Integer> levelOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // Create a queue for level order traversal
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // Poll the node at the front of the queue and add it to the result
            Node node = queue.poll();
            result.add(node.value);

            // Add the left child to the queue if it exists
            if (node.left != null) {
                queue.add(node.left);
            }

            // Add the right child to the queue if it exists
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return result;
    }
}
