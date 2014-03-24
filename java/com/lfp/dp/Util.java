package com.lfp.dp;

public class Util {

	public final static String maxValuePathInfo =
			"Matrix Dimensions %s; Max Path Value=%s; Recursive Calls=%s";
	public final static String routeInfo =
			"Matrix Dimensions %s; Number of Paths=%s; Recursive Calls=%s";

	// utility program for printing memo
	public static void printMemo(Integer[][] memo) {
		System.out.println("Memo:");
		for(Integer[] row : memo) {
			for(Integer col : row) {
				System.out.printf("%6d", col);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void logMessage(String testName, String format, String mDim,
			                      int value, int calls) {
		System.out.println(String.format("Test %s #####", testName));
		System.out.println(String.format(format, mDim, value, calls));
		System.out.println("#######################################");
		System.out.println();
	}

	public static void logMessageWithMemo(String testName, String format,
			    						  String mDim, int value, int calls,
			    						  Integer[][] memo) {
		logMessage(testName, format, mDim, value, calls);
		printMemo(memo);
	}
}
