package com.problems.practice.unionfind;

/**
 * This is an improvement over the {@link QuickUnion} by considering the weights of each parent before assigning a parent's parent in the union
 * step
 * 
 * This is a better solution and reduces the find operation (cost of finding the parents) by maintain an additional array.
 * 
 * Improvements that can be made: 
 * 	1. Path Compression => Once you find the parent of a node if we actually change the value of parent to directly point to the parent; we will get a more flat tree
 *  2. Path Halving => Find can be improved to include path halving. That is update the parent for node with the grand parent by adding one more line in find's code.
 * @author bbolla
 *
 */
public class UnionFindWithWeights extends QuickUnion {
	
	private int[] parentWeights;

	public UnionFindWithWeights(int capacity) {
		super(capacity);
		this.parentWeights = new int[capacity]; //Let it initialized to 0
	}
	
	@Override
	public void union(int a, int b) {
		int parentOf_a = find(a);
		int parentOf_b = find(b);
		if(parentOf_a != parentOf_b) { //not already connected
			if(parentWeights[parentOf_a] >= parentWeights[parentOf_b]) {
				this.flatTree[parentOf_b] = parentOf_a;
				parentWeights[parentOf_a] += 1;
			} else {
				this.flatTree[parentOf_a] = parentOf_b;
				parentWeights[parentOf_b] += 1;
			}
		}
	}

}

