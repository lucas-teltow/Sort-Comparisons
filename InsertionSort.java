//Lucas Teltow
//InsertionSort.java


//includes
import java.io.*;
import java.lang.*;
import java.util.Scanner;
import java.time.*;

public class InsertionSort {
	/**The method for sorting the numbers */
	public static void insertionSort(int[] list, int mode) {
	    //counter variables
	    int comparisons = 0;                    //for the number of comparisons
	    int swaps = 0;                          //for the number of swaps
	    long time = System.currentTimeMillis(); //for the time the execution takes
	    
		for (int i = 1; i < list.length; i++) {
			/** Insert list[i] into a sorted sublist list[0..i-1] so that 
			 * 	list[0..i] is sorted
			 */
			int currentElement = list[i];
			int k;
			comparisons++;
			for (k = i-1; k>= 0 && list[k] > currentElement; k--) {
				list[k+1] = list[k];
				comparisons++;
			}//end of inner loop
			
			//insert the current element into list[k + 1]
			list[k + 1] = currentElement;
			swaps++;
			
		}//end of outer loop
		
		//checking if the data should be outputed, since some uses of the sort dont want output
		if(mode == 2) {
		    System.out.println("Sort: Insertion Sort");
		    System.out.println("Comparisons: " + comparisons);
	        System.out.println("Swaps: " + swaps);
	        time = (time - System.currentTimeMillis()) * -1;
	        System.out.println("Time: " + time);
		}//end of mode check
	} //end of InsertionSort function
}//end of InsertionSort class
