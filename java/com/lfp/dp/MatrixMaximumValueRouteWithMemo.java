package com.lfp.dp;

/**
 * Given the values in a matrix, this class calculates the
 * maximum value path from start to end node. It internally
 * uses memoization to store intermediate results to reduce
 * the number of recursive calls while backtracking.
 * 
 * @author pbhadauria
 */
public class MatrixMaximumValueRouteWithMemo {

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

	public int getMaxValuePath(int[][] matrix) {
		numRecursiveCalls = 0;
		// initialize memo & start from the top left cell in matrix
		memo = new Integer[matrix.length][matrix[0].length];
		return getMaxValuePath(matrix, 0, 0);
	}

	public int getMaxValuePath(int[][] matrix, int n, int m) {
		incrementNumRecursiveCalls();
		if(n < matrix.length && m < matrix[0].length) {
			if(n == matrix.length-1 && m == matrix[0].length-1) {
				// Store cell value in memo if we reach to E and return it
				memo[n][m] = matrix[n][m];
				return memo[n][m];
			}
	        /* Consult memo in case we already have a max value calculated
	         * for a particular cell. If result is not null, return it
	         * otherwise use the usual recursion with right and bottom cell.
	         */
			if(memo[n][m] != null) {
				return memo[n][m];
			}
			int bottom = getMaxValuePath(matrix, n+1, m);
			int right = getMaxValuePath(matrix, n, m+1);
			// take the max value for a node in decision tree
			int max = Math.max(bottom, right);
			// Add cell value to the max value from left or right child
			// and store it in memo
			memo[n][m] = max + matrix[n][m];
			return memo[n][m];
		}
		return Integer.MIN_VALUE;
	}

	// utility program for printing memo
	public void printResults() {
		System.out.println("Memo:");
		for(Integer[] row : memo) {
			System.out.print("{");
			for(Integer col : row) {
				System.out.print(col+",");
			}
			System.out.print("},");
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[][] matrix1 = new int[][] {
				{1,2},
				{3,4}
		};
		int[][] matrix2 = new int[][] {
				{1,8,7},
				{3,4,2},
				{5,6,9}
		};
		int[][] matrix3 = new int[][] {
				{1,2,3,4,5,6,7,8},
				{9,10,3,0,1,2,11,12},
				{1,20,3,8,4,21,3,4}
		};
		int[][] matrix4 = new int[][] {
				{1,2,3,4,5,6,7,8},
				{9,10,3,0,1,2,11,12},
				{1,20,3,8,4,21,3,4},
				{1,20,3,8,6,21,3,4},
				{1,20,3,9,7,2,3,4},
				{1,21,7,2,14,29,3,4},
				{1,13,2,11,4,25,3,4},
				{10,20,4,8,9,21,3,9}
		};
		MatrixMaximumValueRouteWithMemo m = new MatrixMaximumValueRouteWithMemo();
		String info = "Matrix Dimensions %s; Max Path Value=%s; Recursive Calls=%s";
		System.out.println(String.format(info, "2x2", m.getMaxValuePath(matrix1), m.getNumRecursiveCalls()));
		m.printResults();
		System.out.println(String.format(info, "3x3", m.getMaxValuePath(matrix2), m.getNumRecursiveCalls()));
		m.printResults();
		System.out.println(String.format(info, "3x8", m.getMaxValuePath(matrix3), m.getNumRecursiveCalls()));
		m.printResults();
		System.out.println(String.format(info, "8x8", m.getMaxValuePath(matrix4), m.getNumRecursiveCalls()));
		m.printResults();
	}
}
