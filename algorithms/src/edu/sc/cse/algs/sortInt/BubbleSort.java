package edu.sc.cse.algs.sortInt;

/**
 * 
 * @author meng
 * 
 */
public class BubbleSort {
	
	public int[] sort(int[] unsorted) {
		for (int i=0; i<unsorted.length; i++) {
			for (int j=0; j<i; j++) {
				if (unsorted[j] > unsorted[i]) {
					int tmp = unsorted[i];
					unsorted[i] = unsorted[j];
					unsorted[j] = tmp;
				}
			}
		}
		
		return unsorted;
	}
	
}
