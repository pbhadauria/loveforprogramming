package com.lfp.dp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link MatrixRoute}.
 * 
 * @author pbhadauria
 */
public class TestMatrixRouteWithMemo {

	private MatrixRouteWithMemo mr;

	int[][] inputMatrix1 = new int[][] {
			{1,2},
			{3,4}
	};

	int[][] expectedInputMatrix1Memo = new int[][] {
			{2,1},
			{1,1}
	};

	int[][] inputMatrix2 = new int[][] {
			{1,8,7},
			{3,4,2},
			{5,6,9}
	};

	int[][] expectedInputMatrix2Memo = new int[][] {
			{6,3,1},
			{3,2,1},
			{1,1,1}
	};

	int[][] inputMatrix3 = new int[][] {
			{1,2,3,4,5,6,7,8},
			{9,10,3,0,1,2,11,12},
			{1,20,3,8,4,21,3,4}
	};

	int[][] expectedInputMatrix3Memo = new int[][] {
			{36,28,21,15,10,6,3,1},
			{8,7,6,5,4,3,2,1},
			{1,1,1,1,1,1,1,1}
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
			{3432,1716,792,330,120,36,8,1},
			{1716,924,462,210,84,28,7,1},
			{792,462,252,126,56,21,6,1},
			{330,210,126,70,35,15,5,1},
			{120,84,56,35,20,10,4,1},
			{36,28,21,15,10,6,3,1},
			{8,7,6,5,4,3,2,1},
			{1,1,1,1,1,1,1,1}
	};

	int[][] inputMatrix5 = new int[][] {
			{1}
	};

	int[][] expectedInputMatrix5Memo = new int[][] {
			{1}
	};

	@Before
	public void init() {
		mr = new MatrixRouteWithMemo();
	}

	@Test
	public void countPathFor2by2Matrix() {
		int paths = mr.countPaths(inputMatrix1);
		Util.logMessageWithMemo("countPathFor2by2Matrix", Util.routeInfo, "2x2",
				paths, mr.getNumRecursiveCalls(), mr.getMemo());

		Assert.assertEquals(2, paths);
		Assert.assertEquals(7, mr.getNumRecursiveCalls());

		Assert.assertArrayEquals(expectedInputMatrix1Memo, mr.getMemo());
	}

	@Test
	public void countPathFor3by3Matrix() {
		int paths = mr.countPaths(inputMatrix2);
		Util.logMessageWithMemo("countPathFor3by3Matrix", Util.routeInfo, "3x3",
				paths, mr.getNumRecursiveCalls(), mr.getMemo());

		Assert.assertEquals(6, paths);
		Assert.assertEquals(17, mr.getNumRecursiveCalls());

		Assert.assertArrayEquals(expectedInputMatrix2Memo, mr.getMemo());
	}

	@Test
	public void countPathFor3by8Matrix() {
		int paths = mr.countPaths(inputMatrix3);
		Util.logMessageWithMemo("countPathFor3by8Matrix", Util.routeInfo, "3x8",
				paths, mr.getNumRecursiveCalls(), mr.getMemo());

		Assert.assertEquals(36, paths);
		Assert.assertEquals(47, mr.getNumRecursiveCalls());
		Assert.assertArrayEquals(expectedInputMatrix3Memo, mr.getMemo());
	}

	@Test
	public void countPathFor8by8Matrix() {
		int paths = mr.countPaths(inputMatrix4);
		Util.logMessageWithMemo("countPathFor8by8Matrix", Util.routeInfo, "8x8",
				paths, mr.getNumRecursiveCalls(), mr.getMemo());

		Assert.assertEquals(3432, paths);
		Assert.assertEquals(127, mr.getNumRecursiveCalls());
		Assert.assertArrayEquals(expectedInputMatrix4Memo, mr.getMemo());
	}

	@Test
	public void countPathForSingleElementMatrix() {
		int paths = mr.countPaths(inputMatrix5);
		Util.logMessageWithMemo("countPathForSingleElementMatrix", Util.routeInfo,
				"1x1", paths, mr.getNumRecursiveCalls(), mr.getMemo());

		Assert.assertEquals(1, paths);
		Assert.assertEquals(1, mr.getNumRecursiveCalls());
		Assert.assertArrayEquals(expectedInputMatrix5Memo, mr.getMemo());
	}
}
