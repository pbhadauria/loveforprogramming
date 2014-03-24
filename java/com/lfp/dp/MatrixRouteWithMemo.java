package com.lfp.dp;

/**
 * This class finds the number of unique routes from start
 * to end cell in a matrix.It internally uses memoization
 * to store intermediate results to reduce the number of 
 * recursive calls while backtracking.
 * 
 * @author pbhadauria
 */
public class MatrixRouteWithMemo {

	// variable to keep track of recursive calls to countPaths method
	private int numRecursiveCalls = 0;
	// matrix to store intermediate results
	private Integer[][] memo;

	public int getNumRecursiveCalls() {
		return numRecursiveCalls;
	}

	public void incrementNumRecursiveCalls() {
		numRecursiveCalls++;;
	}

	public Integer[][] getMemo() {
		return memo;
	}

	public int countPaths(int[][] matrix) {
		numRecursiveCalls=0;
	    // initialize memo & start from the top left cell in matrix
	    memo = new Integer[matrix.length][matrix[0].length];
	    return countPaths(matrix, 0, 0);
	}

	public int countPaths(int[][] matrix, int n, int m) {
		incrementNumRecursiveCalls();
	    if(n < matrix.length && m < matrix[0].length) {
	        if(n == matrix.length-1 && m == matrix[0].length-1) {
	            // Store 1 in memo if we reach to E and return it
	            memo[n][m] = 1;
	            return memo[n][m];
	        }
	        /* Consult memo in case we have already calculated routes for a 
	         * particular cell. If result is not null, return it otherwise
	         * use the usual recursion with right and bottom cell.
	         */
	        if(memo[n][m] != null) {
	            return memo[n][m];
	        }
	        // Store the sum of ways we can reach by right & bottom 
	        // cell in the memo and return the result
	        memo[n][m] = countPaths(matrix, n+1, m) + countPaths(matrix, n, m+1);
	        return memo[n][m];
	    }
	    return 0; // <-- Return 0 if we reach to NULL (out of bound)
	}
}
