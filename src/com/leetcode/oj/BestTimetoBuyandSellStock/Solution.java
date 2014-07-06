/**
 * 
 */
/**
 * @author TAO ZHANG
 *
 */
package com.leetcode.oj.BestTimetoBuyandSellStock;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class Solution.
 */
public class Solution {
    // assume that all the prices are positive integer;
    /**
     * Max profit.
     *
     * @param prices the prices
     * @return the int
     */
    public int maxProfit(int[] prices) {
    	
    	/*
    	HashMap<Integer, String> hmMap = new HashMap<Integer,String>();
    	hmMap.put(1,"asdf");
    	hmMap.remove(1);
    	Set<Entry<Integer,String>> s = hmMap.entrySet();
    	Iterator i = s.iterator();
    	while(i.hasNext()){
    		@SuppressWarnings("unchecked")
			Entry<Integer,String> temp = (Entry<Integer,String>)i.next();
    		i.remove();
    	}*/
        if(prices == null || prices.length == 1  ){return 0;}
        
        int[] maxValues = this.setMax(prices);
        int max = 0;
        int temp = 0;
        
        
        for(int i=0;i<prices.length;i++){           //find the maximum 
            if(maxValues[i]!=0 && maxValues[i]!=-1){
                temp = prices[maxValues[i]]-prices[i];
            }
            if(temp>max){
                max = temp;
            }
        }
        return max;
        
    }
    
    /**
     * Sets the max.
     *
     * @param prices the prices
     * @return the int[]
     */
    public int[] setMax(int[] prices){
        if(prices == null || prices.length==1){return prices;}
        int[] maxValues = new int[prices.length];
        for(int i=0;i<prices.length-1;i++){     // the last price can't be the price to buy
            int max = 0;
            int maxPos = 0;
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]>max){
                    max = prices[j];
                    maxPos = j;
                }
            }
            //max = max(i,prices.length);
            //maxPos = j;
            for(int k=i;k<maxPos;k++){          //so at least 2 elements
                maxValues[k]=maxPos;
            }
            if(prices[i]>=max){
                maxValues[i]= -1;
            }
            maxValues[maxPos] = -1;
            if(maxPos!=0){			//as 0 is the initialization value and can't be sell price
            	i=maxPos;			//pay attention to initialization value and for loop will +1, next time;
            }
        }
        return maxValues;
    }
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] prices = {5,2,3,2,6,6,2,9,1,0,7,4,5,0};
    	System.out.println(s.maxProfit(prices));

    }
}