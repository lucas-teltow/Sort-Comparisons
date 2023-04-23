//Lucas Teltow
//RadixSort.java


//includes
import java.io.*;
import java.util.*;

class RadixSort {
	static int[] getMax(int arr[], int n, int[] vals) {
		vals[2] = arr[0];
		for (int i = 1; i < n; i++)
		{
		    vals[0]++;
			if (arr[i] > vals[2])
			{
			    vals[1]++;
				vals[2] = arr[i];
			}//swapping what mx value is
		}//end of for loop for checking if the mx is the max value
		return vals;
	}//end of getMax function

	static int[] countSort(int arr[], int n, int exp, int[] vals) {
		int output[] = new int[n];
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);
		for (i = 0; i < n; i++)
			count[(arr[i] / exp) % 10]++;
		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];
		// Build the output array
		for (i = n - 1; i >= 0; i--) {
		    vals[2]++;
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}
		for (i = 0; i < n; i++)
			arr[i] = output[i];
		
		return vals;
	}//end of countSort function

	static int[] radixSort(int arr[], int n, int[] vals) { // Find the maximum number to know number of digits
		vals = getMax(arr, n, vals);
		for (int exp = 1; vals[2] / exp > 0; exp *= 10)
			vals = countSort(arr, n, exp, vals);
			
		return vals;
	}//end of radixSort function

	static void print(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}//end of print function
	
	/**
	public static void main(String[] args) {
		int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
		int n = arr.length;
		radixSort(arr, n);
		print(arr, n);
	}
	*/
}//end of radixSort class