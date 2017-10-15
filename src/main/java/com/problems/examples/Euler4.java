package com.problems.examples;

import com.problems.Logger;
import com.problems.LongestSubstring;

/*
 * A palindromic number reads the same both ways. The largest palindrome made from the product
 *  of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
 */

public class Euler4 {
	
	public static boolean checkPalindrome(Long number) {
		String numberStraight = number.toString();
		StringBuffer sb = new StringBuffer(numberStraight);
		sb.reverse();
		String reversal = sb.toString();
		return numberStraight.equals(reversal);
	}
	
	
	public static Long largestPalindrome(int digits) {
		Double lowerLimit = Math.pow(10, digits - 1);
		Long lower =  lowerLimit.longValue();
		Double higherLimit = Math.pow(10, digits) - 1;
		Logger.debug("Lower limit , Higher Limit", lowerLimit, higherLimit);
		Long higher =  higherLimit.longValue();
		Logger.debug("lower, higher", lower, higher);
		
		long maxPalindrome = -1L;
		
		for(long i=higher; i>=lower; i--) {
			for(long j=higher; j>=lower; j--) {
				if(checkPalindrome(i*j) && maxPalindrome < i*j) {
					 maxPalindrome = i*j;
				}
			}
		}
		return maxPalindrome;
	}
	
	
	public static void main(String[] args) {

		Logger.debug(largestPalindrome(2));
		Logger.debug(largestPalindrome(3));
		

		Logger.debug(largestPalindrome(10));
	}

}
