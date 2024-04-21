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

		then:
		huffmanCodes.get('a') != null
		huffmanCodes.get('b') != null
		huffmanCodes.get('c') != null
		huffmanCodes.get('d') != null
		huffmanCodes.get('e') != null
		huffmanCodes.get('f') != null
	}
}
