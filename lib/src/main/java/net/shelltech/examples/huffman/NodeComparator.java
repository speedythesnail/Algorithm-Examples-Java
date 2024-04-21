/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.huffman;

import java.util.Comparator;

/**
 * This class implements the Comparator interface and is used for comparing two HuffmanNode objects.
 * It is primarily used in the context of a priority queue where HuffmanNodes are sorted based on their frequency.
 */
public class NodeComparator implements Comparator<HuffmanNode> {
    /**
     * This method compares two HuffmanNode objects based on their frequency.
     *
     * @param node1 The first HuffmanNode to be compared.
     * @param node2 The second HuffmanNode to be compared.
     * @return A negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     */
    public int compare(HuffmanNode node1, HuffmanNode node2) {
        return node1.frequency - node2.frequency;
    }
}
