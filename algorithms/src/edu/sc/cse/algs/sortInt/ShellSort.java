package edu.sc.cse.algs.sortInt;

public class ShellSort {
	public int[] sortAscending(int[] unsorted) {
		int tmp, k;
		
		for (int gap=unsorted.length/2; gap>0; gap/=2) {
			for (int i=0; i<gap; i++) {
				for (int j=i+gap; j<unsorted.length; j+=gap) {
					if (unsorted[j] < unsorted[j-gap]) {
						tmp = unsorted[j];
						for (k=j-gap; k>=0 && unsorted[k]>tmp; k-=gap) {
							unsorted[k+gap] = unsorted[k];
						}
						unsorted[k+gap] = tmp;
					}
				}
			}
		}
		
		return unsorted;
	}
	
	public int[] sortAscending2(int[] unsorted) {
		int tmp, j;
		
		for (int step=unsorted.length/2; step>0; step/=2) {
			for (int i=step; i<unsorted.length; i++) {
				for (j=i-step; j>=0 && unsorted[j]>unsorted[j+step]; j-=step) {
					tmp = unsorted[j+step];
					unsorted[j+step] = unsorted[j];
					unsorted[j] = tmp;
				}
			}
		}
		return unsorted;
	}
	
	public static void main(String[] args) {
		int[] unsorted = {6, 3, 9, -1, 0, 23, 7, 9, -1, -10};
		ShellSort sort = new ShellSort();
		
		for (int i=0; i<unsorted.length; i++) {
			System.out.print(unsorted[i] + " ");
		}
		System.out.println();
		
		int[] sorted = sort.sortAscending(unsorted);
		
		for (int i=0; i<sorted.length; i++) {
			System.out.print(sorted[i] + " ");
		}
		System.out.println();
	}
}
