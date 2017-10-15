package com.problems.examples;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.problems.Logger;

public class Euler50 {
	
	
	public static void main(String[] args) {
		Logger.debug(mostConsecutivePrimes(100L));
		Logger.debug(mostConsecutivePrimes(1000L));
		Logger.debug(mostConsecutivePrimes(1000000L));
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

	private static Set<Long> mostConsecutivePrimes(Long maxNumber) {
		
		Set<Long> primes = allPrimes(maxNumber);
		
		List<Long> primesList = new ArrayList<>(primes);
		Collections.sort(primesList);
		
		Logger.debug("sorted list", primesList);
		
		Logger.debug("Size: ", primesList.size());
		Long largestSum = 0L;
		Set<Long> subset = null;
		
		for(int i=primesList.size() > 550?550:primesList.size() - 1 ; i>0; i--) { // The sum must be the biggest and the prime should be there
			Logger.debug("Window size: ", i);
			for(int j = 0; j+i < primesList.size() - 1; j++) { //Moving window.
				Long sum = addUp(primesList, j, j+i);
				Logger.debug(sum);
				if(primesList.contains(sum) && sum > largestSum) {
					largestSum = sum;
					subset = new HashSet<Long>(primesList.subList(j, j+i));
					Logger.debug(largestSum, subset.size(), primesList.get(j+i));
					break;
				}
			}
			if(largestSum != 0L) {
				break;
			}
		}
		
		Logger.debug("Largest sum", largestSum, subset.size());
		
		return subset;
	}


	private static Long addUp(List<Long> primesList, int j, int i) {
		Long sum = 0L;
		for(int start=j; start<+i; start++ ) {
			sum += primesList.get(start);
		}
		return sum;
	}

}
