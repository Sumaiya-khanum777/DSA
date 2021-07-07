/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 
Constraints:
0 <= nums.length <= 105
-109 <= nums[i] <= 109
*/

/*
1) We Create an empty hash table.
2) then Insert all array elements to hash table.
3) Do following for every element arr[i]
    3.1) Check if this element is the starting point of a subsequence.  To check this, we simply look for arr[i] - 1 in hash, 
    if not found, then this is the first element a subsequence.  
    
    3.2) If this element is a first element, then count number of elements in the consecutive starting with this element.
    i.e hashSet.contains(current + 1), then increment current value and curr_streak count by 1,
    --> If count is more than current res, then update res.
4)  Return length of the longest consecutive subsequence 
*/

PRACTICE LINK: https://leetcode.com/problems/longest-consecutive-sequence/

SOLUTION: 


_____________________________________________________OPTIMIZED APPROACH________________________________________________________

class Solution {
    public int longestConsecutive(int[] nums) {
        
        //Create hashset
        Set<Integer> hashSet = new HashSet<Integer>();
        
        //Insert all elements of nums into hashSet
        for(int i : nums)
        {
            hashSet.add(i);
        }
        
        int Long_streak = 0;  //sequence count
        
        for(int i : nums)
        {
            if(!hashSet.contains(i-1))   //if hashSet does not contain one step down value of i, i.e if this element is the starting point of a subsequence. 
                
            {
                int current = i;  //make i as current variable
                int cur_streak = 1;  // intiliaze cur_streak sequence count to 1
                
                while(hashSet.contains(current + 1))  // if hashSet contain one step right value of current, then 
                {
                    current += 1; //update current
                    cur_streak++; //increment current sequence count
                    
                }
                
                if(Long_streak < cur_streak)
                    Long_streak = cur_streak;
                
                else 
                     Long_streak = Long_streak;
                
               // Long_streak = Math.max(Long_streak, cur_streak);
            }
            
        }
        
        return Long_streak; //// Return length of the longest consecutive subsequence 
    }
}

Note: TC = O(3N)
