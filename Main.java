/******************************************************************************

Lucas Teltow
Main.java

*******************************************************************************/
import java.io.*;
import java.lang.*;
import java.util.Scanner;
import java.util.Random;

class Main
{
    //main function
    public static void main(String[] args) throws IOException
    {
        //various variables
        Scanner in = new Scanner(System.in);                                    //scanner for the console inputs
        int[] test = {10,5,2,5,7,34,3,6,5,25,6,7,457,357,457,8,5,4,3,44,24};    //a test list for making sure the sorts are running
        InsertionSort insert = new InsertionSort();                             //an insertionSort object for running its sort
        HeapSort heap = new HeapSort();                                         //a heapSort object for running its sort
        MergeSort merge = new MergeSort();                                      //a mergeSort object for running its sort
        QuickSort quick = new QuickSort();                                      //a quickSort object for running its sort
        RadixSort radix = new RadixSort();                                      //a radixSort object for running its sort
        SelectionSort selection = new SelectionSort();                          //a selectionSort object for running its sort
        int orderNum;                                                           //for getting the order the user wants
        int sizeNum;                                                            //for getting the size the user wants
        int sortNum;                                                            //for getting the sort the user wants
        Random rand = new Random();                                             //for generating random numbers
        int temp = 0;                                                           //a temp variable for storing ints
        int[] list = {0};                                                       //for storing the list of numbers to be sorted
        int comparisons = 0;                                                    //for counting comparisons
        int swaps = 0;                                                          //for counting swaps
        int[] vals = {0, 0, 0};                                                 //for counting swaps and comparisons
        long time = 0;                                                          //for tracking the time

        //running the interface
        //getting the correct order of the list
        System.out.println("Choose the list order by typing the number next to it");
        System.out.println("1. In Order\n2. Reverse Order\n3. Almost Order\n4. Random Order");
        orderNum = in.nextInt();
        System.out.println("List order " + orderNum + " selected");
        
        //getting the correct size of the list
        System.out.println("Choose the list size by typing the number next to it");
        System.out.println("1. 5000\n2. 15000\n3. 50000");
        sizeNum = in.nextInt();
        if(sizeNum == 1)
            sizeNum = 5000;
        if(sizeNum == 2)
            sizeNum = 15000;
        if(sizeNum == 3)
            sizeNum = 50000;
        System.out.println("List size " + sizeNum + " selected");
        
        //getting the correct order of the list
        System.out.println("Choose the type of sort by typing the number next to it");
        System.out.println("1. Insertion Sort\n2. Selection Sort\n3. Quick Sort\n4. Merge Sort\n5. Heap Sort\n6. Radix Sort");
        sortNum = in.nextInt();
        System.out.println("Sort type " + sortNum + " selected");
        
        
        //making the correct sized list
        switch (sizeNum) {
            case 5000:
                list = new int[5000];
                for(int i = 0; i < 5000; i++)
                    list[i] = rand.nextInt(101);
                break;
            case 15000:
                list = new int[15000];
                for(int i = 0; i < 15000; i++)
                    list[i] = rand.nextInt(101);
                break;
            case 50000:
                list = new int[50000];
                for(int i = 0; i < 50000; i++)
                    list[i] = rand.nextInt(101);
                break;
        }//end of list size switch
        
        
        //making the list have the correct initial order
        switch (orderNum) {
            case 1:         //in order
                insert.insertionSort(list, 1);
                break;
            case 2:         //reverse order
                insert.insertionSort(list, 1);
                for(int i = 1; i < (list.length / 2); i++)
                {
                    temp = list[list.length - i];
                    list[list.length - i] = list[i];
                    list[i] = temp;
                }//end of reversing the list order
                break;
            case 3:         //almost in order
                insert.insertionSort(list, 1);
                for(int i = 0; i < (list.length - 5); i++)
                {
                    //checking dont swap every number
                    if(i % 10 == 0 || i % 11 == 0) {
                    temp = list[i + 2];
                    list[i + 2] = list[i];
                    list[i] = temp;
                    }//end of if state
                }//end of reversing the list order
                break;
        }//end of setting the initial order switch
        
        
        //creating a version of the list made of Integer objects instead of ints
        Integer[] integerArray = new Integer[sizeNum];
        for(int i = 0; i < list.length; i++)
        {
            integerArray[i] = list[i];
        }//end of creating a list copy
        
        
        //start of the output
        System.out.print("Eperimental Results:\nInput Size: " + sizeNum + "\nIntial Sort Order: ");
        switch (orderNum) {
            case 1: 
                System.out.println("In Order");
                break;
            case 2: 
                System.out.println("Reverse Order");
                break;
            case 3: 
                System.out.println("Almost In Order");
                break;
            case 4: 
                System.out.println("Random Order");
                break;
        }//end of switch for which type of inital list we had
        //running the correct sort
        switch (sortNum) {
            case 1:             //insertionSort
                insert.insertionSort(list, 2);
                break;
            case 2:             //selectionSort
                selection.selectionSort(list);
                break;
            case 3:             //quickSort
                time = System.currentTimeMillis();
                vals = quick.quickSort(list, vals);
                System.out.println("Sort: Quick Sort");
		        System.out.println("Comparisons: " + vals[0]);
	            System.out.println("Swaps: " + vals[1]);
	            time = (time - System.currentTimeMillis()) * -1;
	            System.out.println("Time: " + time);
                break;
            case 4:             //mergeSort
                merge.mergeSort(list, vals, 1);
                break;
            case 5:             //heapSort
                heap.heapSort(integerArray);
                break;
            case 6:             //radixSort
                time = System.currentTimeMillis();
                vals = radix.radixSort(list, list.length, vals);
                System.out.println("Sort: Quick Sort");
		        System.out.println("Comparisons: " + vals[0]);
	            System.out.println("Swaps: " + vals[1]);
	            time = (time - System.currentTimeMillis()) * -1;
	            System.out.println("Time: " + time);
                break;
        }//end of switch for choosing the correct sort
    }//end of main function
}//end of main class