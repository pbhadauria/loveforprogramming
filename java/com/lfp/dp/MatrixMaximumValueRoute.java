package com.lfp.dp;

/**
 * Given the values in a matrix, this class calculates the
 * maximum value path from start to end node.
 * 
 * @author pbhadauria
 */
public class MatrixMaximumValueRoute {

	// variable to keep track of recursive calls to 'getMaxValuePath' method
	private int numRecursiveCalls = 0;

	public int getNumRecursiveCalls() {
		return numRecursiveCalls;
	}

	public void incrementNumRecursiveCalls() {
		numRecursiveCalls++;;
	}
	
	public int getMaxValuePath(int[][] matrix, int n, int m) {
		incrementNumRecursiveCalls();
		if(n < matrix.length && m < matrix[0].length) {
			if(n == matrix.length-1 && m == matrix[0].length-1) {
				return matrix[n][m];
			}
			int path1 = getMaxValuePath(matrix, n+1, m);
			int path2 = getMaxValuePath(matrix, n, m+1);
			// take the max value based on right and bottom child cell
			int max = Math.max(path1, path2);
			// max value for this particular cell
			return  max +  + matrix[n][m];
		}
		return Integer.MIN_VALUE;
	}

	public int getMaxValuePath(int[][] matrix) {
		numRecursiveCalls = 0;
		// initialize memo & start from the top left cell in matrix
		return getMaxValuePath(matrix, 0, 0);
	}
}
