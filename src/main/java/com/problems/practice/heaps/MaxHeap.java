package com.problems.practice.heaps;

import java.util.Arrays;

import com.problems.Logger;

/**
 * MaxHeap api:
 * 
 * 	Return the MaxElement of the Heap.
 * 	Insert into the heap.
 *  TODO Change the priority of an element in the heap.
 *  TODO delete an element from the heap.
 *  Build a heap from unsorted data.
 * @author bbolla
 *
 */
public class MaxHeap {
	
	Comparable[] elements;
	int operationTrace;
	int size;
	
	MaxHeap(Comparable[] unsortedArray) {
		if(unsortedArray != null) elements = new Comparable[unsortedArray.length + 1]; //Initial capacity
		else throw new IllegalArgumentException();
		operationTrace = 0;
		size = 0;
		for(Comparable element : unsortedArray) {
			add(element);
			Logger.debug(this.toString());
		}
	}
	
	
	void add(Comparable element) {
		//Insert this node in the size 
		this.elements[++size] = element;
		operationTrace = 0;
		heapify(size);
		Logger.debug("add : ", operationTrace);
	}
	
	Comparable deleteMax() {
		operationTrace = 0;
		if(size == 0) return null; //If there is nothing.
		else {
			Comparable returningElement = this.elements[1];
			this.elements[1] = this.elements[size];
			this.elements[size--] = null;
			heapify(1);
			Logger.debug("deleteMax : ", operationTrace);
			return returningElement;
		}
	}


	/**
	 * Check for violation
	 * @param index
	 */
	private void heapify(int index) {
	 if(index/2 != 0 && less(elements[index/2], elements[index])) { //There could be a parent violation.
		 exchange(index/2, index);
		 heapify(index/2);
	 } else { //check for children.
		 if(2* index <= size) {
			 if((2*index+1) <= size) { //2 children
				 int max = 2*index;
				 if(less(elements[2*index], elements[2*index+1] )) {
					 max = 2*index+1;
				 }
				 
				 if(less(elements[index], elements[max])) {
					 exchange(index, max);
					 heapify(max);
				 }
			 } else { //1 children
				 if(less(elements[index], elements[2*index])) {
					 exchange(index, 2*index);
					 heapify(2*index);
				 }
			 }
		 }
	 }
	 operationTrace++;
		
	}


	private void exchange(int index1, int index2) {
		Comparable temp = elements[index1];
		elements[index1] = elements[index2];
		elements[index2] = temp;
	}


	/**
	 * Returns true if element1 is less than element2
	 * @param element1
	 * @param element2
	 * @return
	 */
	private boolean less(Comparable element1, Comparable element2) {
		return element1.compareTo(element2) < 0;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(elements);
	}
	

}
