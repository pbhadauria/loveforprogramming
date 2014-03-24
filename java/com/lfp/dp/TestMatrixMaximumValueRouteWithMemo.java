package com.lfp.dp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link MatrixRoute}.
 * 
 * @author pbhadauria
 */
public class TestMatrixMaximumValueRouteWithMemo {

	private MatrixMaximumValueRouteWithMemo mmvr;

	int[][] inputMatrix1 = new int[][] {
			{1,2},
			{3,4}
	};

	int[][] expectedInputMatrix1Memo = new int[][] {
			{8,6},
			{7,4}
	};

	int[][] inputMatrix2 = new int[][] {
			{1,8,7},
			{3,4,2},
			{5,6,9}
	};

	int[][] expectedInputMatrix2Memo = new int[][] {
			{28,27,18},
			{23,19,11},
			{20,15,9}
	};

	int[][] inputMatrix3 = new int[][] {
			{1,2,3,4,5,6,7,8},
			{9,10,3,0,1,2,11,12},
			{1,20,3,8,4,21,3,4}
	};

	int[][] expectedInputMatrix3Memo = new int[][] {
			{83,75,52,49,45,40,34,24},
			{82,73,46,40,33,30,27,16},
			{64,63,43,40,32,28,7,4}
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

	int[][] expectedInputMatrix4Memo = new int[][] {
			{211,203,152,148,144,139,59,49},
			{210,201,149,143,136,133,52,41},
			{192,191,146,143,135,131,32,29},
			{172,171,128,125,116,110,28,25},
			{152,151,120,117,108,89,24,21},
			{132,131,110,103,101,87,20,17},
			{89,88,75,73,62,58,16,13},
			{84,74,54,50,42,33,12,9}
	};

	int[][] inputMatrix5 = new int[][] {
			{1}
	};

	int[][] expectedInputMatrix5Memo = new int[][] {
			{1}
	};

	@Before
	public void init() {
		mmvr = new MatrixMaximumValueRouteWithMemo();
	}

	@Test
	public void getMaxValuePathFor2by2Matrix() {
		int maxPathValue = mmvr.getMaxValuePath(inputMatrix1);
		Util.logMessageWithMemo("getMaxValuePathFor2by2Matrix", Util.maxValuePathInfo, "2x2",
				maxPathValue, mmvr.getNumRecursiveCalls(), mmvr.getMemo());

		Assert.assertEquals(8, maxPathValue);
		Assert.assertEquals(7, mmvr.getNumRecursiveCalls());
		Assert.assertArrayEquals(expectedInputMatrix1Memo, mmvr.getMemo());
	}

	@Test
	public void getMaxValuePathFor3by3Matrix() {
		int maxPathValue = mmvr.getMaxValuePath(inputMatrix2);
		Util.logMessageWithMemo("getMaxValuePathFor3by3Matrix", Util.maxValuePathInfo, "3x3",
				maxPathValue, mmvr.getNumRecursiveCalls(), mmvr.getMemo());

		Assert.assertEquals(28, maxPathValue);
		Assert.assertEquals(17, mmvr.getNumRecursiveCalls());
		Assert.assertArrayEquals(expectedInputMatrix2Memo, mmvr.getMemo());
	}

	@Test
	public void getMaxValuePathFor3by8Matrix() {
		int maxPathValue = mmvr.getMaxValuePath(inputMatrix3);
		Util.logMessageWithMemo("getMaxValuePathFor3by8Matrix", Util.maxValuePathInfo, "3x8",
				maxPathValue, mmvr.getNumRecursiveCalls(), mmvr.getMemo());

		Assert.assertEquals(83, maxPathValue);
		Assert.assertEquals(47, mmvr.getNumRecursiveCalls());
		Assert.assertArrayEquals(expectedInputMatrix3Memo, mmvr.getMemo());
	}

	@Test
	public void getMaxValuePathFor8by8Matrix() {
		int maxPathValue = mmvr.getMaxValuePath(inputMatrix4);
		Util.logMessageWithMemo("getMaxValuePathFor8by8Matrix", Util.maxValuePathInfo, "8x8",
				maxPathValue, mmvr.getNumRecursiveCalls(), mmvr.getMemo());

		Assert.assertEquals(211, maxPathValue);
		Assert.assertEquals(127, mmvr.getNumRecursiveCalls());
		Assert.assertArrayEquals(expectedInputMatrix4Memo, mmvr.getMemo());
	}

	@Test
	public void getMaxValuePathForSingleElementMatrix() {
		int maxPathValue = mmvr.getMaxValuePath(inputMatrix5);
		Util.logMessageWithMemo("getMaxValuePathForSingleElementMatrix", Util.maxValuePathInfo,
				"1x1", maxPathValue, mmvr.getNumRecursiveCalls(), mmvr.getMemo());

		Assert.assertEquals(1, maxPathValue);
		Assert.assertEquals(1, mmvr.getNumRecursiveCalls());
		Assert.assertArrayEquals(expectedInputMatrix5Memo, mmvr.getMemo());
	}
}
