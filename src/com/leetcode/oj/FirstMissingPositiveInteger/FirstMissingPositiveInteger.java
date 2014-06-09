/**
 * 
 */
/**
 * @author TAO ZHANG
 *
 */
package com.leetcode.oj.FirstMissingPositiveInteger;

public class FirstMissingPositiveInteger{
    public int firstMissingPositive(int[] A) {
    int length = A.length, curr = 0;
    int temp=0;
        if(length == 0 ){return 1;}
        while(curr<length){
            if(A[curr]!=(curr+1) && A[curr]<=length && A[curr]>0 && A[A[curr]-1]!=A[curr]){         //if there are duplicate elements swap condition
                temp = A[curr];         //swap(A[curr],A[A[curr]-1])
                A[curr] = A[A[curr]-1];
                A[A[curr]-1] = temp;
            }else{
                curr++;         //go to next integer
            }
        }
        for (int j=0; j<length; j++){
            if (A[j]!=j+1) return j+1;
        }
        return length+1;
    }
	public static void main(String[] args){
		FirstMissingPositiveInteger fmpi = new FirstMissingPositiveInteger();
		int[] A = {2,1};
		System.out.println(fmpi.firstMissingPositive(A));
	} 
}