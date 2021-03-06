Given an unsorted array of size n. Array elements are in the range from 1 to n. One number from set {1, 2, …n} is missing and one number occurs twice in the array. Find these two numbers.

Examples: 

 Input: arr[] = {3, 1, 3}
Output: Missing = 2, Repeating = 3
Explanation: In the array, 
2 is missing and 3 occurs twice 

Input: arr[] = {4, 3, 6, 2, 1, 1}
Output: Missing = 5, Repeating = 1
________________________________________________________________________________________________________________________________

Solution: 

import java.lang.Math;

public class Array {

	static void Missing_duplicate(int arr[], int size)
	{
		int i;
		
		// Finding duplicates value 
		for (i = 0; i < size; i++) {
			int abs_val = Math.abs(arr[i]);
			if (arr[abs_val - 1] > 0)
				arr[abs_val - 1] = -arr[abs_val - 1];
			else
			{
				System.out.println("The repeating element is " + abs_val);
		    }
		}
		
		// finding missing value
		for (i = 0; i < size; i++) {
			if (arr[i] > 0)
				System.out.println("And the missing element is " + (i + 1));
		}
	}


	public static void main(String[] args)
	{
		int arr[] = { 4, 5, 6, 2, 1, 2 };
		int size = arr.length;
		Missing_duplicate(arr, size);
	}
}

_____________________________________________________
OUTPUT:
java -cp /tmp/l9owIxnjUk Array
The repeating element is 2
And the missing element is 3

