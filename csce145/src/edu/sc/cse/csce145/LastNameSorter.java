package edu.sc.cse.csce145;

/**
 * 
 * @author meng
 * lab 11 Last Name Sorter
 */
public class LastNameSorter {
	public String[] sortByLastName (String[] names) {
		char[] initialOfFamilyNames = new char[names.length];
		
		// get initials
		for (int i = 0; i < names.length; i++) {
			initialOfFamilyNames[i] = names[i].charAt(names[i].indexOf(" ") + 1);
		}
		
		// sort by initial of family name
		// insertion sort
		for (int i = 1; i < initialOfFamilyNames.length; i++) {
			char tmpInitial = initialOfFamilyNames[i];
			String tmpName = names[i];
			int j = i;
			
			// move names along with the initials
			while (j > 0 && initialOfFamilyNames[j - 1] > tmpInitial) {
				initialOfFamilyNames[j] = initialOfFamilyNames[j - 1];
				names[j] = names[j - 1];
				j--;
			}
			initialOfFamilyNames[j] = tmpInitial;
			names[j] = tmpName;
		}
		
		return names;
	}
	
	// printing given array
	public void printArray(String[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",\t");
			if (i > 0 && i % 5 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}
	
	public static void main(String[] arg) {
		String[] names = {"AWAB KINDI", "ALEXANDER REESER", "PHOEBE NGO",
							"PETER CLAY", "AUSTIN HERRMANN", 
							"NITAYA MCCORMICK", "MAISON BECKER",
							"WILLIAM STAYANOFF", "ALEX WEEKS", "XIYUAN ZHENG"};
		
		LastNameSorter sorter = new LastNameSorter();
		System.out.println("unsorted");
		sorter.printArray(names);
		System.out.println("sorted");
		sorter.printArray(sorter.sortByLastName(names));
	}
}
