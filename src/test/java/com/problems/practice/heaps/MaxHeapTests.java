package com.problems.practice.heaps;

import static org.junit.Assert.*;

import org.junit.Test;

import com.problems.Logger;

public class MaxHeapTests {

	@Test
	public void test() {
		
		Comparable[] elements = new Comparable[]{15, 14, 13, 2, 2, 10, 24};
		MaxHeap heap = new MaxHeap(elements);
		
		Comparable removedElement = heap.deleteMax();
		Logger.debug(removedElement);
	}

}
