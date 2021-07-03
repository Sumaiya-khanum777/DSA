/* Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].


Example 1:
Input: nums = [1,3,2,3,1]
Output: 2


Example 2:
Input: nums = [2,4,3,5,1]
Output: 3
 
 
Constraints:
1 <= nums.length <= 5 * 104
-231 <= nums[i] <= 231 - 1
*/

//Practice Link: https://leetcode.com/problems/reverse-pairs/

//_____________________________________________________________________________________________________________________________

SOLUTION:
class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) 
            return 0;
        
        int n = nums.length;
        int[] res = new int[1];
        mergeSort(nums, 0, n - 1, res);
        return res[0];
    }

    public void mergeSort(int[] nums, int strt, int end, int[] res) {
        if (strt >= end) {
            return;
        }

        int mid = strt + (end - strt) / 2;
        mergeSort(nums, strt, mid, res);
        mergeSort(nums, mid + 1, end, res);

        int count = 0;
        int lft = strt, right = mid + 1;

        while (lft <= mid) {
            if (right <= end && (nums[lft] > 2 * (long)nums[right])) {
                count++;
                right++;
            }
            else {
                res[0] += count;
                lft++;
            }
        }
        merge(nums, strt, mid, end);
    }

    public void merge(int[] nums, int strt, int mid, int end) {
        int[] temp = new int[end - strt + 1];

        int i = strt, j = mid + 1, k = 0;

        while (i <= mid && j <= end) 
        {
            if (nums[i] < nums[j]) 
            {
                temp[k++] = nums[i++];
            }
            else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) 
        {
            temp[k++] = nums[i++];
        }

        while (j <= end) 
        {
            temp[k++] = nums[j++];
        }

        for (int m = strt; m <= end; m++) 
        {
            nums[m] = temp[m - strt];
        }
        
    }
}
