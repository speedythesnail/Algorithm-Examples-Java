/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.treetraversal

import spock.lang.Specification

class BinaryTreeSpec extends Specification {

	def "test preOrder"() {
		setup:
		BinaryTree tree = new BinaryTree()
		tree.root = new Node(1)
		tree.root.left = new Node(2)
		tree.root.right = new Node(3)

		expect:
		tree.preOrder() == [1, 2, 3]
	}

	def "test postOrderTraversal"() {
		setup:
		BinaryTree tree = new BinaryTree()
		tree.root = new Node(1)
		tree.root.left = new Node(2)
		tree.root.right = new Node(3)

		expect:
		tree.postOrderTraversal(tree.root) == [2, 3, 1]
	}

	def "test inOrder"() {
		setup:
		BinaryTree tree = new BinaryTree()
		tree.root = new Node(1)
		tree.root.left = new Node(2)
		tree.root.right = new Node(3)

		expect:
		tree.inOrder() == [2, 1, 3]
	}

	def "test levelOrderTraversal"() {
		setup:
		BinaryTree tree = new BinaryTree()
		tree.root = new Node(1)
		tree.root.left = new Node(2)
		tree.root.right = new Node(3)

		expect:
		tree.levelOrderTraversal() == [1, 2, 3]
	}
}
