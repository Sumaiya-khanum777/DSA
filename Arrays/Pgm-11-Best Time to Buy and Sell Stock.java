/* You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day
in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.


Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.*/

//SOLUTION__________________________________________________________________________________________________________
class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length, i=0;
        int min_price = Integer.MAX_VALUE;
        int max_profit = 0;
        
        while(i<n)              //___To Travescomplete prices of stock
        {
            if(prices[i] < min_price)
                min_price = prices[i];     // update min_price  if value in 'prices' array is < min_price
            
            else if(prices[i]-min_price > max_profit)
            {
                max_profit = prices[i]-min_price;   // update max_profit
            }
            
            i++;
        }
        
    return  max_profit;
    }
}


/*
Input
[7,1,5,3,6,4]
Output
5
 */
