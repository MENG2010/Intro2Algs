package edu.sc.cse.algs;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import edu.sc.cse.algs.sorts.BubbleSort;

public class Sorts <T extends Comparable<T>> {
	BubbleSort bubble = new BubbleSort();
	
	Random random = new Random();
	Integer[] numbers = new Integer[20];
	String[] strs = {"github", ".com", "machine learning", "here we go!", "salary prediction",
					"software", "productivity", "person of interest", "all the best", "algorithms",
					"practise", "online", "work hard", "bubble sort", "01234",
					"what is this?", "sorting algs", "random numbers", "Two years", "Noticed"};
	
	{
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(numbers.length);
		}
	}
	
	@Test
	public void test_bubble_sort_int() {
		assertTrue("bubble sort integers: ", check(bubble.sort(numbers)));
	}
	
	@Test
	public void test_bubble_sort_str() {
		assertTrue("bubble sort strings: ", check(bubble.sort(strs)));
	}
	
	// check if sorted
	private <T extends Comparable<T>> boolean check(T[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
//				System.out.println(i + ", " + j + ": " + array[i] + "; " + array[j]);
				if (array[i].compareTo(array[j]) < 0) {
					return false;
				}
			}
		}
		return true;
	}
}
