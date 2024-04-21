/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.huffman;

/**
 * This class represents a node in the Huffman tree.
 * Each node contains a character, its frequency, and references to left and right child nodes.
 */
public class HuffmanNode {
    /**
     * The frequency of the character in the text to be encoded.
     */
    int frequency;

    /**
     * The character to be encoded.
     */
    char data;

    /**
     * The left child node in the Huffman tree.
     */
    HuffmanNode left;

    /**
     * The right child node in the Huffman tree.
     */
    HuffmanNode right;
}
