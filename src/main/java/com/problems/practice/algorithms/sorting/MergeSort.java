package com.problems.practice.algorithms.sorting;

import com.problems.Logger;

/**
 * It is a divide and conquer algorithm.
 * Divide the data into halves each time and work on the half.
 * While merging compare the two sorted arrays and merge them. 
 * 
 * The main methods you would need are :
 * 
 * 	1. Way to merge. => Checks two arrays and merges both.
 * 	2. Way to sort. => sort the subparts and calls merge.
 * @author bbolla
 *
 */
public class MergeSort implements SortingAlgorithm {
	
	/**
	 * Merge sort entry point method.
	 * Note : Modifies / Sorts the original array. 
	 * @param a
	 * @return
	 */
	public Comparable[] sort(Comparable[] arrayToBeSorted) {
		int lastIndex = arrayToBeSorted.length - 1;
		this.sort(arrayToBeSorted, 0, lastIndex);
		return arrayToBeSorted;
	}
	
	/**
	 * Merges two sorted arrays.
	 * @return
	 */
	private void merge(Comparable[] arrayToBeSorted
								, int sortedArray1_start, int sortedArray1_end
								, int sortedArray2_start, int sortedArray2_end) {
		Logger.debug(sortedArray1_start, sortedArray1_end, sortedArray2_start, sortedArray2_end);
		
		int auxLength = sortedArray2_end - sortedArray1_start + 1;
		Comparable[] aux = new Comparable[auxLength]; // Initialize it to the length of the subarray.
		
		for(int i=0, c_index1 = sortedArray1_start, c_index2 = sortedArray2_start
						; i<auxLength
						; i++) {
			
			if(c_index2 == -1 || (c_index1 != -1 && arrayToBeSorted[c_index1].compareTo(arrayToBeSorted[c_index2]) <= 0)) { //If the element is less than or equal this will be next element to go into the auxiliary array.
				aux[i] = arrayToBeSorted[c_index1];
				c_index1++;
				if(c_index1 > sortedArray1_end) {
					c_index1 = -1;
				} 
			} else { //The element from the second sorted array goes in.
				aux[i] = arrayToBeSorted[c_index2];
				c_index2++;
				if(c_index2 > sortedArray2_end) {
					c_index2 = -1;
				}
			}
			
		}
		
		/*
		 * Put everything in aux in the same order.
		 */
		for(int i=0; i<auxLength; i++) {
			arrayToBeSorted[sortedArray1_start + i] = aux[i];
		}
	}
	
	/**
	 * Helper to sort the sub-array. 
	 */
	private void sort(Comparable[] arrayToBeSorted, int startIndex, int lastIndex) {
		if(startIndex == lastIndex) {
			return; //This is just one element.
		}
		
		int midIndex = (lastIndex - startIndex) / 2;
		Logger.debug("Sorting sub array", startIndex, startIndex + midIndex
										, startIndex + midIndex + 1,  lastIndex);
		sort(arrayToBeSorted, startIndex, startIndex + midIndex);
		sort(arrayToBeSorted, startIndex + midIndex + 1, lastIndex);
		merge(arrayToBeSorted, startIndex, startIndex + midIndex
							, startIndex + midIndex + 1, lastIndex);
	}

}
