package com.problems.examples;

import java.util.Arrays;

import com.problems.Logger;

public class Euler40 {

	public static void main(String[] args) {
		Logger.debug(multiply(1, 10, 100, 1000, 10000, 100000, 1000000));
	}

	private static Long multiply(Integer ...positions) {
		Integer maximum = Arrays.stream(positions).mapToInt(val -> val).max().getAsInt();
		StringBuilder theDecimals = new StringBuilder();
		for(long i=1; theDecimals.length() < maximum + 10; i++) {
			theDecimals.append(i);
		}
		
		String decimals = theDecimals.toString();
		long multiplication = 1;
		for(Integer position: positions) {
			Long value = Long.parseLong(""+decimals.charAt(position - 1));
			Logger.debug(decimals.charAt(11), decimals.subSequence(position , position + 5), value);
			multiplication *= value;
		}
		
//		Logger.debug(theDecimals);
		return multiplication;
	}
}
