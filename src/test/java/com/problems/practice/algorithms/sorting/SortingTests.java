package com.problems.practice.algorithms.sorting;

import java.time.Duration;
import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import com.problems.Logger;

public class SortingTests {

	@Test
	public void testSorting() {
		SortingAlgorithm sortingAlgorithm = new QuickSort();
		Integer[] arrayToBeSorted = new Integer[]{1, 5, 6, 2, 7, 1, 3, 4, 5, 1, 1000, 12433};
		sortingAlgorithm.sort(arrayToBeSorted);
		Logger.debug(Arrays.toString(arrayToBeSorted));
	}
	
	
	@Test
	public void testSortingAlgorithm() {
		empericalSortingTests(new QuickSort());
	}
	
	
	public <T> void empericalSortingTests(SortingAlgorithm sortingAlgorithm) {
		long millis1000 = System.currentTimeMillis();
		sortingAlgorithm.sort(randomNIntegerArray(1000));
		millis1000 = System.currentTimeMillis() - millis1000;

		long millis1Million = System.currentTimeMillis();
		sortingAlgorithm.sort(randomNIntegerArray(1000000));
		millis1Million = System.currentTimeMillis() - millis1Million;

		long millis1Billion = System.currentTimeMillis();
		sortingAlgorithm.sort(randomNIntegerArray(10000000));
		millis1Billion = System.currentTimeMillis() - millis1Billion;
		
		Logger.debug(Duration.ofMillis(millis1000), Duration.ofMillis(millis1Million), Duration.ofMillis(millis1Billion));
	}
	
	
	/**
	 * Returns an array with random integers
	 * @param n
	 * @return
	 */
	public Integer[] randomNIntegerArray(int n) {
		Integer[] randomArray = new Integer[n];
		Random random = new Random();
		for(int i=0; i<n; i++) {
			randomArray[i] = Math.abs(random.nextInt());
		}
		return randomArray;
	} 
	

}
