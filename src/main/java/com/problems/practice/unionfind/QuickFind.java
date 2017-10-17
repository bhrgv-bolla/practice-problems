package com.problems.practice.unionfind;

import java.util.Arrays;

/**
 * Implements the eager find solution for union find.
 * Union Find needs to support two main functions. 
 * 
 * @author bbolla
 *
 */
public class QuickFind implements UnionFindInterface {
	
	private int[] flatTree;
	
	
	public QuickFind(int capacity) {
		this.flatTree = new int[capacity];
		for(int i=0; i < this.flatTree.length; i++) {
			this.flatTree[i] = i; //Parent
		}
	}	

	public void union(int a, int b) {
		int parentOf_a = find(a);
		int parentOf_b = find(b);
		
		if(parentOf_a == parentOf_b) {
			return;
		}
		
		/*
		 * Change the parent of all the nodes that had parentOf_b previously
		 * to parentOf_a
		 */
		for(int i=0; i<flatTree.length; i++) {
			if(flatTree[i] == parentOf_b) {
				flatTree[i] = parentOf_a;
			}
		}
	}

	public int find(int a) {
		return this.flatTree[a];
	}
	
	@Override
	public String toString() {
		return Arrays.toString(this.flatTree);
	}

}
