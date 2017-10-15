package com.problems.examples;

import java.util.HashSet;
import java.util.Set;

import com.problems.Logger;

public class Euler1 {
	
	/*
	 * If we list all the natural numbers below 10 that are multiples of 3 or 5
	 * , we get 3, 5, 6 and 9. The sum of these multiples is 23.
	 * Find the sum of all the multiples of 3 or 5 below 1000.
	 */
	public static int getSum(Integer n) {
		Set<Integer> integers =new HashSet<Integer>();
		int i = 1;
		boolean sum3 = false;
		while(!sum3) {
			integers.add(i*3);
			if(i*5 < n) integers.add(i*5);
			i++;
			if(i*3 >= n) sum3=true;
		}
		Logger.debug(integers);
		return integers.stream().mapToInt(a -> a).sum();
	}
	
	
	public static void main(String[] args) {
		Logger.debug(getSum(1000));
		
	}

}
