package com.lfp.dp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link MatrixRoute}.
 * 
 * @author pbhadauria
 */
public class TestMatrixMaximumValueRoute {

	private MatrixMaximumValueRoute mmvr;

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
		mmvr = new MatrixMaximumValueRoute();
	}

	@Test
	public void getMaxValuePathFor2by2Matrix() {

		int maxPathValue = mmvr.getMaxValuePath(inputMatrix1);
		Util.logMessage("getMaxValuePathFor2by2Matrix", Util.maxValuePathInfo, "2x2",
				maxPathValue, mmvr.getNumRecursiveCalls());

		Assert.assertEquals(8, maxPathValue);
		Assert.assertEquals(7, mmvr.getNumRecursiveCalls());
	}

	@Test
	public void getMaxValuePathFor3by3Matrix() {
		int maxPathValue = mmvr.getMaxValuePath(inputMatrix2);
		Util.logMessage("getMaxValuePathFor3by3Matrix", Util.maxValuePathInfo, "3x3",
				maxPathValue, mmvr.getNumRecursiveCalls());

		Assert.assertEquals(28, maxPathValue);
		Assert.assertEquals(27, mmvr.getNumRecursiveCalls());
	}

	@Test
	public void getMaxValuePathFor3by8Matrix() {
		int maxPathValue = mmvr.getMaxValuePath(inputMatrix3);
		Util.logMessage("getMaxValuePathFor3by8Matrix", Util.maxValuePathInfo, "3x8",
				maxPathValue, mmvr.getNumRecursiveCalls());

		Assert.assertEquals(83, maxPathValue);
		Assert.assertEquals(257, mmvr.getNumRecursiveCalls());
	}

	@Test
	public void getMaxValuePathFor8by8Matrix() {
		int maxPathValue = mmvr.getMaxValuePath(inputMatrix4);
		Util.logMessage("getMaxValuePathFor8by8Matrixs", Util.maxValuePathInfo, "8x8",
				maxPathValue, mmvr.getNumRecursiveCalls());

		Assert.assertEquals(211, maxPathValue);
		Assert.assertEquals(18875, mmvr.getNumRecursiveCalls());
	}

	@Test
	public void getMaxValuePathForSingleElementMatrix() {
		int maxPathValue = mmvr.getMaxValuePath(inputMatrix5);
		Util.logMessage("getMaxValuePathForSingleElementMatrix", Util.maxValuePathInfo,
				"1x1", maxPathValue, mmvr.getNumRecursiveCalls());

		Assert.assertEquals(1, maxPathValue);
		Assert.assertEquals(1, mmvr.getNumRecursiveCalls());
	}
}
