/**
 * 
 */
/**
 * @author TAO ZHANG
 *
 */
package com.leetcode.oj.Triangle;

import java.util.ArrayList;

public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle == null) {return 0;}
        int size = triangle.size();
        
        ArrayList<Integer> result = triangle.get(size-1);
        for(int i = size-2;i>=0;i--){
            for(int j= 0;j<=i;j++){
                result.set(j,Math.min(triangle.get(i).get(j)+triangle.get(i+1).get(j), triangle.get(i).get(j)+triangle.get(i+1).get(j+1)));
            }
        }
        
        return result.get(0);
    }
    public static void main(String[] args){

    }
}