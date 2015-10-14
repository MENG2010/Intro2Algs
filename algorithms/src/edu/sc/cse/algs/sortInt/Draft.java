package edu.sc.cse.algs.sortInt;

public class Draft {
	int partition(int arr[], int left, int right) {
	      int i = left, j = right;
	      int tmp;
	      int pivot = arr[(left + right) / 2];

	      while (i <= j) {
	            while (arr[i] > pivot)
	                  i++;
	            while (arr[j] < pivot)
	                  j--;
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      }

	      return i;
	}

	int[] quickSort(int arr[], int left, int right) {
	      int index = partition(arr, left, right);
	      if (left < index - 1)
	            quickSort(arr, left, index - 1);
	      if (index < right)
	            quickSort(arr, index, right);
	      
	      return arr;
	}
	
	public static void main(String[] args) {
		int[] unsorted = {6, 3, 9, 10, -1, 1, 89, 0, -34, 23, -54, 2, 45, 7, 90, -23, -10};
		Draft sort = new Draft();
		
		int[] sorted = sort.quickSort(unsorted, 0, unsorted.length-1);
		
		for (int i=0; i<sorted.length; i++) {
			System.out.print(sorted[i] + " ");
		}
		System.out.println();
	}
}
