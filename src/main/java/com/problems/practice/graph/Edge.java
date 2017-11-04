package com.problems.practice.graph;


/**
 * A simple representation of an edge in a graph.
 * @author bbolla
 *
 */
class Edge {
	
	protected int vertex;
	protected int otherVertex;

	protected Edge(int vertex, int otherVertex) {
		this.vertex = vertex;
		this.otherVertex = otherVertex;
	}
}
