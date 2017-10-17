package com.problems.practice.unionfind;

/**
 * Union Find algorithm should solve the following algorithms
 * 	1. union(a, b) => To add a new connection
 * 	2. connect(a,b) => Returns boolean stating whether a, b are connected or not.
 * 	3. find(a) => Returns which component this node belongs to. If both of these belong to the same component then it is connected. 
 * @author bbolla
 *
 */
public interface UnionFindInterface {
	
	/**
	 * Adds connection between two nodes.
	 * @param a
	 * @param b
	 */
	void union(int a, int b);
	
	/**
	 * Returns whether two nodes are connected or not.
	 * @param a
	 * @param b
	 * @return
	 */
	default boolean isConnected(int a, int b) {
		int componentA = find(a);
		int componentB = find(b);
		return componentA == componentB;
	};
	
	/**
	 * Returns the parent component of a node.
	 * @param a
	 * @return
	 */
	int find(int a);
}
