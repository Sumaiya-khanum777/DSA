/*
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
-104 <= xn <= 104

*/

//SOLUTION________________________________________________________________________________________________________________

class Solution {
    public double myPow(double x, int n) {
        
        double res = 1.0;
        long pwr = n;   // creating duplicate of power 
        
        if(pwr < 0)      // if pwr is negative
            pwr = - 1 * pwr;     // make it positive 
        
        // Binary exponentiation
        
        while(pwr > 0)   // for pwr > 0===> [positive powers]
        {
            
            if(pwr % 2 == 1)  // if pwr is odd
            {
                res = res * x;  // multiply x with result &
                pwr = pwr - 1;  // reduce pwr by 1
            }
            
            
             else          // if pwr is even
             {
                 
                 x = x * x;      // multiply x with itself &
                pwr = pwr / 2;   // divide pwr by 2
             }
            
        }
        // pwr==0
        
        if(n < 0)    // if given pwr value i.e n is negative
        {
           res = (double)(1.0) / (double)(res);   //then res= 1/res
        }
        
        return res; // return final result value
    }
}
