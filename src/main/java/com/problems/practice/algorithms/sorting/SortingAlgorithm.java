package com.problems.practice.algorithms.sorting;

/**
 * Every sorting algorithm.
 * @author bbolla
 *
 */
public interface SortingAlgorithm {
	
	/**
	 * Sorts the original array. 
	 * Side Effect : Modifies /sorts the input
	 * @param arrayToBeSorted
	 * @return
	 */
	Comparable[] sort(Comparable [] arrayToBeSorted);

}
