/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
*/

//SOLUTION___________________________________________________________________________________________________________________

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int size = matrix.length;
        if(size == 0)                //If matrix is empty return false
        {
            return  false;
            
        }
        
        int n = size, m = matrix[0].length;   // n = row number  &  m = column number
        int low = 0, high = (n * m) - 1;     //  high=(n *m) - 1 is last imaginary index
        
          //BINARY SEARCH 
        while(low <= high)
        {
            int mid = (low + (high - low) / 2);
            
            if(matrix[mid / m][mid % m] == target){
                return true;
            }
            
           else if(matrix[mid / m][mid % m] <= target){
                low = mid + 1;     // search on right half of matrix so low will become  "low = mid + 1"
            }
            
            else
                high = mid -1;    // search on left half of matrix so high will become  "high = mid - 1"
            
        }
        return false;
    }
}
