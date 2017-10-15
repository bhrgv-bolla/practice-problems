package com.problems;

public class LongestSubstring {

	public static int lengthOfLongestSubstring(String s) {
		Integer maxLength = 0;
		char[] charecters = s.toCharArray();
		int currentLength = 0;
		int lengthFromEnd = 0;
		
		// Scan index from the starting. 
		int scanIndexStart = 0;
		int scanIndexEnd = charecters.length - 1;
		String parsed1 = "";
		String parsed2 = "";
		String maxStringTillNow = "";
		
		while( scanIndexStart < scanIndexEnd) {
			if(parsed1.contains(""+charecters[scanIndexStart])) {
				if(maxLength < currentLength) maxLength = currentLength;
				currentLength = 0;
				parsed1 = "";
				scanIndexStart++;
			} else {
				parsed1 += charecters[scanIndexStart];
				scanIndexStart++;
				currentLength++;
			}
			
			if(scanIndexStart == scanIndexEnd) {
				
			} else {
				parsed2 += charecters[scanIndexEnd];
				scanIndexEnd--;
				lengthFromEnd++;
			}
			
		}
		
		//update current length.
		if(scanIndexStart == scanIndexEnd) {
			if(parsed1.contains("" + charecters[scanIndexStart])) {
				
			}
		} else if (scanIndexStart + 1 == scanIndexEnd) {
			
		}
		
		Logger.debug("stringFromStart (fromStart), stringFromEnd (FromENd)", parsed1, currentLength, parsed2, lengthFromEnd);
		
		Logger.debug("MaxLength: ", maxLength, maxStringTillNow);
		
		Logger.debug("");
		
		return currentLength > maxLength ? currentLength : maxLength;
	}
	
	private static <T> void debug(T value) {
		System.out.println(value);
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("asadsadsad"));
	}

}
