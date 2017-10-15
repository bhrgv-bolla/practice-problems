package com.problems.examples;

import java.util.HashSet;
import java.util.Set;

import com.problems.Logger;

/*
 * The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?

Note: Try this method later: If you start from 2 and start reducing the number and contunuosly increment the

number. A number can be represented as a multiplies of primes. So you will get all the prime factors very 
easily. 

 */
public class Euler3 {
	
	public static long findMaxPrimeNumber(long bigNumber){
		Set<Long> primes = new HashSet<>();
		long largestPrime = 0;
		long startPrime = 2;
		Long currentPrime = startPrime;
		while(currentPrime != null) {
			if(bigNumber % currentPrime == 0) largestPrime = currentPrime;
			//Reduce....
			while(bigNumber % currentPrime == 0) {
				bigNumber = bigNumber / currentPrime;
			}
			
			if(bigNumber == 1) {
				currentPrime = null;
			} else {
				for(int i=2; i*currentPrime <= Math.sqrt(bigNumber); i++) {
					primes.add(i*currentPrime);
				}
				currentPrime = nextPrime(primes, currentPrime);
			}
		}
		
		
//		for(long primeNum : primes) {
//			if(bigNumber == 0) break;
//			if(bigNumber % primeNum == 0) largestPrime = primeNum;
//			//Reduce....
//			while(bigNumber % primeNum == 0) {
//				bigNumber = bigNumber / primeNum;
//			}
//		}
		
	
		return largestPrime;
	}
	
	
	private static Set<Long> findAllPrimes(long maxPrime) {
		long firstPrime = 2;
		long currentPrime = firstPrime;
		Set<Long> nonPrimes = new HashSet<>(); 
		while(currentPrime <= maxPrime) {
			for(int i=2; i*currentPrime <= maxPrime; i++) {
				nonPrimes.add(currentPrime * i);
			}
			currentPrime = nextPrime(nonPrimes, currentPrime);
		}
		Set<Long> primes = new HashSet<>();
		for(long i=2; i<=maxPrime; i++) {
			primes.add(i);
		}
		primes.removeAll(nonPrimes);
		return primes;
	}


	private static long nextPrime(Set<Long> primes, long largestPrime) {
		long nextPrime = 0;
		while(nextPrime == 0) {
			if(!primes.contains(++largestPrime)) nextPrime = largestPrime;
		}
		return nextPrime;
	}


	public final static void main(String[] args) {
//		Logger.debug(findMaxPrimeNumber(10L));
//
//		Logger.debug(findMaxPrimeNumber(13195L));
		Logger.debug(findMaxPrimeNumber(600851475143L));
	}

}
