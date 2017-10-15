package com.problems.examples;

import java.util.HashSet;
import java.util.Set;

import com.problems.Logger;

/*
 * The primes 3, 7, 109, and 673, are quite remarkable.
 *  By taking any two primes and concatenating them in any order the result will always be prime. 
 *  For example, taking 7 and 109, both 7109 and 1097 are prime. 
 *  The sum of these four primes, 792, represents the lowest sum for a set of four primes with 
 *  this property.

Find the lowest sum for a set of five primes for which any two primes concatenate to 
produce another prime.
 */
public class Euler60 {
	
	private static Set<Long> primes = new HashSet<>();
	private static Long checkedUntil = 0L;
	
	
	public static void main(String[] args) {

		Logger.debug(findLowestSumOfPrimes(4L));
		Logger.debug(findLowestSumOfPrimes(5L));
	}

	private static Long findLowestSumOfPrimes(long number) {
		
		Set<Long> lowestSumPrimes = getLowestSumPrimes(number);
		
		return lowestSumPrimes.stream().mapToLong(val -> val).sum();
	}

	private static Set<Long>  getLowestSumPrimes(long numberOfPrimes) {
		if(numberOfPrimes == 2) {
			Set<Long> lowestPrimes = new HashSet<Long>();
			lowestPrimes.add(13L);
			lowestPrimes.add(5197L);
			primes.addAll(lowestPrimes);
			primes.add(2L);
			checkedUntil = 7L;
			Logger.debug("Should be once", primes);
			return lowestPrimes;
		}
		Set<Long> lowestSumPrimes = getLowestSumPrimes(numberOfPrimes - 1);
		Long lastPrime = getLastPrimeThatSatisfies(lowestSumPrimes);
		lowestSumPrimes.add(lastPrime);
		Logger.debug("Number of primes ", numberOfPrimes, lowestSumPrimes);
		return lowestSumPrimes;
	}

	private static Long getLastPrimeThatSatisfies(Set<Long> lowestSumPrimes) {
		Long maxPrimeNumber = lowestSumPrimes.stream().mapToLong(val -> val).max().getAsLong();
		for(long i=maxPrimeNumber + 1; i>0; i++) {
//			Logger.debug("Max prime is", maxPrimeNumber, "checking:", i);
			if(isPrime(i) && satisfiesCondition(lowestSumPrimes, i)){
				return i;
			}
		}
		return -1L;
	}

	private static boolean satisfiesCondition(Set<Long> lowestSumPrimes, long anotherPrime) {
		for(Long prime : lowestSumPrimes) {
			if(!check(prime, anotherPrime)) {
				return false;
			}
		}
		return true;
	}

	private static boolean check(Long prime, Long anotherPrime) {
		//Checks whether the condition is satisfied or not. 
		String straight = prime.toString() + anotherPrime.toString();
		String reverse = anotherPrime.toString() + prime.toString();
		Logger.debug(straight, reverse);
		return isPrime(Long.valueOf(straight)) && isPrime(Long.valueOf(reverse));
	}
	
	private static boolean isPrime(long number) {
		if(primes.contains(number)) {
			return true;
		} else {
			return isPrimeCheck(number);
		}
	}

	private static boolean isPrimeCheck(long number) {
		//Brute force. TODO improve. 
//		Logger.debug("isPrime", number, primes);
		if(checkedUntil <= number) {
			allPrimesInBetween(checkedUntil, number);
		}
		for(Long value : primes) {
			if(number % value == 0) {
				return false;
			}
		}
		return true;
	}

	private static void allPrimesInBetween(Long checkedUntil2, long number) {
		for(long i = getMax(primes) + 1 ; i<= Math.sqrt(number) + 1; i++) {
			boolean prime = true;
			//Check if prime
			for(Long value : primes) {
				if(i % value == 0) {
					prime = false;
				}
			}
			
			if(prime) {
				Logger.debug("primes", i);
				primes.add(i);
			}
		}
		checkedUntil = number;
	}

	private static long getMax(Set<Long> primes2) {
		// TODO Auto-generated method stub
		return primes2.stream().mapToLong(val -> val).max().getAsLong();
	}

}
