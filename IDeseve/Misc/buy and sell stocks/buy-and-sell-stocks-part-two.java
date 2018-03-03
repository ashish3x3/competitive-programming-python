
Buy and sell stocks | Part 2
http://www.ideserve.co.in/learn/buy-and-sell-stocks-part-two
             
package com.ideserve.virendra.questions;
 
public class BuyAndSell {
     
    public static int maximumProfit2(int[] stockPrices) {
        int totalProfit = 0;
        for(int i=1; i<stockPrices.length; i++){
            int  currentProfit = stockPrices[i]-stockPrices[i-1];
            if(currentProfit > 0){
                totalProfit += currentProfit;
            }
        }
        return totalProfit;
    }
     
    public static void main(String args[])
    {
        int[] p = {100, 80, 120, 130, 70, 60, 100, 125};
        System.out.println(maximumProfit2(p));
         
         
    }
}
        