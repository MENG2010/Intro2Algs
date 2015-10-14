package edu.sc.cse.algs.sortInt;

public class MergeSort {
	private int[] numbers;
	private int[] assistant;
	
//	private int length;
	
	public void sort(int[] unsorted) {
		this.numbers = unsorted;
		int len = unsorted.length;
		this.assistant = new int[len];
		
		mergesort(0, len-1);
	}
	
	private void mergesort(int low, int high) {
		if (low < high) {
			int middle = (low + high) /2;
			mergesort(low, middle);
			mergesort(middle+1, high);
			merge(low, middle, high);
		}
	}
	
	private void merge(int low, int middle, int high) {
		for (int i=low; i<=high; i++) {
			assistant[i] = numbers[i];
		}
		
		int i=low, j=middle+1, k=low;
		
		while ( i<=middle && j<=high) {
			if (assistant[i] <= assistant[j]) {
				numbers[k] = assistant[i];
				i++;
			} else {
				numbers[k] = assistant[j];
				j++;
			}
			k++;
		}
		
		while (i<=middle) {
			numbers[k] = assistant[i];
			k++;
			i++;
		}
	}
}
