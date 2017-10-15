package com.problems.examples;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.problems.Logger;

public class Euler30 {
	
	public static void main(String[] args) {
		Logger.debug(numbers(4).stream().mapToLong(val->val.longValue()).sum());

		Logger.debug(numbers(5).stream().mapToLong(val->val.longValue()).sum());
	}

	private static Set<Double> numbers(int power) {
		//Lets store the powers of 0 to 9 digits in map. 
		Map<Integer, Double> powers = new HashMap<>();
		for(int i=0; i<=9; i++) {
			powers.put(i, Math.pow(i, power));
		}
		Logger.debug(powers);
		Set<Double> numbers = new HashSet<>();
		Long sum = powers.values().stream().mapToLong(val -> val.longValue()).sum();
		//BruteForce the 5 digit space
		for(double start = 2; start<2*sum; start++) { //TODO there is a sophisticated way of getting the higher limit to search for.
			if(start == sumDigits(start, powers)) {
				numbers.add(start);
			}
		}
		Logger.debug(numbers);
		return numbers;
	}

	private static double sumDigits(Double start, Map<Integer, Double> powers) {
		String value = String.valueOf(start.longValue());
		double sum = 0;
		for(int i=0; i<value.length(); i++) {
			sum += powers.get(Integer.parseInt(""+value.charAt(i)));
		}
		return sum;
	}

}
