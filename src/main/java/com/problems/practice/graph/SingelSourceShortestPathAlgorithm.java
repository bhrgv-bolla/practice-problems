package com.problems.practice.graph;

/**
 * A general interface for single source shortest paths. 
 * @author bbolla
 *
 */
public interface SingelSourceShortestPathAlgorithm {
	
	/**
	 * Returns the distances from source vertex to all vertices. (shortest simple paths)
	 * Simple Path : No repeated vertices in the path
	 * @param numVertices
	 * @param edges
	 * @param sourceVertex
	 * @return
	 */
	int[] findShortestPaths(int numVertices, WeightedEdge[] edges, int sourceVertex);

}
