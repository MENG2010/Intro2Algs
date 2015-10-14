package edu.sc.cse.algs.sortInt;

/**
 * 
 * @author meng
 *
 */
public class SelectionSort {
	public int[] sortAscending(int[] unsorted) {
		int tmp, index;
		
		for (int i=0; i<unsorted.length; i++) {
			tmp = unsorted[i];
			index = i;
			
			for (int j=i; j<unsorted.length; j++) {
				if (tmp > unsorted[j]) {
					tmp = unsorted[j];
					index = j;
				}
				
			}
			if (index != i) {
				unsorted[index] = unsorted[i];
				unsorted[i] = tmp;				
			}
		}
		
		return unsorted;
	}

	public static void main(String[] args) {
		
	}
}
