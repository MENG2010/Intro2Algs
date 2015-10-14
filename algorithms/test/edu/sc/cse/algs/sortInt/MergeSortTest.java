package edu.sc.cse.algs.sortInt;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import edu.sc.cse.algs.sortInt.MergeSort;

import java.util.Arrays;
import java.util.Random;

public class MergeSortTest {
	private int[] numbers;
	private final static int SIZE = 20;
	private final static int MAX = 30;
	
	@Before
	public void setup() throws Exception {
		numbers = new int[SIZE];
		Random generator = new Random();
		
		for (int i=0; i<numbers.length; i++) {
			numbers[i] = generator.nextInt(MAX);
			System.out.print(numbers[i] + " ");
		}
		System.out.println("\n========");
	}
	
	@Test
	public void testMergeSort() {
		long startTime = System.currentTimeMillis();
		
		MergeSort sorter = new MergeSort();
		sorter.sort(numbers);
		
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("MergeSort " + elapsedTime);
		System.out.print(numbers[0] + " ");
		
		for (int i=1; i<numbers.length; i++) {
			System.out.print(numbers[i] + " ");
			if (numbers[i] < numbers[i-1]) {
				fail("Should not happen");
			}
		}
		System.out.println();
		assertTrue(true);
	}
	
	@Test
	public void itWorksRepeatably() {
		for (int i=0; i<200; i++) {
			numbers = new int[SIZE];
			Random generator = new Random();
			for (int j=0; j<numbers.length; j++) {
				numbers[j] = generator.nextInt(MAX);
			}
			
			MergeSort sorter = new MergeSort();
			sorter.sort(numbers);
			for (int j=0; j<numbers.length-1; j++) {
				if (numbers[j] > numbers[j+1]) {
					fail("Should not happen");
				}
			}
			assertTrue(true);
		}
	}
	
	@Test
	public void testStandardSort() {
		long startTime = System.currentTimeMillis();
		Arrays.sort(numbers);
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("Standard Java sort " + elapsedTime);
		
		for (int i=0; i<numbers.length-1; i++) {
			if (numbers[i] > numbers[i+1]) {
				fail("Should not happen");
			}
		}
		assertTrue(true);
	}
}