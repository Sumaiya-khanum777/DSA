/*Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] 
such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 

Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109*/

PRACTICE LINK: https://leetcode.com/problems/4sum/

//SOLUTION:_____________________________________________________________________________________________________________________

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
 
    int N = nums.length;
    if(nums == null || N < 4 )
        return result;
 
    Arrays.sort(nums);
 
    for(int i = 0; i < N-3; i++)
    
    {
        if(i != 0 && nums[i] == nums[i-1])
            continue;
        
        for(int j = i + 1; j < N - 2; j++)
        {
            if(j != i + 1 && nums[j] == nums[j - 1])
                continue;
            
            int front = j + 1;
            int back = nums.length - 1;
            while(front < back){
                if(nums[i] + nums[j] + nums[front] + nums[back] < target)
                {
                    front++;
                }
                
                else if(nums[i] + nums[j] + nums[front] + nums[back] > target)
                {
                    back--;
                }
                else
                {
                    List<Integer> qd = new ArrayList<Integer>();
                    qd.add(nums[i]);
                    qd.add(nums[j]);
                    qd.add(nums[front]);
                    qd.add(nums[back]);
                    result.add(qd);
 
                    front++;
                    back--;
 
                    while(front < back && nums[back] == nums[back + 1])
                    {
                        back--;
                    }
 
                    while(front < back && nums[front] == nums[front-1])
                    {
                        front++;
                    }
                }
 
 
            }
        }
    }
 
   
 return result;
}
}
