package com.problems.practice.algorithms.sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortingTests {

	@Test
	public void testSorting() {
		SortingAlgorithm sortingAlgorithm = new MergeSort();
		Integer[] arrayToBeSorted = new Integer[]{1, 6, 2, 3, 4};
		sortingAlgorithm.sort(arrayToBeSorted);
	}

}
