/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.huffman

import spock.lang.Specification

class HuffmanCodingSpec extends Specification {

	def "test buildHuffmanTree"() {
		setup:
		char[] charArray = ['a', 'b', 'c', 'd', 'e', 'f']
		int[] charFreq = [5, 9, 12, 13, 16, 45]

		when:
		Map<Character, String> huffmanCodes = HuffmanCoding.buildHuffmanTree(charArray, charFreq)

		then: 'the returned map contains the correct Huffman codes'
		// Groovy is stupid so we have to do this to use
		// a char as a key instead of a String
		huffmanCodes['a' as char] == '1100'
		huffmanCodes['b' as char] == '1101'
		huffmanCodes['c' as char] == '100'
		huffmanCodes['d' as char] == '101'
		huffmanCodes['e' as char] == '111'
		huffmanCodes['f' as char] == '0'
	}
}
