/**
 * 
 */
/** Concern the same point or not.
 * @author TAO ZHANG
 *
 */
package com.leetcode.oj.MaxPointsOnALine;
// TODO: Auto-generated Javadoc

/**
 * The Class MaxPointsOnALine.
 */
public class MaxPointsOnALine{
	
	/**
	 * Instantiates a new max points on a line.
	 */
	public MaxPointsOnALine(){
		
	}
	
	/**
	 * Max points.
	 *
	 * @param points the points
	 * @return the int
	 */
	public int maxPoints(Point[] points){
        if(points.length<=2){return points.length;}
        int nump = points.length; //number of points
        int max=1,j=0,k=0,num=2,changeE=0, set1=2;
        boolean sameX=false;
        double cline = 0.0,test=0.0;
        for(int i=0;i<nump;i++){    //the line start point
            for(j=i+1;j<nump;j++){  //the line end point
            	if(points[i].x == points[j].x && points[i].y == points[j].y){num=set1++; max = Math.max(max,num); continue;}
            	if((points[i].x-points[j].x) != 0){
            		cline = (points[i].y-points[j].y)/(points[i].x-points[j].x);        // calculate the cline angle
            	}else{sameX = true;}
                for(k=j+1;k<nump;k++){  //check the other points if they are in the line
                	if((points[i].x-points[k].x) != 0){
                		test = (points[i].y-points[k].y)/(points[i].x-points[k].x);
                	}else{if(sameX){num++;continue;}}	// if the same verticcal line
                    if(test == cline){
                        num++;
                        continue;
                    }
                    if(points[i].x == points[k].x && points[i].y == points[k].y){num++;}	//concern the same point.
                } 
                if(num>max){max = num;}
                sameX = false;
                num=set1;
            }
            set1=2;
        }
        return max;
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		Point[] points = new Point[4];
		points[0] = new Point(1,1);
		points[1] = new Point(1,1);
		points[2] = new Point(2,2);
		points[3] = new Point(2,2);
		MaxPointsOnALine mpoal = new MaxPointsOnALine();
		System.out.println(mpoal.maxPoints(points));
	}
}