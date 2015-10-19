package edu.sc.cse.algs.select;

import java.util.Random;

/**
 * 
 * @author meng (y.meng201011@gmail.com)
 * 
 * Implement of exercise 9.2.3 (Introduction to Algorithms)
 */
public class RandSelectRecursive {
	// exchange the ith element and the jth element in array A 
	public void swap (int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	
	// get a random int between a and b
	public int random (int a, int b) {
		Random r = new Random();
		int q = r.nextInt((b - a) + 1) + a;
		return q;
	}
	
	// return the index of pivot element
	public int partition (int[] A, int p, int r) {
		int key = A[r];
		int i = p - 1;
		
		for (int j = p; j < r; j++) {
			if (A[j] <= key) {
				i++;
				swap(A, i, j);
			}
		}
		i++;
		swap(A, i, r);
		
		return i;
	}
	
	// return the index of pivot element
	public int randPartition (int[] A, int p, int r) {
		int q = random(p, r);
		swap(A, q, r);
		return partition(A, p, r);
	}
	
	public int randSelect (int[] A, int p, int r, int i) {
		if (p == r) {
			return A[p];
		}
		int q = randPartition(A, p, r);
		int k = q - p + 1;
		if (i == k) {
			return A[q];
		} else if (i < k) {
			return randSelect(A, p, q - 1, i);
		} else {
			return randSelect(A, q + 1, r, i - k);
		}
	}
	
	void printArray (int[] A) {
		for (int i = 0; i < A.length - 1; i++) {
			System.out.print(A[i] + ", ");
		}
		System.out.println(A[A.length - 1]);
	}
	public static void main (String[] args) {
		RandSelectRecursive demo = new RandSelectRecursive();
		int i = 6;
		int[] A = {5, 2, 6, 7, 3, 0, 9, 1, 8};
		System.out.println("before exchange");
		demo.printArray(A);
		System.out.println("searching for " + i);
		System.out.println(demo.randSelect(A, 0, A.length - 1, i));
		demo.printArray(A);
	}
}
