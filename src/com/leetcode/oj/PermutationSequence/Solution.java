/**
 * 
 */
/**
 * @author TAO ZHANG
 *
 */
package com.leetcode.oj.PermutationSequence;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public String getPermutation(int n, int k) {
        String result = "";
        int[] nF = new int[n+1];
        if(n!=0){nF = this.getFactoria(n);}
        if(n>9 || n<1 || k<1 || k>nF[n]){return result;}
        
        ArrayList<Character> nNum = new ArrayList<Character>();
        for(int i=1;i<=n;i++){
            nNum.add((char)('0'+i));
        }
        
        int rem = 0;
        int div = k-1;
        int now = n-1;
        char[] temp = new char[n];
        int charPos = 0;
        while(nNum.size()!=0){
            rem = div%nF[n-charPos-1];              
            div = div/nF[n-charPos-1];
            temp[charPos] = nNum.get(div);
            nNum.remove(div);
            div = rem;
            charPos++;
        }
        return new String(temp);
    }
    public int[] getFactoria(int n){
        int[] nF = new int[n+1];
        nF[0]=1;
        for(int i=1;i<=n;i++){
            nF[i]=nF[i-1]*i;
        }
        return nF;
    }
    public int[] reverse(int[] num,int start,int end){
        Stack<Integer> s = new Stack<Integer>();
        int pos = start;
        while(pos<end){
            s.push(num[pos]);
            pos++;
        }
        for(int i = start;i<=end;i++){
            num[i] = s.pop();
        }
        return num;
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	s.getPermutation(4, 10);
    }
}