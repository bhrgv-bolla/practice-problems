package com.problems.practice.graph;

import java.util.Arrays;

import com.problems.Logger;

/**
 * This is an all pairs shortest path algorithm It can work with negative
 * weights. Time Complexity : O(V^3)
 * 
 * @author bbolla
 *
 */
public class FloydWarshall {

	int[][] dist;
	int[][] paths;
	
	boolean negativeCycles;

	public FloydWarshall(DirectedWeightedGraph graph) {
		if (graph == null)
			throw new IllegalArgumentException("Graph cannot be null");

		dist = new int[graph.numVertices][graph.numVertices];
		paths = new int[graph.numVertices][graph.numVertices];
		negativeCycles = false;
		
		// Initialize dist
		for (int i = 0; i < graph.numVertices; i++) {
			for (int j = 0; j < graph.numVertices; j++) {
				if (i == j) {
					dist[i][j] = 0;
					paths[i][j] = i;
				} else {
					dist[i][j] = Integer.MAX_VALUE;
					paths[i][j] = -1; // No vertex
				}
			}
		}

		for (WeightedEdge edge : graph.edges) {
			paths[edge.from()][edge.to()] = edge.from();
			dist[edge.from()][edge.to()] = edge.weight();// update all the
															// distances.
		}

		calculateDistances(graph);

		Logger.debug(Arrays.deepToString(dist));

		Logger.debug(Arrays.deepToString(paths));
		
		Logger.debug("Negative Cycles, if true then floyd warshall is failed. the results are wrong. : ", negativeCycles);
	}

	public int[][] getDistances() {
		return dist;
	}

	public int[][] getPaths() {
		return paths;
	}

	/**
	 * Simple to calculate the all pairs shortest paths,
	 * 
	 * @param graph
	 */
	private void calculateDistances(DirectedWeightedGraph graph) {

		// Using k as the intermediate vertex.
		for (int k = 0; k < graph.numVertices; k++) {
			// Now if k is on the path b/w i and j update the shortest path
			// distance.
			for (int i = 0; i < graph.numVertices; i++) {
				for (int j = 0; j < graph.numVertices; j++) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE)
							continue;
						else {
							paths[i][j] = k; // in b/w node.
							dist[i][j] = dist[i][k] + dist[k][j];
						}
					}
					
					if(dist[i][j] < 0) negativeCycles = true;
				}
				
			}
		}
	}

}
