package com.problems.practice.tree;

/**
 * A basic representation of a Binary Tree.
 * @author bbolla
 *
 */
public class TreeNode {
	
	private Comparable val;
	private TreeNode left;
	private TreeNode right;
	
	
	/**
	 * Constructs a new {@link TreeNode} from leftNode, value, rightNode 
	 * @param left
	 * @param val
	 * @param right
	 */
	public TreeNode(TreeNode left, Comparable val, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	
	/**
	 * Constructs a new {@link TreeNode} from value 
	 * @param val
	 */
	public TreeNode(Comparable val) {
		this.val = val;
		this.left = this.right = null;
	}

}
