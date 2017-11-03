package com.problems.practice.algorithms.sorting;


/**
 * Quicksort is one of the fastest known sorting algorithms for average case. 
 * 
 * It is also called randomized quick sort. We Randomize the array before sorting to gaurentee the average case time. O(nlogn)
 * The worst case time how ever is O(n^2). And there is a very rare chance of that happening ( It happens when an array is already ordered?)
 * 
 * 
 * Core idea:
 * 	1. Pick a partitioning element. 
 *  2. Place the partitioning element in the correct position. 
 * @author bbolla
 *
 */
public class QuickSort implements SortingAlgorithm {

	@Override
	public Comparable[] sort(Comparable[] arrayToBeSorted) {

		//Add the base conditions. 
		if(arrayToBeSorted == null || arrayToBeSorted.length == 0) return arrayToBeSorted;
		else {
			//TODO randomize
			sort(arrayToBeSorted, 0, arrayToBeSorted.length - 1);
		}
		
		
		return arrayToBeSorted;
	}

	/**
	 * Sorting is all about placing the partition index in the right position 
	 * and then doing the same for the subarray.
	 * @param arrayToBeSorted
	 * @param partitionIndex
	 * @param lo
	 * @param hi
	 */
	private void sort(Comparable[] arrayToBeSorted, int lo, int hi) {
		if(hi <= lo) return;
		int partitionIndex = partition(arrayToBeSorted, lo, hi);
		sort(arrayToBeSorted, lo, partitionIndex - 1);
		sort(arrayToBeSorted, partitionIndex+1, hi);
	}

	private int partition(Comparable[] arrayToBeSorted, int lo, int hi) {
		if(lo == hi) return 0;
		int partitionIndex = lo;
		int i = lo;
		int j = hi+1;
		while(true) {
			while(arrayToBeSorted[++i].compareTo(arrayToBeSorted[partitionIndex]) < 0 ) {
				if(i==hi) break;
			}
			while(arrayToBeSorted[--j].compareTo(arrayToBeSorted[partitionIndex]) > 0 ) {
				if(j==lo) break;
			}
			if(i >= j) break;
			Comparable temp = arrayToBeSorted[i];
			arrayToBeSorted[i] = arrayToBeSorted[j];
			arrayToBeSorted[j] = temp;
		}
		Comparable temp = arrayToBeSorted[partitionIndex];
		arrayToBeSorted[partitionIndex] = arrayToBeSorted[j];
		arrayToBeSorted[j] = temp;
		return j; //new partition index. 
	}

}
