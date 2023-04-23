//Lucas Teltow
//SelectionSort.java


//includes
import java.io.*;

public class SelectionSort {
	/** The method for sorting the numbers */
	public static void selectionSort(int[] list) { //int[] list?
	    int comparisons = 0;                    //for the number of comparisons
	    int swaps = 0;                          //for the number of swaps
	    long time = System.currentTimeMillis(); //for the time the execution takes
	
		for (int i = 0; i < list.length -1; i++) {
			// Find the minimum in the list[i..list.length-1]
			int currentMin = list[i];
			int currentMinIndex = i;
			
			for (int j = i+1; j < list.length; j++) {
				comparisons++;
				if (currentMin > list[j]) {
					currentMin = list[j];
					currentMinIndex = j;
					swaps++;
				}
			}
			
			//	Swap list[i] wiht list[currentMinIndex[ if necessary
			if (currentMinIndex != i) {
			    swaps++;
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
		
		System.out.println("Sort: Selection Sort");
		System.out.println("Comparisons: " + comparisons);
	    System.out.println("Swaps: " + swaps);
	    time = (time - System.currentTimeMillis()) * -1;
	    System.out.println("Time: " + time);
	}
}
