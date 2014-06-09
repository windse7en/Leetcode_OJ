/**
 * 
 */
/**
 * @author TAO ZHANG
 *
 */
package com.leetcode.oj.findkth;
public class FindKth {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] A = {100002};
		int[] B = {100000};
		double Rst=0.0;
		if(A.length==0)
		{
			System.out.println("0 SIZE DETACTED");
			if(B.length<=1)
			{Rst=B[0];}
			else
			{
				if(B.length%2==0)
				{Rst=(B[(B.length/2)-1]+B[(B.length/2)])/2.0;}
				else
				{Rst=B[(B.length/2)];}
			}
		}
		else if(B.length==0)
		{
			System.out.println("0 SIZE DETACTED");
			if(A.length<=1)
    		{Rst=A[0];}
			else
			{
				if(A.length%2==0)
				{Rst=(A[(A.length/2)-1]+A[(A.length/2)])/2.0;}
				else
				{Rst=A[(A.length/2)];}
			}
		}
		else
		{
			if (A.length > B.length|| ((A.length==B.length) && A[0]>B[B.length-1])) 
			{Rst=MedianofTwoSortedArraysOpt(B,A);}
			else
			{Rst=MedianofTwoSortedArraysOpt(A,B);}	
		}
		System.out.println(Rst);
	}

	
	public static double MedianofTwoSortedArraysOpt(int[] A, int[] B)
    {
        int t = A.length + B.length;
        if (t % 2 == 0)
        {
        	double left=0.0,right=0.0;
        	left=(double)FindKtht(A, 0, A.length, B, 0, B.length, t / 2);
            right=(double)FindKtht(A, 0, A.length, B, 0, B.length, (t / 2) +1);
            System.out.println(left+"||"+right);
            return ((left+right)/2.0);
        }

        return FindKtht(A, 0, A.length, B, 0, B.length, t / 2 + 1);
    }

    public static int FindKtht(int[] A, int aoffset, int m, int[] B, int boffset, int n, int k)
    {
        //Keep the A is the shorter array.
        if (m > n) FindKtht(B, boffset, n, A, aoffset, m, k);

        if (m == 0) return B[k - 1];
        if (k == 1) 
        	{
        		if(boffset==B.length)
        		{boffset--;}
        		return Math.min(A[aoffset], B[boffset]);
        	}

        //set pa and pb pointer
        int pa = Math.min(k / 2, m);
        int pb = k - pa;

        System.out.println(A[aoffset + pa - 1]);
        System.out.println(B[boffset + pb - 1]);
        
        if (A[aoffset + pa - 1] < B[boffset + pb - 1]) 
        	return FindKtht(A, aoffset + pa, m - pa, B, boffset, n, k - pa);

        return FindKtht(A, aoffset, m, B, boffset + pb, n - pb, k - pb);
    }
}
