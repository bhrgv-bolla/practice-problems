package com.problems.practice.graph;

import java.util.Arrays;

import com.problems.Logger;

/**
 * Algorithm to find shortest paths in a graph with negative edges.
 * Reports if a negative cycle is found.
 * To find a cycle that exists in the graph the cycle must be reachable from teh source or the
 * graph must be a connected graph.
 * Complexity : O(VE) V:Vertics E:Edges 
 * @author bbolla
 *
 */
public class BellmanFord implements SingelSourceShortestPathAlgorithm {

	@Override
	public int[] findShortestPaths(int numVertices, WeightedEdge[] edges, int sourceVertex) {
		if(numVertices <= 0 || sourceVertex <0) return new int[]{};
		
		int[] distances = new int[numVertices];
		
		Arrays.fill(distances, Integer.MAX_VALUE);
		
		if(edges == null || edges.length == 0) {
			return distances;
		}
		
		distances[sourceVertex] = 0;
		for(int i=1; i<numVertices; i++) {
			for(WeightedEdge edge : edges) {
				relax(distances, edge);
			}
		}
		
		//Find the cycle.
		for(WeightedEdge edge : edges) {
			if(isBetterPath(distances, edge)) {
				Logger.debug("-ve Cycle detected while evaluating the edge : ", edge);
			}
		}
		
		return distances;
	}

	/**
	 * Relax the edge.
	 * @param distances
	 * @param edge
	 */
	private void relax(int[] distances, WeightedEdge edge) {
		if(isBetterPath(distances, edge)) {
			distances[edge.to()] = distances[edge.from()] + edge.weight();
		}
	}

	private boolean isBetterPath(int[] distances, WeightedEdge edge) {
		return distances[edge.to()] > distances[edge.from()] + edge.weight();
	}

}
