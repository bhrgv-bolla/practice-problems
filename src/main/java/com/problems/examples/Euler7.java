package com.problems.examples;

import java.util.HashSet;
import java.util.Set;

import com.problems.Logger;

/*
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
 */
public class Euler7 {
	
	public static void main(String[] args) {

		Logger.debug(prime(13));
		Logger.debug(prime(10001));
	}

	private static Long prime(long number) {
		Set<Long> primes = new HashSet<Long>();
		
		primes.add(2L);
		primes.add(3L);
		long currentPrimeNum = 3;
		long nextPrime = 3;
		while(currentPrimeNum <= number) {
			Logger.debug(currentPrimeNum++, nextPrime = nextPrime(primes, nextPrime+1));
			primes.add(nextPrime);
		}
		return nextPrime;
	}

	private static long nextPrime(Set<Long> primes, long currentNumber) {
		boolean primeValue = false;
		while(!primeValue) {
			primeValue = true;
			for(Long prime : primes) {
				if(currentNumber % prime == 0) {
					currentNumber++; 
					primeValue = false;
				}
			}
		}
		
		return currentNumber;
	}

}
