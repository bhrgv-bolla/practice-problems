package com.problems.practice.graph;

/**
 * An extension to {@code Edge} to include weights.
 * Assumes Directed Graph. Add two edges for bidirectional.
 * @author bbolla
 *
 */
public class WeightedEdge extends Edge {
	
	private int weight;
	
	
	/**
	 * Constructs a weighted edge from a source node to a destination node. 
	 * @param from
	 * @param to
	 * @param weight
	 */
	public WeightedEdge(int from, int to, int weight) {
		super(from, to);
		this.weight = weight;
	}
	
	
	public int from() {
		return this.vertex;
	}
	
	public int to() {
		return this.otherVertex;
	}
	
	public int weight() {
		return this.weight;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(from());
		sb.append("--------(");
		sb.append(weight());
		sb.append(")-------->");
		sb.append(to());
		return sb.toString();
	}
	
	

}
