/*
Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

Example 1:

Input:
N = 8
A[] = {15,-2,2,-8,1,7,10,23}
Output: 5
Explanation: The largest subarray with
sum 0 will be -2 2 -8 1 7.
Your Task:
You just have to complete the function maxLen() which takes two arguments an array A and n, where n is the size of the array A and returns the length of the largest subarray with 0 sum.

Expected Time Complexity: O(N*Log(N)).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 105
-1000 <= A[i] <= 1000, for each valid i
*/

SOLUTION:

class GfG
{
    /*You are required to complete this function*/

int maxLen(int A[], int n)
{
    // Your code here
    
      HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>(); //create an hashtable
      
      int max_len = 0, sum = 0;
      
      for(int i = 0; i < n; i++) //Traverse through all elements of array
      {
          sum += A[i]; 
        
           if(sum == 0)
           {
               max_len = i +1;
           }
           
           else
           {
               if(hash.get(sum) != null) //if this is found in hash table
               {
                   max_len = Math.max(max_len, i - hash.get(sum));
               }
               
               else   //if sum is not found then we add it with index to hash able in else case
               hash.put(sum,i);
               
           }
          
      }
      
        return max_len;
}
}
