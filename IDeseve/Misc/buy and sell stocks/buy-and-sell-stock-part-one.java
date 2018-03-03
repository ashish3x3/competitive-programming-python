


Given an array representing prices of the stock on different days, find the maximum profit that can be earned by performing maximum of one transaction. A transaction consists of activity of buying and selling the stock on different or same days. 
For example in this array - {100, 80, 120, 130, 70, 60, 100, 125} the price of the stock on day-1 is 100, on day-2 is 80 and so on. The maximum profit that could be earned in this window is 65 (buy at 60 and sell at 125).

For price array - {100, 80, 70, 65, 60, 55, 50}, maximum profit that could be earned is 0.


If you observe above chart carefully, you should be able to notice that: for any given day, maximum profit obtainable is maximum of 1.Maximum profit obtained till previous day,  2.Stock price on that day - minimum stock price so far.

Therefore, to find out the maximum profit obtainable for a given window, all we need to is to keep track of minimum stock price seen so far (starting from day-1) and maximum profit obtained so far. Maximum profit obtained so far can be computed using above observation. Maximum profit obtained so far is initialized to 0 and minimum stock price seen so far is initialized to MAX_VALUE. 

             
package com.ideserve.virendra.questions;
 
public class BuyAndSellStocks 
{
    public static int maximumProfit(int[] stockPrices)
    {
        int profit = 0;
        int minimumPrice = Integer.MAX_VALUE;
        /* 
         * for any given day, maximum profit obtainable is - 
         * maximum of(maximum profit obtained till previous day, stock price on that day - minimum stock price so far)
         */
        for(int i = 0; i < stockPrices.length; i++)
        {
            profit = Math.max(profit, stockPrices[i] - minimumPrice);
            minimumPrice = Math.min(stockPrices[i], minimumPrice);
        }
         
        return profit;
    }
 
    public static void main(String args[])
    {
        int[] stockPrices = {100, 80, 120, 130, 70, 60, 100, 125};
         
        System.out.println("maximum profit that could be obtained is: " + maximumProfit(stockPrices));
    }
}
        