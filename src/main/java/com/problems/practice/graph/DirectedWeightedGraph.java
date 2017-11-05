package com.problems.practice.graph;

import java.util.List;

/**
 * A simple Graph Data Structure for Weighted Direced Graphs
 * @author bbolla
 *
 */
public class DirectedWeightedGraph {
	
	int numVertices;
	WeightedEdge[] edges;
	
	
	/**
	 * Constructs a new directed weighted graph.
	 * @param numVertices
	 * @param edges
	 */
	DirectedWeightedGraph(int numVertices, WeightedEdge[] edges) {
		this.numVertices = numVertices;
		this.edges = edges;
	}

}
