package com.problems.practice.graph;

import java.util.Arrays;

import org.junit.Test;

import com.problems.Logger;

public class ShortestPathsTests {

	@Test
	public void test() {
		int numVertices = 5;
		WeightedEdge[] edges = new WeightedEdge[5];
		edges[0] = edge(0, 1, 1);
		edges[1] = edge(1,2, 2);
		edges[2] = edge(2, 3, 3);
		edges[3] = edge(3, 4, 4);
		edges[4] = edge(4, 2, -10);
		
		SingelSourceShortestPathAlgorithm shortestPathAlgo = new BellmanFord();
		
		int[] dist = shortestPathAlgo.findShortestPaths(numVertices, edges, 0);
		Logger.debug(Arrays.toString(dist));
	}

	private WeightedEdge edge(int i, int j, int k) {
		return new WeightedEdge(i, j, k);
	}

}
