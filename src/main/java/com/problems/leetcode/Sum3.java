package com.problems.leetcode;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.problems.Logger;

public class Sum3 {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> findings = new ArrayList<>();
		List<String> existingFindings = new ArrayList<>();

		List<List<Integer>> indexes = new ArrayList<>();
		List<Integer> values = new ArrayList<>();

		List<List<Integer>> finalPairs = new ArrayList<>();

		for (Integer i = 0; i < nums.length; i++) {
			for (Integer j = i + 1; j < nums.length; j++) {
				indexes.add(Arrays.asList(i, j));
				values.add(nums[i] + nums[j]);
			}
		}
		
		Logger.debug("All possible two pairs", indexes);
		Logger.debug("All Possible values", values);
		
		for(int indexVal = 0; indexVal < values.size(); indexVal++) {
			for(int k=0; k<nums.length; k++) {
				if(values.get(indexVal) + nums[k] ==0) {
					List<Integer> index = new ArrayList<>(indexes.get(indexVal));
					if (!index.contains(k)) {
						index.add(k);
						finalPairs.add(index.stream().map(val -> nums[val]).collect(Collectors.toList()));
					}
				}
			}
		}

		for (int i = 0; i < finalPairs.size(); i++) {
			if (!existingFindings.contains(asString(finalPairs.get(i)))) {
				existingFindings.add(asString(finalPairs.get(i)));
				findings.add(finalPairs.get(i));
			}

		}

		return findings;
	}

	private static String asString(List<Integer> list) {
		Collections.sort(list);
		return String.join("|", list.stream().map(val -> String.valueOf(val)).collect(Collectors.toList()));
	}

	public static void main(String[] args) {
		ZonedDateTime now = ZonedDateTime.now();
		int[] s = new int[] { 13,4,-6,-7,-15,-1,0,-1,0,-12,-12,9,3,-14,-2,-5,-6,7,8,2,-4,6,-5,-10,-4,-9,-14,-14,12,-13,-7,3,7,2,11,7,9,-4,13,-6,-1,-14,-12,9,9,-6,-11,10,-14,13,-2,-11,-4,8,-6,0,7,-12,1,4,12,9,14,-4,-3,11,10,-9,-8,8,0,-1,1,3,-15,-12,4,12,13,6,10,-4,10,13,12,12,-2,4,7,7,-15,-4,1,-15,8,5,3,3,11,2,-11,-12,-14,5,-1,9,0,-12,6,-1,1,1,2,-3 };
		Logger.debug(threeSum(s));
		Logger.debug("Total Time", Duration.between(now, ZonedDateTime.now()).toMillis(), " ms");

	}

}
