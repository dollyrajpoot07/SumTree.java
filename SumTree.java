// Write a function that returns true if the given Binary Tree is SumTree else false. 
// A SumTree is a Binary Tree where the value of a node is equal to the sum of the nodes present 
// in its left subtree and right subtree. An empty tree is SumTree and the sum of an empty tree 
// can be considered as 0. A leaf node is also considered as SumTree.

//           26
//         /   \
//       10     3
//     /    \     \
//   4      6      3


import java.io.*;

class Node {
	int data;
	Node left, right, nextRight;

	Node(int item)	{
		data = item;
		left = right = null;
	}
}
class SumTree {
	public static Node root;

	static int sum(Node node)	{
		if(node == null) {
			return 0;
		}
		return (sum(node.left) + node.data+sum(node.right));
	}
	static int isSumTree(Node node) {
		int ls,rs;

		if(node == null || (node.left == null && node.right == null)) {
			return 1;
		}

		ls = sum(node.left);
		rs = sum(node.right);

		if((node.data == ls + rs) && isSumTree(node.left) != 0 && isSumTree(node.right) != 0) {
			return 1;
		}
		return 0;
	}

	public static void main (String[] args) 	{
		BinaryTree tree=new BinaryTree();
		tree.root=new Node(26);
		tree.root.left=new Node(10);
		tree.root.right=new Node(3);
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(6);
		tree.root.right.right=new Node(3);
		if(isSumTree(root) != 0) {
			System.out.println("The given tree is a SumTree");
		}
		else {
			System.out.println("The given tree is not a SumTree");
		}
	}
}
