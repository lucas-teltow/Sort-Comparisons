//Lucas Teltow
//HeapSort.java


//includes
import java.io.*;

public class HeapSort {
	/** Heap sort method */
	public static <E extends Comparable<E>> void heapSort(E[] list) {
	    //counter variables
	    long time = System.currentTimeMillis(); //for the time the execution takes
	    
		//	Create a Heap of integers
		Heap<E> heap = new Heap<>();
		
		//	Add elements to the heap
		for (int i = 0; i < list.length; i++)
			heap.add(list[i]);
		
		//	Remove elements from the heap
		for (int i = list.length -1; i >= 0; i--)
			list[i] = heap.remove();
			
		System.out.println("Sort: Heap Sort");
		System.out.println("Comparisons: " + heap.getComparisons());
	    System.out.println("Swaps: " + heap.getSwaps());
	    time = (time - System.currentTimeMillis()) * -1;
	    System.out.println("Time: " + time);
	}//end of heapSort function
	
	
 	/**	A test method 
	public static void main(String[] args) {
		Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
		heapSort(list);
		for(int i = 0; i < list.length; i++)
			System.out.println(list[i] + " ");
	}//end of main function
	*/
	
}//end of heapSort class
