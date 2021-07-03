/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?

Example 1:
Input: m = 3, n = 7
Output: 28

Example 2:
Input: m = 3, n = 2
Output: 3

Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

Example 3:
Input: m = 7, n = 3
Output: 28

 
Constraints:
1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 109.
*/

//Practice Link: https://leetcode.com/problems/unique-paths/

/*____________________________________________________SOLUTION___(3____APPROACHES)________________________________________________________*/

// *****************************************EXPONENTIAL APPROACH**************************************************************************

class Solution {
    public int Count_uniquePaths(int i, int j,int m, int n) {
        if(i == (n - 1) && j == (m - 1))  // Applicable if matrix is 1x1 where i & j are pointers and n - 1 & m -1 are row_end and col_end
          return 1;
      
        if(i >= n || j >= m) //if OutOfBound condition is met then we return count as zero
          return 0;
       
        else
          return Count_uniquePaths(i + 1, j) + Count_uniquePaths(i , j + 1); //Combine the path count from right and bottom traversals
         
    }
}



// *****************************************Dynamic APPROACH [using Hash table]***********************************************************

class Solution {
    public int Count_uniquePaths(int i, int j,int m, int n, vector<vector<int>> &hshtble) {
        if(i == (n - 1) && j == (m - 1))  // Applicable if matrix is 1x1 where i & j are pointers and n - 1 & m -1 are row_end and col_end
          return 1;
      
        if(i >= n || j >= m) //if OutOfBound condition is met then we return count as zero
          return 0;
       
        if(hshtble[i][j] != -1)
          return hshtble[i][j];
        else
          return hshtble[i][j] = Count_uniquePaths(i + 1, j, dp) + Count_uniquePaths(i , j + 1, dp); //Combine the path count from right and bottom traversals
         
    }
}

//Brute Force

//Using recursion

Code: 
class Solution {
    public int uniquePaths(int m, int n) {
        
 if (m == 1 || n == 1)
            return 1;
 

        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        
        
    }
}

// *****************************************Optimised---NCR APPROACH [EFFICIENT WAY]**********************************************************

class Solution {
    public int uniquePaths(int m, int n) {
        
        // Using NCR Approach
        
        int N = m + n - 2;   // Common number of moves for all cases
        int r = m - 1;      // Number of repetitions in the loop || row_count - 1
        double res = 1;
        
        for(int i = 1; i <= r; i++)
        {
            res = res * ( N - r + i ) / i ;
        }
        
        return (int)res;
         
    }
}
