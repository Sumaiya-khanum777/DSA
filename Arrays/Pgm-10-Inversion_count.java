/*Given an array of integers. Find the Inversion Count in the array. 

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted.
If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the
inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j. 

Example 1:

Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 
has three inversions (2, 1), (4, 1), (4, 3).
Example 2:

Input: N = 5
arr[] = {2, 3, 4, 5, 6}
Output: 0
Explanation: As the sequence is already 
sorted so there is no inversion count.*/

//SOLUTION___________________________________________________________________________________________________________

class Solution
    {
        // arr[]: Input Array
        // N : Size of the Array arr[]
        //Function to count inversions in the array.
        static long inversionCount(long arr[], long N)
        {
            // Your Code Here
            long temp[] = new long[(int)N];
            return merge_sort(arr,0,N-1,temp);

        }

    
        static long merge(long arr[],long temp[],long left,long mid,long right){

            long i, j, k; 
            long inv_count = 0; 
            
            i = left; //index  for left subarray.
            j = mid;  //index  for right subarray.
            k = left; //index for resultant merged subarray - to mark in temp array.

            
            while ((i <= mid - 1) && (j <= right)) {
                
                if (arr[(int)i] <= arr[(int)j]) { 
                    temp[(int)k++] = arr[(int)i++]; 
                } 
                else { 
                    temp[(int)k++] = arr[(int)j++]; 
                    inv_count = inv_count + (mid - i); 
                } 
            } 

            
            while (i <= mid - 1)   //if right pointer exceeds we copy all to left array
                temp[(int)k++] = arr[(int)i++]; 

            
            while (j <= right)    //if lft pointer exceeds we copy all to right array
                temp[(int)k++] = arr[(int)j++]; 

            
            for (i = left; i <= right; i++)   //temp array will store the sorted of left and right
                arr[(int)i] = temp[(int)i]; 

            return inv_count; //returning invertion count


        }
        
        static long merge_sort(long arr[],long lft,long right,long temp[]){

            long mid,inv_count =0;
            if(lft<right){
                mid = (lft+right)/2; //Splitting into two halves

                inv_count = merge_sort(arr, lft ,mid,temp); //first split-lft to mid

                inv_count += merge_sort(arr,mid+1,right,temp); // second split mid+1 to right

                inv_count += merge(arr,temp,lft,mid+1,right);
            }
            return inv_count;

        }

    }
