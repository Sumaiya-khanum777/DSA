/*Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Follow-up: Could you solve the problem in linear time and in O(1) space?

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]
 ______________________________________________________________________
Constraints:

1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109
  
  */

//SOLUTION______________________________________________________________________________________________________________________

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = -1, num2 = -1, count1 = 0, count2 =0, size=nums.length;
        
        //Traversing through entire list
            
        for(int i: nums){
            
            if(i == num1)
            {
                count1++;                
            }
            
            else if(i == num2)     
            { 
                count2++;                
            }
            
            else if(count1 == 0)
            { 
                num1 = i;
                count1 = 1;
            }
            else if(count2 == 0)
            {
                num2 = i;
                count2 = 1;
            }
            else
            {
                count1--;
                count2--;
            }
        }
        List<Integer> res = new ArrayList<Integer>();
            
            count1=0;
            count2=0;
            
     
            for( int j: nums)
            {
                if(j == num1)
                {
                    count1++;
                }
                else if(j == num2)
                {
                    count2++;
                }               
                
            }
        
            if(count1>size/3)
            {
                res.add(num1);
            }
        
            if(count2>size/3){
                res.add(num2);
            }
            
            
            
                return res;
        
    }
}
