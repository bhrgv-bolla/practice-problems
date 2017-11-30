package com.problems.practice.tree;

/**
 * A basic representation of a Binary Tree.
 * @author bbolla
 *
 */
public class TreeNode<T extends Comparable<T>> {
	
	private T val;
	private TreeNode left;
	private TreeNode right;
	
	
	/**
	 * Constructs a new {@link TreeNode} from leftNode, value, rightNode 
	 * @param left
	 * @param val
	 * @param right
	 */
	public TreeNode(TreeNode left, T val, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	
	/**
	 * Constructs a new {@link TreeNode} from value 
	 * @param val
	 */
	public TreeNode(T val) {
		this.val = val;
		this.left = this.right = null;
	}
	
	/**
	 * Returns leftTreeNode
	 * @return
	 */
	public TreeNode left() {
		return this.left;
	}
	
	/**
	 * Returns rightTreeNode
	 * @return
	 */
	public TreeNode right() {
		return this.right;
	}
	
	/**
	 * Returns the val of the current Node.
	 * @return
	 */
	public TreeNode val() {
		return this.val();
	}
	

}
