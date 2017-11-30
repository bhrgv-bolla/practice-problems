package com.problems.practice.tree;

/**
 * A basic representation of a Binary Tree.
 * @author bbolla
 *
 */
public class TreeNode<T extends Comparable<T>> {
	
	private T val;
	private TreeNode<T> left;
	private TreeNode<T> right;
	
	
	/**
	 * Constructs a new {@link TreeNode} from leftNode, value, rightNode 
	 * @param left
	 * @param val
	 * @param right
	 */
	public TreeNode(TreeNode<T> left, T val, TreeNode<T> right) {
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
	public TreeNode<T> left() {
		return this.left;
	}
	
	/**
	 * Returns rightTreeNode
	 * @return
	 */
	public TreeNode<T> right() {
		return this.right;
	}
	
	/**
	 * Returns the val of the current Node.
	 * @return
	 */
	public T val() {
		return this.val;
	}
	

}
