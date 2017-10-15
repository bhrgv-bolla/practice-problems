package com.problems;

import java.util.Arrays;

public class Logger {
	
	public static <T> void debugAny(T thingsToDebug) {
		System.out.print(thingsToDebug);
	}
	
	public static void debug(Object ...objects) {
		debugStackTrace(Thread.currentThread().getStackTrace());
		if(objects.length == 0) return;
		for(int i=0; i<objects.length; i++) {
			debugAny(objects[i]);
			if(i != objects.length-1) System.out.print(" | ");
			else System.out.println("");
		}
		System.out.println("---------------------------");
	}

	private static void debugStackTrace(StackTraceElement[] stackTrace) {
		System.out.println(stackTrace[2].toString());
	}
	
}
