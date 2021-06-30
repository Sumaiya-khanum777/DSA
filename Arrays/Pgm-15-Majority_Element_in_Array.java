/* Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. 
You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
 
Constraints:
n == nums.length
1 <= n <= 5 * 104
-231 <= nums[i] <= 231 - 1
*/
/*
ALGORITHM USED====MOORE VOTING ALGORITHM

STEPS:

1. Create a variable to store the count value, count = 0
2. Traverse through the array from start to end(0 to n-1).
3. For every element in the array run a loop to find the count of similar elements in the given array.
4. If the count equals 0, then store the value at tht index in a new variable called element, elem=i.
5. if i==element then, keep increasing count; count++
6. else , keep decreasing count; count--
7. after traversing entire array return the element tht has occured n/2 (max count) times in an array.

*/

//SOLUTION_____________________________________________________________________________________________________________________

class Solution {
    public int majorityElement(int[] nums) {
        
        int count = 0, element = 0;
        
        for(int i : nums)
        {
            if(count == 0)
            {
                element = i;
            }
            
            if(i == element)
            {
                count++;
            }
            
            else
            {
                count--;
            }    
            
        }
        
        return element;
        
    }
}
