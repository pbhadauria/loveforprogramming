package com.lfp;

/**
 * This class finds the number of unqiue routes from start
 * to end cell in a matrix.
 * 
 * @author pbhadauria
 */
public class MatrixRoute {

	// variable to keep track of recursive calls to countPaths method
	private static int recursiveCalls = 0;
	
	public static int countPaths(int[][] matrix, int n, int m) {
		recursiveCalls++;
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

	public static int countPaths(int[][] matrix) {
		recursiveCalls = 0;
		// start from the top left cell in matrix
		return countPaths(matrix, 0, 0);
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

		String info = "Matrix Dimensions %s; Number of Paths=%s; Recursive Calls=%s";
		
		System.out.println(String.format(info, "2x2", countPaths(matrix1), recursiveCalls));
		System.out.println(String.format(info, "3x3", countPaths(matrix2), recursiveCalls));
		System.out.println(String.format(info, "3x8", countPaths(matrix3), recursiveCalls));
		System.out.println(String.format(info, "8x8", countPaths(matrix4), recursiveCalls));
	}
}
