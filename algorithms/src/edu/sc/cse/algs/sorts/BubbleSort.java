package edu.sc.cse.algs.sorts;

/**
 * http://en.wikipedia.org/wiki/Bubble_sort
 * procedure BubbleSort (A : list of sortable items)
 * 		n = length (A)
 * 		repeat
 * 			newn = 0
 * 			for i = 1 to (n - 1) inclusive do
 * 				if A[i - 1] > A[i] then
 * 					swap(A[i - 1], A[i])
 * 					newn(i)
 * 				end if
 * 			end for
 * 			n = newn
 * 		until n = 0
 * end procedure
 * 
 * @author meng (y.meng201011@gmail.com)
 *	avg case O(n^2); worst case O(n^2)
 *
 */
import java.util.Random;
public class BubbleSort <T extends Comparable<T>> {
	public BubbleSort() {
		
	}
	
	public <T extends Comparable<T>> T[] sort(T[] unsorted) {
		// bubbling
		for (int i = 0; i < unsorted.length; i++) {
			for (int j = 0; j < i; j++) {
				if (unsorted[i].compareTo(unsorted[j]) < 0) {
					swap(i, j, unsorted);
				}
			}
		}
		
		// implement with WHILE-LOOP
//		boolean swapped = true;
//		int length = unsorted.length;
		
//		while (swapped) {
//			swapped = false;
//			for (int i = 1; i < length; i++) {
//				if (unsorted[i].compareTo(unsorted[i - 1]) < 0) {
//					swap(i, i - 1, unsorted);
//					swapped = true;
//				}
//			}
//			length--;
//		}
		return unsorted;
	}
	
	private <T extends Comparable<T>> void swap(int index1, 
												int index2, 
												T[] unsorted) {
		T value = unsorted[index1];
		unsorted[index1] = unsorted[index2];
		unsorted[index2] = value;
	}
	
	// test
	private void printOut(T[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
			if (i != 0 && (i + 1) % 5 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}
	
	// test
	public static void main(String[] args) {
		String[] str = {"github", ".com", "machine learning", "here we go!", "salary prediction",
				"software", "productivity", "person of interest", "all the best", "algorithms",
				"practise", "online", "work hard", "bubble sort", "01234",
				"what is this?", "sorting algs", "random numbers", "Two years", "Noticed"};
		Integer[] numbers = new Integer[10];
		Random random = new Random();
		BubbleSort sorter = new BubbleSort();
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(10);
		}
		System.out.println("unsorted");
		sorter.printOut(str);
		System.out.println("sorted");
		sorter.printOut(sorter.sort(str));
		
		System.out.println("unsorted");
		sorter.printOut(numbers);
		System.out.println("sorted");
		sorter.printOut(sorter.sort(numbers));
		
	}
}
