package com.problems.practice.unionfind;

import java.util.Arrays;

/**
 * Quick Union does the Union lazily, So the find method has some logic to find the parent. 
 * 1. Assigns the parent of one node to the other other component. So that the two components are now connected.
 * 2. However, in order to find the parent it is no more o(1) since you need to find the parent's parent until the parent is itself.
 * @author bbolla
 *
 */
public class QuickUnion implements UnionFindInterface {
	
	private int[] flatTree;
	
	/**
	 * Constructs a new {@link QuickUnion} given a capacity.
	 * @param capacity
	 */
	public QuickUnion(int capacity) {
		this.flatTree = new int[capacity];
		for(int i=0; i<this.flatTree.length; i++) {
			this.flatTree[i] = i;
		}
	}

	@Override
	public void union(int a, int b) {
		int parentOf_a = find(a);
		int parentOf_b = find(b);
		/*
		 * Now assign a's parent as b's parent.
		 */
		if(parentOf_a != parentOf_b) {
			this.flatTree[parentOf_b] = parentOf_a;
		}
	}

	@Override
	public int find(int a) {
		/**
		 * Go up the chain to find the parent for the component.
		 */
		int parent = a;
		while(this.flatTree[parent] != parent) {
			parent = this.flatTree[parent];
		}
		return parent;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(this.flatTree);
	}

}
