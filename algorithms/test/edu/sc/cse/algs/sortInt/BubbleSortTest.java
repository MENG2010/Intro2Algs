package edu.sc.cse.algs.sortInt;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import edu.sc.cse.algs.sortInt.BubbleSort;

public class BubbleSortTest {
	private BubbleSort bubble = new BubbleSort();
	private int[] unsorted = {6, 3, 9, 10, 89, 0, -34, 23, -54, 2, 45, 7, 90, -23, -10};
	private int[] ascending = {-54, -34, -23, -10, 0, 2, 3, 6, 7, 9, 10, 23, 45, 89, 90};
	private int[] descending = {90, 89, 45, 23, 10, 9, 7, 6, 3, 2, 0, -10, -23, -34, -54};

	@Test
	public void testSortAscd() {
		Assert.assertArrayEquals(ascending, bubble.sortAscending(unsorted));
	}

	@Test
	public void testSortDscd() {
		Assert.assertArrayEquals(descending, bubble.sortDescending(unsorted));
	}

}
