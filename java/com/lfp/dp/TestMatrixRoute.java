package com.lfp.dp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link MatrixRoute}.
 * 
 * @author pbhadauria
 */
public class TestMatrixRoute {

	private MatrixRoute mr;

	int[][] inputMatrix1 = new int[][] {
			{1,2},
			{3,4}
	};

	int[][] inputMatrix2 = new int[][] {
			{1,8,7},
			{3,4,2},
			{5,6,9}
	};

	int[][] inputMatrix3 = new int[][] {
			{1,2,3,4,5,6,7,8},
			{9,10,3,0,1,2,11,12},
			{1,20,3,8,4,21,3,4}
	};

	int[][] inputMatrix4 = new int[][] {
			{1,2,3,4,5,6,7,8},
			{9,10,3,0,1,2,11,12},
			{1,20,3,8,4,21,3,4},
			{1,20,3,8,6,21,3,4},
			{1,20,3,9,7,2,3,4},
			{1,21,7,2,14,29,3,4},
			{1,13,2,11,4,25,3,4},
			{10,20,4,8,9,21,3,9}
	};

	int[][] inputMatrix5 = new int[][] {
			{1}
	};

	@Before
	public void init() {
		mr = new MatrixRoute();
	}

	@Test
	public void countPathFor2by2Matrix() {
		int paths = mr.countPaths(inputMatrix1);
		Util.logMessage("countPathFor2by2Matrix", Util.routeInfo, "2x2",
				paths, mr.getNumRecursiveCalls());

		Assert.assertEquals(2, paths);
		Assert.assertEquals(7, mr.getNumRecursiveCalls());
	}

	@Test
	public void countPathFor3by3Matrix() {
		int paths = mr.countPaths(inputMatrix2);
		Util.logMessage("countPathFor3by3Matrix", Util.routeInfo, "3x3",
				paths, mr.getNumRecursiveCalls());

		Assert.assertEquals(6, paths);
		Assert.assertEquals(27, mr.getNumRecursiveCalls());
	}

	@Test
	public void countPathFor3by8Matrix() {
		int paths = mr.countPaths(inputMatrix3);
		Util.logMessage("countPathFor3by8Matrix", Util.routeInfo, "3x8",
				paths, mr.getNumRecursiveCalls());
		
		Assert.assertEquals(36, paths);
		Assert.assertEquals(257, mr.getNumRecursiveCalls());
	}

	@Test
	public void countPathFor8by8Matrix() {
		int paths = mr.countPaths(inputMatrix4);
		Util.logMessage("countPathFor8by8Matrix", Util.routeInfo, "8x8",
				paths, mr.getNumRecursiveCalls());

		Assert.assertEquals(3432, paths);
		Assert.assertEquals(18875, mr.getNumRecursiveCalls());
	}

	@Test
	public void countPathForSingleElementMatrix() {
		int paths = mr.countPaths(inputMatrix5);
		Util.logMessage("countPathForSingleElementMatrix", Util.routeInfo, "1x1",
				paths, mr.getNumRecursiveCalls());
	
		Assert.assertEquals(1, paths);
		Assert.assertEquals(1, mr.getNumRecursiveCalls());
	}
}
