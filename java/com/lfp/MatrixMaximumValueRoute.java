package com.lfp;

/**
 * Given the values in a matrix, this class calculates the
 * maximum value path from start to end node.
 * 
 * @author pbhadauria
 */
public class MatrixMaximumValueRoute {

	// variable to keep track of recursive calls to countPaths method
	private static int recursiveCalls = 0;
	
	public static int getMaxValuePath(int[][] matrix, int n, int m) {
		recursiveCalls++;
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

	public static int getMaxValuePath(int[][] matrix) {
		recursiveCalls = 0;
		// initialize memo & start from the top left cell in matrix
		return getMaxValuePath(matrix, 0, 0);
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
		System.out.println(String.format(info, "2x2", getMaxValuePath(matrix1), recursiveCalls));
		System.out.println(String.format(info, "3x3", getMaxValuePath(matrix2), recursiveCalls));
		System.out.println(String.format(info, "3x8", getMaxValuePath(matrix3), recursiveCalls));
		System.out.println(String.format(info, "8x8", getMaxValuePath(matrix4), recursiveCalls));
	}
}
