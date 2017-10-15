package com.problems.examples;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

import com.problems.Logger;

public class Euler60Approach2 {
	
	public static void main(String[] args) {
		Set<Long> primesUnderMillion = allPrimes(1000000);
		Set<Long> primesUnderMaxLong = allPrimes(100000000);
	}

	private static Set<Long> allPrimes(long maxValue) {
		Logger.debug(maxValue);
		ZonedDateTime now = ZonedDateTime.now();
		Set<Long> primes = new HashSet<Long>();
		Set<Long> nonPrimes = new HashSet<Long>();
		for(long i =2; i < maxValue; i++) {
			if(nonPrimes.contains(i)) {
				continue;
			} else {
				primes.add(i);
				for(long j=2; j*i < maxValue; j++) {
					nonPrimes.add(j*i);
				}
			}
		}
		Logger.debug(Duration.between(now, ZonedDateTime.now()).toMillis(), "Milli Seconds");
		return primes;
	}

}
