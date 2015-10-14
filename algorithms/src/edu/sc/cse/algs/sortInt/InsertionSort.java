package edu.sc.cse.algs.sortInt;

/**
 * 
 * @author meng
 *
 */
public class InsertionSort {
	public int[] sortAscending(int[] unsorted) {
		int tmp;
		
		for (int i=1; i<unsorted.length; i++) {
			for (int j=0; j<i; j++) {
				if (unsorted[i] < unsorted[j]) {
					tmp = unsorted[i];
					for (int k=i-1; k>j-1; k--) {
						unsorted[k+1] = unsorted[k];
					}
					unsorted[j] = tmp;
				}
			}
		}
		
		return unsorted;
	}
	
	public int[] sortAscending2(int[] unsorted) {
		int tmp, j = 0;
		
		for (int i=1; i<unsorted.length; i++) {
			if (unsorted[i-1] > unsorted[i]) {
				tmp = unsorted[i];
				for (j=i-1; j>=0; j--) {
					if (tmp < unsorted[j])
						unsorted[j+1] = unsorted[j];
					else
						break;
				}
				unsorted[j+1] = tmp;
			}
		}
		
		return unsorted;
	}
	
	public static void main(String[] args) {
		int[] unsorted = {6, 3, 9, 10, -1, 1, 89, 0, -34, 23, -54, 2, 45, 7, 90, -23, -10};
		InsertionSort sort = new InsertionSort();
		
		for (int i=0; i<unsorted.length; i++) {
			System.out.print(unsorted[i] + " ");
		}
		System.out.println();
		
		int[] sorted = sort.sortAscending2(unsorted);
		
		for (int i=0; i<sorted.length; i++) {
			System.out.print(sorted[i] + " ");
		}
		System.out.println();
	}
}
