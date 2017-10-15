package com.problems.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.problems.Logger;

public class Euler5 {
	
	public static long lcm(Long ...numbers) {
		
		Map<Long, List<Long>> numberToItsDivisorsMap = new HashMap<Long, List<Long>> ();
		
		for(int i=0; i<numbers.length; i++) {
			numberToItsDivisorsMap.put(numbers[i], getPrimeDivisors(numbers[i]));
		}
		
		List<Long> commonDivisors = getCommonDivisors(numberToItsDivisorsMap);
		
		Long finalMultiplication = 1L;
		for(Long value: commonDivisors) {
			finalMultiplication *= value;
		}
		
		return finalMultiplication;
	}
	
	
	
	private static List<Long> getCommonDivisors(Map<Long, List<Long>> numberToItsDivisorsMap) {
		
		Logger.debug(numberToItsDivisorsMap);
		
		Set<Long> distinctValues = numberToItsDivisorsMap.entrySet().stream()
														.flatMap(entry -> entry.getValue().stream())
														.collect(Collectors.toSet());
		
		List<Long> finalValues = new ArrayList<>();
		
		Logger.debug(distinctValues);
		
		for(Long value : distinctValues) {
			//For each value check if it exists in all the Lists. 
			//If it exists in all the Lists add it to the reduce lists
			//Add the value to the finalValues. 
			long valueMaxTimes = maxTimesInList(value, numberToItsDivisorsMap.values());
			for(int i=0; i<valueMaxTimes; i++) {
				finalValues.add(value);
			}
			
		}
	
		
		Logger.debug("finalValues", finalValues);
		
		return finalValues;
	}



	private static Long maxTimesInList(Long value, Collection<List<Long>> values) {
		
		long maxTimes = 1;
		
		for(List<Long> list : values ) {
			long times = list.stream().filter(val -> val.equals(value)).mapToLong(val -> 1).sum();
			if(times > maxTimes) {
				maxTimes = times;
			}
		}
		
		return maxTimes;
	}



	private static void reduceAllLists(Collection<List<Long>> values, Long value) {
		for(List<Long> list : values) {
			list.remove(value);
		}
	}



	private static boolean isInAlllists(Collection<List<Long>> values, Long value) {
		for(List<Long> list : values) {
			Logger.debug(list, value);
			if(!list.contains(value)) {
				return false; 
			}
		}
		return true;
	}



	private static List<Long> getPrimeDivisors(Long number) {
		List<Long> listOfPrimeDivisors = new ArrayList<>();
		Long firstPrimeDivisor = 2L;

//		Logger.debug(number, listOfPrimeDivisors);
		for(long i=firstPrimeDivisor; i<=number; i++) {
			if(number % i == 0) {
				
				//Reduce the number. 
				while(number%i == 0) {
					number = number/i;
					listOfPrimeDivisors.add(i);
				}
			}
		}
		
		Logger.debug(number, listOfPrimeDivisors);
		
		return listOfPrimeDivisors;
	}



	private static boolean isAllOnes(Long[] numbers) {
		for(int i=0; i<numbers.length; i++) {
			if(numbers[i] != 1) {
				return false;
			}
		}
		return true;
	}



	public static void main(String[] args) {
		Logger.debug("1 to 10", lcm(range(1, 10)));

		Logger.debug("1 to 20", lcm(range(1, 20)));
	}



	private static Long[] range(long lower, long higher) {
		Integer length = (int) (higher - lower + 1);
		Long[] allValues = new Long[length];
		for(int i=0; i<allValues.length; i++) {
			allValues[i] = lower + i;
		}
		Logger.debug("range", Arrays.toString(allValues));
		return allValues;
	}

}
