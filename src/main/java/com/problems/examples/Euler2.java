package com.problems.examples;

import com.problems.Logger;

public class Euler2 {
	
	public static long sumFibbonaciNumbers(int max) {
		int f0 = 1;
		int f1 = 2;
		long evenSum = 0;
		while(f0 <= max) {
			int f2 = f0+f1;
			f0 = f1;
			f1 = f2;
			if(f0 % 2 == 0) evenSum += f0;
		}
		return evenSum;
	}
	
	public final static void main (String[] args) {
		Logger.debug(sumFibbonaciNumbers(4000000));
	}

}
