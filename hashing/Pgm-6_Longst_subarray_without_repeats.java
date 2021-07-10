/* Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/

ALgorithm used for generating subarray: // Kadanne Algorithm 

Practice link: https://leetcode.com/problems/longest-substring-without-repeating-characters/

SOLUTION:

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        //create hash table char type and integers(for index) 
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
        
        int L = 0, R ; // L--> lft pointer , R--> right pointer
        int size = s.length();   //length of string
        int length = 0;
        
        
        for(R = 0; R < size; R++)  // iterate R pointer untill it crosses traversal boundary i.e. till R >= size
        {
            if( hash.containsKey(s.charAt(R)))   //char at R contains in hash
                
            {
                L = Math.max(hash.get(s.charAt(R)) + 1, L);  //only update L
            }
            
            hash.put(s.charAt(R), R);   //current char to hash
            length = Math.max(length, R - L + 1);   //compute length
           
        }
        
        return length;
        
    }
}
