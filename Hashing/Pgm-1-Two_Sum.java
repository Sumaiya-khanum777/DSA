/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
  
Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

Constraints:
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
*/

PRACTICE LINK:https://leetcode.com/problems/two-sum/

//SOLUTION___________________________________________________________________________________________________________________

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res= new int[2];
        int i,j;
        for(i=0; i<nums.length;i++)
        {
            for( j=i+1;j<nums.length;j++)
            {
                if((target-nums[i])==nums[j])
                {
                    res[0]= i;
                    res[1] =j;
                }
                
                    
            }
        }
        return res;
        
    }
}

NOTE: TIME COMPLEXITY= O(N^2)
____________________________________________________________________________________________________________________________

OPTIMIZED APPROACH:

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int N = nums.length;
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < N; i++)
        {
            if(map.containsKey(target - nums[i]))
            {
                res[1] = i;
                res[0] = map.get(target - nums[i]);
                return res;
            }
            map.put(nums[i],i); // Add to hashtable--map
        }
           return res;
    }
}

NOTE: TC= O(N)

SOLUTION:
