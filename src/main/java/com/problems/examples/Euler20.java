package com.problems.examples;

import java.math.BigInteger;

import com.problems.Logger;

public class Euler20 {
	
	public static void main(String[] args) {
		Logger.debug(sumOfFactorial(10));
		Logger.debug(sumOfFactorial(100));
	}

	private static Long sumOfFactorial(int i) {
		BigInteger factorialValue = factorial(i);
		Logger.debug(factorialValue);
		return sumDigits(factorialValue);
	}

	private static Long sumDigits(BigInteger factorialValue) {
		BigInteger sum = BigInteger.ZERO;
		while(factorialValue.compareTo(BigInteger.ZERO) != -1) {
			sum.add(factorialValue.mod(BigInteger.valueOf(10)));
			factorialValue.divide(BigInteger.valueOf(10));
		}
		return sum.longValueExact(); //TAKING TOO LONG
	}

	private static BigInteger factorial(long i) {
		if(i < 2) {
			return BigInteger.ONE;
		} 
		return BigInteger.valueOf(i).multiply(factorial(i-1));
	}

}
