package com.problems.practice.algorithms.sorting;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.problems.Logger;

public class SortingTests {

	@Test
	public void testSorting() {
		SortingAlgorithm sortingAlgorithm = new MergeSort();
		Integer[] arrayToBeSorted = new Integer[]{1, 5, 6, 2, 7, 1, 3, 4, 5, 1, 1000, 12433};
		sortingAlgorithm.sort(arrayToBeSorted);
		Logger.debug(Arrays.toString(arrayToBeSorted));
	}

}
