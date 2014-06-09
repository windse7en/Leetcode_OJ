/**
 * @author TAO ZHANG
 *
 */
package com.leetcode.oj.ValidParentheses;

import java.util.Stack;

public class ValidParentheses{
	public ValidParentheses(String parent){
		System.out.println(this.Test(parent));
	}
	public boolean Test(String parent){
		Stack temp = new Stack();
		char[] tempChar = parent.toCharArray();
		int length = tempChar.length;
		for(int i = 0;i<length;i++){
			switch(tempChar[i]){
				case '(':
					temp.push('(');
					break;
				case '[':
					temp.push('[');
					break;
				case '{':
					temp.push('{');
					break;
				case ')':
					if(!temp.isEmpty() && (char)temp.peek()=='('){ temp.pop();break;}else{ return false;}
				case ']':
					if(!temp.isEmpty() && (char)temp.peek()=='['){ temp.pop();break;}else{ return false;}
				case '}':
					if(!temp.isEmpty() && (char)temp.peek()=='{'){ temp.pop();break;}else{ return false;}
			}
			
			
		}
		if(temp.isEmpty()){ 
			return true;
		}else{return false;}
	}
	public static void main(String[] args){
		ValidParentheses temp = new ValidParentheses("qwer{(asdf[asdf]asdf[]{})})");
	}
} 