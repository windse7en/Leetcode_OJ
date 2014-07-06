package com.leetcode.oj.plus_one;

import java.util.Arrays;

// TODO: Auto-generated Javadoc
/**
 * The Class PlusOne.
 */
public class PlusOne {
	
	/**
	 * Instantiates a new plus one.
	 *
	 * @param digits the digits
	 */
	public PlusOne(int[] digits){
		System.out.println(Arrays.toString(this.PlusOneReturn(digits)));
	}
	
	/**
	 * Plus one return.
	 *
	 * @param digits the digits
	 * @return the int[]
	 */
	public int[] PlusOneReturn(int[] digits){
		int j = digits.length;
		int sum = 1;
		int end = 0;
		while(sum==1 && end<digits.length){
			digits[j-1] = digits[j-1] + 1;
			sum = digits[j-1]/10;
			digits[j-1]%=10;
			j--;
			end++;
		}
		if(end==digits.length && sum==1){
			int[] results = new int[end+1];
			results[0]=1;
			for(int i=1;i<end+1;i++){
				results[i] = digits[i-1];
			}
			return results;
		}else{
			return digits;
		}
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		int[] number = {9,8,7,6,5,4,3,2,1,0}; 
		PlusOne one = new PlusOne(number);
	}

}
