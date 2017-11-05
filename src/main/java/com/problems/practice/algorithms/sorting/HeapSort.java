package com.problems.practice.algorithms.sorting;

import java.util.Arrays;

import com.problems.Logger;
import com.problems.practice.heaps.MaxHeap;

/**
 * HeapSort takes leverage of a MaxHeap to sort the elements in the natural
 * order. Also an inplace sorting algorithm. Once the heap is constructed the
 * top element is remved and kept at the end.
 * 
 * @author bbolla
 *
 */
public class HeapSort implements SortingAlgorithm {

	@Override
	public Comparable[] sort(Comparable[] arrayToBeSorted) {
		int heapSize = arrayToBeSorted.length;
		// Make sure the heap property is maintained at every node.
		for (int i = arrayToBeSorted.length - 1; i >= 0; i--) {
			heapify(arrayToBeSorted, i, heapSize);
		}
		Logger.debug("Should be a Max heap: ", Arrays.toString(arrayToBeSorted));
		
		for(int i=0; i<arrayToBeSorted.length-1; i++) {
			//delete the max. put the last element reduce the heapSize before calling heapify
			exchange(arrayToBeSorted, 0, heapSize-1);
			heapify(arrayToBeSorted, 0, --heapSize);
		}
		
		Logger.debug("Sorted array: ", Arrays.toString(arrayToBeSorted));
		
		return arrayToBeSorted;
	}

	private void heapify(Comparable[] arrayToBeSorted, int index, int heapSize) {
		if (index >= heapSize)
			return; // more than the heapSize
		if (index != 0) { // Then there will be a parent
			if (less(arrayToBeSorted, index / 2, index)) {
				exchange(arrayToBeSorted, index / 2, index);
				heapify(arrayToBeSorted, index / 2, heapSize);
			}
		}
		if (2 * index < heapSize) {
			int max = 2 * index;
			if (2 * index + 1 < heapSize) { // Two Children; check for max one
				if (less(arrayToBeSorted, 2 * index, 2 * index + 1)) {
					max++;
				}
			}
			//Check if it thre is a violation
			if (less(arrayToBeSorted, index, max)) {
				exchange(arrayToBeSorted, index, max);
				heapify(arrayToBeSorted, max, heapSize);
			}
		}
	}

	private void exchange(Comparable[] arrayToBeSorted, int i, int index) {
		Comparable temp = arrayToBeSorted[i];
		arrayToBeSorted[i] = arrayToBeSorted[index];
		arrayToBeSorted[index] = temp;
	}

	private boolean less(Comparable[] arrayToBeSorted, int i, int index) {
		return arrayToBeSorted[i].compareTo(arrayToBeSorted[index]) < 0;
	}

}
