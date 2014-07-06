/**
 * 
 */
/**
 * @author TAO ZHANG
 *
 */
package com.leetcode.oj.Test;
// TODO: Auto-generated Javadoc

/**
 * The Class Test.
 */
public class Test{
	
	/**
	 * Instantiates a new test.
	 */
	public Test(){
	}
	
	/**
	 * Checks if is palindrome.
	 *
	 * @param x the x
	 * @return true, if is palindrome
	 */
	public boolean isPalindrome(int x) {
        int intReverse = reverse(x);  //Reverse an integer;
        if(intReverse==x){
            if(x<0)
            return false;
            return true;
        }
        return false;
    }
    
    /**
     * Reverse.
     *
     * @param x the x
     * @return the int
     */
    public int reverse(int x){	// x may negative
        int tempx = Math.abs(x);
        int revx = 0;
        while(tempx>0){
        	revx = revx*10 + tempx%10;
        	tempx/=10;
        }
        if(x<0){revx = -revx;}
        return revx;
    }
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		Test t = new Test();
		System.out.println(t.isPalindrome(101));
		String s = "asdfasdf";
		System.out.println(s.compareTo("asdfascf"));
		
	}
}