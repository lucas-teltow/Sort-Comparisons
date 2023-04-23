//Lucas Teltow
//QuickSort.java


//includes
import java.io.*;

public class QuickSort {
	public static int[] quickSort(int[] list, int[] vals) {
		vals = quickSort(list, 0, list.length-1, vals);
		return vals;
	}//end of quickSort function
	
	public static int[] quickSort(int[] list, int first, int last, int[] vals) {
	    vals[0]++;
		if (last > first) {
		    vals = partition(list, first, last, vals);
			quickSort(list, first, vals[2] -1, vals);
			quickSort(list, vals[2] + 1, last, vals);
		}
		return vals;
	}//end of quickSort function with a first and last int in addition to the list
	
	/** Partition the array list[first..last] */
	public static int[] partition(int[] list, int first, int last, int[] vals) {
		int pivot = list[(first + last)/2]; // Choose the first element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; //Index for backward search
		
		while (high > low) {
			// Search forward from left
			vals[0]++;
			while (low <= high && list[low] <= pivot)
				low++;
			
			// Search backward from right
			vals[0]++;
			while (low <= high && list[high] > pivot)
				high--;
			
			//	Swap two elements in the list
			vals[0]++;
			if (high > low) {
			    vals[1]++;
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
		
		
		while (high > first && list[high] >= pivot)
			high--;
		
		//	Swap pivot with list[high]
		vals[0]++;
		if (pivot > list[high]) {
		    vals[1]++;
			list[first] = list[high];
			list[high] = pivot; 
			vals[2] = high;
			return vals;
		}
		else {
		    vals[2] = first;
			return vals;
		}
	}//end of partition function
}//end of quickSort class
