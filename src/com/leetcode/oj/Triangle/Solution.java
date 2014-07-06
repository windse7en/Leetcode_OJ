/**
 * 
 */
/**
 * @author TAO ZHANG
 *
 */
package com.leetcode.oj.Triangle;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Solution.
 */
public class Solution {
    
    /**
     * Minimum total.
     *
     * @param triangle the triangle
     * @return the int
     */
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
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args){

    }
}