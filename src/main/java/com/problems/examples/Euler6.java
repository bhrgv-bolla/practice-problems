package com.problems.examples;

import com.problems.Logger;

/*
 * The sum of the squares of the first ten natural numbers is,

12 + 22 + ... + 102 = 385
The square of the sum of the first ten natural numbers is,

(1 + 2 + ... + 10)2 = 552 = 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class Euler6 {
	
	
	private static Long sumOfSquares(long number) {
		return (number * (number + 1) * (2*number+1) / 6);
	}
	
	
	public static void main(String[] args) {
		Logger.debug(difference(10));
		Logger.debug(difference(100));
	}

	private static Long difference(long number) {
		return sumSquared(number) - sumOfSquares(number);
	}


	private static Long sumSquared(long number) {
		return (long) Math.pow((number * (number +1) / 2), 2);
	}

}
