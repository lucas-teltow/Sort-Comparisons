//Lucas Teltow
//MergeSort.java


//includes
import java.io.*;

public class MergeSort {
	/**	The method for sorting the numbers */
	public static int[] mergeSort(int[] list, int[] vals, int mode) {
	    //counter variables
	    long time = System.currentTimeMillis(); //for the time the execution takes
	    
		if (list.length > 1) {
			//	Merge sort the first half
			int [] firstHalf = new int[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			vals = mergeSort(firstHalf, vals, 2);
			
			//Merge sort the second half
			int secondHalfLength = list.length - list.length / 2;
			int[] secondHalf = new int[secondHalfLength];
			System.arraycopy(list, list.length / 2, 
				secondHalf, 0, secondHalfLength);
			vals = mergeSort(secondHalf, vals, 2);
			
			//	Merge firstHalf with secondHalf into list
			vals = merge(firstHalf, secondHalf, list, vals);
			
			if(mode == 1)
			{
			    System.out.println("Sort: Merge Sort");
		        System.out.println("Comparisons: " + vals[0]);
	            System.out.println("Swaps: " + vals[1]);
	            time = (time - System.currentTimeMillis()) * -1;
	            System.out.println("Time: " + time);
			}//making it only print a single time
		}
		return vals;
	}//end of mergeSort function
	
	/** Merge two sorted list */
	public static int[] merge(int[] list1, int[] list2, int[] temp, int[] vals) {
		int current1 = 0; // Current index in list1
		int current2 = 0; // Current index in list2
		int current3 = 0; // Current index in temp
		
		while (current1 < list1.length && current2 < list2.length) {
		    vals[0]++;
			if (list1[current1] < list2[current2])
				temp[current3++] = list1[current1++];
			else
				temp[current3++] = list2[current2++];
		}
		
		while (current1 < list1.length) {
			temp[current3++] = list1[current1++];
			vals[1]++;
		}
		
		while (current2 < list2.length) {
			temp[current3++] = list2[current2++];
		    vals[1]++;
		}
		return vals;
	}//end of merge function
	/**
	/** A test method *
	public static void main(String[] args) {
		int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		mergeSort(list);
		for (int i = 0; i < list.length; i++)
			System.out.println(list[i] + " ");
	}
	*/
}//end of mergeSort class
