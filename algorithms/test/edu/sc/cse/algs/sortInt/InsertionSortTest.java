package edu.sc.cse.algs.sortInt;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import edu.sc.cse.algs.sortInt.InsertionSort;

public class InsertionSortTest {
	InsertionSort insert = new InsertionSort();	
	
	private int[] unsorted_combined = {6, 3, 9, 10, -1, 1, 89, 0, -34, 23, -54, 2, 45, 7, 90, -23, -10};
	private int[] ascending_combined = {-54, -34, -23, -10, -1, 0, 1, 2, 3, 6, 7, 9, 10, 23, 45, 89, 90};
	private int[] descending_combined = {90, 89, 45, 23, 10, 9, 7, 6, 3, 2, 1, 0, -1, -10, -23, -34, -54};

	@Test
	public void testSortAscending() {
		Assert.assertArrayEquals(ascending_combined,
				insert.sortAscending(unsorted_combined));
	}
	@Test
	public void testSortAscending2() {
		Assert.assertArrayEquals(ascending_combined,
				insert.sortAscending2(unsorted_combined));
	}
}
