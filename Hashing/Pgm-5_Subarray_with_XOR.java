/*
Given an array of integers A and an integer B.

Find the total number of subarrays having bitwise XOR of all elements equals to B.


Problem Constraints
1 <= length of the array <= 105

1 <= A[i], B <= 109

Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the total number of subarrays having bitwise XOR equals to B.


Example Input
Input 1:

 A = [4, 2, 2, 6, 4]
 B = 6
Input 2:

 A = [5, 6, 7, 8, 9]
 B = 5


Example Output
Output 1:

 4
Output 2:

 2


Example Explanation
Explanation 1:

 The subarrays having XOR of their elements as 6 are:
 [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]
Explanation 2:

 The subarrays having XOR of their elements as 2 are [5] and [5, 6, 7, 8, 9]


*/


SOLUTION:

public class Solution {
    public int solve(int[] A, int B) {

    
      HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>(); //create an hashtable
      
      int size = A.length, count = 0, xor = 0;
      
      for(int i = 0; i < size; i++) //LINEARLY Traverse through all elements of array
      {
          xor = xor ^ A[i];  //PREFIX XOR
          

          if(hash.get(xor ^ B) != null)
           {
               count += hash.get(xor ^ B);
           }

           if(xor === B)    //if prefix xor == B then we increment count
           {
               count++;
           }
             
          ?? inserting into hash table

           if(hash.get(xor) != null)   // if it already exists then we add previous xor by adding 1 to it
             {
                 hash.put(xor, hash.get(xor)) + 1);
             }

             else
             {
                 hash.put(xor, 1);    // if value does not exists then we add current xor to the hash table with 1- first time apppearance

             }
           
      }
      
        return count;



    }
}
