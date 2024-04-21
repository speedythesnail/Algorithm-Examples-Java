/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.huffman;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Utility class for Huffman Coding.
 * This class provides static methods for building a Huffman tree and generating Huffman codes.
 * This class is not meant to be instantiated.
 *
 * @author ShellTech.net
 * @version 1
 */
public class HuffmanCoding {
    /**
     * Private constructor to prevent instantiation.
     * @throws UnsupportedOperationException if called
     */
    private HuffmanCoding() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    /**
     * Builds a Huffman tree and generates Huffman codes for the given character frequencies.
     *
     * @param charArray array of characters to be encoded
     * @param charFreq corresponding frequencies of characters
     * @return a map of characters to their corresponding Huffman codes
     */
    public static Map<Character, String> buildHuffmanTree(char[] charArray, int[] charFreq) {
        System.out.println("Building Huffman Tree...");
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(new NodeComparator());

        // Create a node for each character and add it to the priority queue.
        for (int i = 0; i < charArray.length; i++) {
            HuffmanNode node = new HuffmanNode();
            node.data = charArray[i];
            node.frequency = charFreq[i];
            queue.add(node);
            System.out.println("Added node for character: " + node.data + " with frequency: " + node.frequency);
        }

        // Build the Huffman tree by continually removing the two nodes
        // with the lowest frequency and combining them into a new node
        while (queue.size() > 1) {
            HuffmanNode x = queue.poll();
            HuffmanNode y = queue.poll();

            HuffmanNode sum = new HuffmanNode();
            sum.frequency = x.frequency + y.frequency;
            sum.left = x;
            sum.right = y;
            queue.add(sum);
            System.out.println(
                    "Combined nodes " + x.data + " and " + y.data + " into new node with frequency: " + sum.frequency);
        }

        // Generate the Huffman codes
        System.out.println("Generating Huffman codes...");
        Map<Character, String> huffmanCodes = new HashMap<>();
        generateCodes(queue.peek(), "", huffmanCodes);

        System.out.println("Huffman codes generated successfully!");

        return huffmanCodes;
    }

    /**
     * Recursively generates Huffman codes for the given node and adds them to the given map.
     *
     * @param node the current node in the Huffman tree
     * @param code the current Huffman code
     * @param huffmanCodes a map of characters to their corresponding Huffman codes
     */
    public static void generateCodes(HuffmanNode node, String code, Map<Character, String> huffmanCodes) {
        if (node.left == null && node.right == null) {
            huffmanCodes.put(node.data, code);
            System.out.println("Generated code for character: " + node.data + " Code: " + code);
            return;
        }

        generateCodes(node.left, code + "0", huffmanCodes);
        generateCodes(node.right, code + "1", huffmanCodes);
    }
}
