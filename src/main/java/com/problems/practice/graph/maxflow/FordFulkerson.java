package com.problems.practice.graph.maxflow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.problems.Logger;

/**
 * Max flow problem : Calculate the maximum flow in a di graph with capacity on edges.
 * 
 * Complexity : O((V+E) * MAX_FLOW)
 * @author bbolla
 *
 */
public class FordFulkerson {
	
	private int[] pathTo;
	private double[][] residualAdjMatrix;
	
	
	/**
	 * Finds Max flow in the graph.
	 * @param graph
	 * @param source
	 * @param target
	 * @return
	 */
	public double maxFlowInTheGraph(double[][] graph,  int source, int target) {
		double maxFlow = 0D;
		residualAdjMatrix = new double[graph.length][graph.length];
		/*
		 * Construct the residual matrix as same as initial graph 
		 */
		for(int i=0; i<graph.length; i++) {
			for(int j=0; j<graph.length; j++) {
				residualAdjMatrix[i][j] = graph[i][j];
			}
		}
		
		while(bfs(residualAdjMatrix, source, target)) { //A new path is discovered. 
			Logger.debug("Residual Matrix: ", Arrays.deepToString(residualAdjMatrix));
			double pathFlow = Double.MAX_VALUE;
			
			//Get the minimum capacity in the path.
			for(int i=target; i!=source; i=pathTo[i]) {
				pathFlow = Math.min(pathFlow, residualAdjMatrix[pathTo[i]][i]);
			}
			
			//Update the flow along the path. 
			for(int i=target; i!=source; i=pathTo[i]) {
				residualAdjMatrix[pathTo[i]][i] -= pathFlow; //Remove the flow from the capacity.
				residualAdjMatrix[i][pathTo[i]] += pathFlow; //Residual flow.
			}
			maxFlow += pathFlow;
		}
		
		
		return maxFlow;
	}


	/**
	 * BFS to find augmented paths. 
	 * @param graph
	 * @param source
	 * @param target
	 * @param pathTo
	 * @return
	 */
	private boolean bfs(double[][] graph, int source, int target) {
		// Initialize marked 
		boolean[] marked = new boolean[graph.length];
		Arrays.fill(marked, false);
		
		//Initialize pathTo
		pathTo = new int[graph.length];
		
		//Do BFS
		Queue<Integer> vertices = new LinkedList<>();
		
		vertices.offer(source);
		marked[source] = true;
		
		while(!vertices.isEmpty()) {
			int vertex = vertices.poll();
	
			//all adjacent vertices.
			for(int i=0; i<graph.length; i++) {
				if(!marked[i] && graph[vertex][i] > 0) {
					vertices.offer(i);
					marked[i] = true;
					pathTo[i] = vertex;
				}	
			}
		}
		
		return marked[target];
	}
	
	
	public static void main(String[] args) {
		// Let us create a graph shown in the above example
        double graph[][] =new double[][] { {0, 16, 13, 0, 0, 0},
                                     {0, 0, 10, 12, 0, 0},
                                     {0, 4, 0, 0, 14, 0},
                                     {0, 0, 9, 0, 0, 20},
                                     {0, 0, 0, 7, 0, 4},
                                     {0, 0, 0, 0, 0, 0}
                                   };
        FordFulkerson fordFulkerson = new FordFulkerson();
 
        Logger.debug("The maximum possible flow is ",
        		fordFulkerson.maxFlowInTheGraph(graph, 0, 5));
	}
	

}
