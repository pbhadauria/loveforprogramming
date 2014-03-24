package com.lfp.dp;

/**
 * This class finds the number of unqiue routes from start
 * to end cell in a matrix.
 * 
 * @author pbhadauria
 */
public class MatrixRoute {

	// variable to keep track of recursive calls to countPaths method
	private int numRecursiveCalls = 0;

	public int getNumRecursiveCalls() {
		return numRecursiveCalls;
	}

	public void incrementNumRecursiveCalls() {
		numRecursiveCalls++;;
	}

	public int countPaths(int[][] matrix, int n, int m) {
		incrementNumRecursiveCalls();
		if(n < matrix.length && m < matrix[0].length) {
			if(n == matrix.length-1 && m == matrix[0].length-1) {
				// Return 1 if we reach to E
				return 1;
			}
			// Return the sum of ways we can reach by right & bottom 
	        // cells
			return countPaths(matrix, n+1, m) + countPaths(matrix, n, m+1);
		}
		return 0;// Return 0 if we reach to NULL (out of bound)
	}

	public int countPaths(int[][] matrix) {
		numRecursiveCalls = 0;
		// start from the top left cell in matrix
		return countPaths(matrix, 0, 0);
	}
}
