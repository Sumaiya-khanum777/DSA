/*You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

Example 3:
Input: matrix = [[1]]
Output: [[1]]

Example 4:
Input: matrix = [[1,2],[3,4]]
Output: [[3,1],[4,2]]


*******************************************LOGIC*****************************************
1.Find the Transpose of given matrix 
2.Using next two-pointer method reverse every row of the Transpose matrix

*/
//SOLUTION:____________________________________________________________________________________________________________________
class Solution {
    public void rotate(int[][] matrix) {
        
        int size=matrix.length, temp=0, i,j;
        
        //  find Transpose of given matrix 
        for(i=0; i<size; i++)
        {
           for(j=i; j<matrix[0].length; j++)  //j<3---->(no. of elements in 0th row)            {
            temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
            }
        } 
        
        // next apply two-pointer method to reverse every row of the matrix
        for(i=0; i<size; i++)
        {
            for(j=0; j < size/2; j++)
            {
            temp = matrix[i][j];
            matrix[i][j] = matrix[i][matrix.length-1-j];
            matrix[i][matrix.length-1-j] = temp;
            }
        } 
        
        
    }
}
