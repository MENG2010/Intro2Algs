package edu.sc.cse.csce145;

import java.util.Scanner;

/**
 * csce145
 * @author meng
 *
 */
public class InsertionSort {
	public int[] insertionSort(int[] numbers) {
		int element;
		int j;
		// core of insertion sort
		for (int i = 1; i < numbers.length; i++) {
			element = numbers[i];
			// the first index of unsorted portion
			// i.e., the last index of sorted portion is (j - 1)
			j = i;
			
			// inner loop - comparing current number 
			//              with all numbers in sorted portion,
			//              from right to left
			while (j > 0 && numbers[j - 1] > element) {
				numbers[j] = numbers[j - 1];
				j--;
			}
			numbers[j] = element;
		}
		
		return numbers;
	}
	
	// printing given array
	public void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		InsertionSort sorter = new InsertionSort();
		
		System.out.println("How many numbers do you want to sort?");
		Scanner in = new Scanner(System.in);
		int totalNum = in.nextInt();
		
		int[] numbers = new int[totalNum];
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.println("the #" + (i + 1) + " number is?");
			numbers[i] = in.nextInt();
		}
		
		System.out.println("unsorted:");
		sorter.printArray(numbers);
		System.out.println("sorted:");
		sorter.printArray(sorter.insertionSort(numbers));
	}
}
