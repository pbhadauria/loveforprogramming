package com.lfp;

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
	private static int recursiveCalls = 0;
	// matrix to store intermediate results
	private static Integer[][] memo;

	public static int getMaxPath(int[][] matrix) {
		recursiveCalls = 0;
		// initialize memo & start from the top left cell in matrix
		memo = new Integer[matrix.length][matrix[0].length];
		return getMaxPath(matrix, 0, 0);
	}

	public static int getMaxPath(int[][] matrix, int n, int m) {
		recursiveCalls++;
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
			int bottom = getMaxPath(matrix, n+1, m);
			int right = getMaxPath(matrix, n, m+1);
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
	public static void printResults() {
		System.out.println("Memo:");
		for(Integer[] row : memo) {
			for(Integer col : row) {
				System.out.printf("%6d", col);
			}
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

		String info = "Matrix Dimensions %s; Max Path Value=%s; Recursive Calls=%s";
		System.out.println(String.format(info, "2x2", getMaxPath(matrix1), recursiveCalls));
		printResults();
		System.out.println(String.format(info, "3x3", getMaxPath(matrix2), recursiveCalls));
		printResults();
		System.out.println(String.format(info, "3x8", getMaxPath(matrix3), recursiveCalls));
		printResults();
		System.out.println(String.format(info, "8x8", getMaxPath(matrix4), recursiveCalls));
		printResults();
	}
}
