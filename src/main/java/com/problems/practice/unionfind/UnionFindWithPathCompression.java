package com.problems.practice.unionfind;


/**
 * Path Compression and Path Halving improve the find method.
 * Path Compression : After using find operation for finding the parent of a node. Assign that parent to the node.
 * Path Halving : Assign the grandparent to the node.
 * @author bbolla
 *
 */
public class UnionFindWithPathCompression extends UnionFindWithWeights {
	
	
	public UnionFindWithPathCompression(int capacity) {
		super(capacity);
	}
	
	@Override
	public int find(int a) {
		int temp = a;
		while(this.flatTree[temp] != temp) {
			this.flatTree[temp] = this.flatTree[this.flatTree[temp]]; //Path Halving.
			temp = this.flatTree[temp];
		}
		this.flatTree[a] = temp; //Path Compression.
		return temp;
	}
	

}
