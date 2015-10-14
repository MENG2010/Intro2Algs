package edu.sc.cse.algs.sortInt;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import edu.sc.cse.algs.sortInt.QuickSort;

public class QuickSortTest {
	QuickSort quick = new QuickSort();	
	
	private int[] unsorted_combined = {6, 3, 9, 10, -1, 1, 89, 0, -34, 23, -54, 2, 45, 7, 90, -23, -10};
	private int[] ascending_combined = {-54, -34, -23, -10, -1, 0, 1, 2, 3, 6, 7, 9, 10, 23, 45, 89, 90};
	private int[] descending_combined = {90, 89, 45, 23, 10, 9, 7, 6, 3, 2, 1, 0, -1, -10, -23, -34, -54};
	
	private int[] unsorted_positive = {2, 4, 3, 3, 50, 39, 28, 12, 4, 64, 34, 23, 90, 90, 23, 34, 8};
	private int[] ascending_positive = {2, 3, 3, 4, 4, 8, 12, 23, 23, 28, 34, 34, 39, 50, 64, 90, 90};
	private int[] descending_positive = {90, 90, 64, 50, 39, 34, 34, 28, 23, 23, 12, 8, 4, 4, 3, 3, 2};
	
	private int[] unsorted_negative = {-2, -4, -12, -34, -2, -8, -32, -12, -30, -10};
	private int[] ascending_negative = {-34, -32, -30, -12, -12, -10, -8, -4, -2, -2};
	private int[] descending_negative = {-2, -2, -4, -8, -10, -12, -12, -30, -32, -34};
	
	@Test
	public void testSortAscending_Combined() {
		Assert.assertArrayEquals(ascending_combined,
				quick.sortAscending(unsorted_combined, 0, unsorted_combined.length-1));
	}

	@Test
	public void testSortDescending_Combined() {
		Assert.assertArrayEquals(descending_combined,
				quick.sortDescending(unsorted_combined, 0, unsorted_combined.length-1));
	}
	
	@Test
	public void testSortAscending_Negative() {
		Assert.assertArrayEquals(ascending_negative,
				quick.sortAscending(unsorted_negative, 0, unsorted_negative.length-1));
	}
	
	@Test
	public void testSortDescending_Negative() {
		Assert.assertArrayEquals(descending_negative,
				quick.sortDescending(unsorted_negative, 0, unsorted_negative.length-1));
	}
	
	@Test
	public void testSortAscending_Positive() {
		Assert.assertArrayEquals(ascending_positive,
				quick.sortAscending(unsorted_positive, 0, unsorted_positive.length-1));
	}
	
	@Test
	public void testSortDescending_Positive() {
		Assert.assertArrayEquals(descending_positive, 
				quick.sortDescending(unsorted_positive, 0, unsorted_positive.length-1));
	}
}
