/**
 * 
 */
/**
 * @author TAO ZHANG
 *
 */
package com.leetcode.oj.WordLadder2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

// TODO: Auto-generated Javadoc
/**
 * The Class WordLadder2.
 */
public class WordLadder2{
	
	/**
	 * Instantiates a new word ladder2.
	 */
	public WordLadder2(){
		
	}
	  
  	/**
  	 * Find ladders.
  	 *
  	 * @param start the start
  	 * @param end the end
  	 * @param dict the dict
  	 * @return the array list
  	 */
  	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		    ArrayList<ArrayList<String>> allPaths = new ArrayList<ArrayList<String>>();
		    HashMap<String, String> parent = new HashMap<String, String>();
		   

		    parent.put(start, null);

		    ArrayList<String> frontier = new ArrayList<String>();//queue
		    frontier.add(start);
		    
		    
		    Object[] temp = new Object[dict.size()];        // convert HashSet to String[]
		    temp = dict.toArray();
		    String[] dic = new String[dict.size()];
		    for(int i=0;i<dict.size();i++){
		        dic[i] = temp[i].toString();
		    }
		    
		    ArrayList<String> allNext = new ArrayList<String>();
		    ArrayList<String> next = new ArrayList<String>();
		    ArrayList<String> path = new ArrayList<String>();
		   
		    while(!frontier.isEmpty()){
		    	allNext = new ArrayList<String>();
		        boolean found = false;// determine whether the shortest answers have been found.

		        for(String u: frontier){			//BFS
		            next = nextString(u, dic);    
		            for(String v: next){
		                if(!parent.containsKey(v)){
		                    parent.put(v, u);
		                    allNext.add(v);

		                    if(oneCharDiffered(v, end)){
		                        path = new ArrayList<String>();
		                        path.add(end);

		                        String current = v;
		                        while(parent.get(current) != null){
		                            path.add(current);
		                            current = parent.get(current);
		                        }
		                        path.add(current);
		                        allPaths.add(path);
		                        found = true;
		                    }

		                }   
		            }

		        }
		        frontier = allNext;
		        if(found == true) return allPaths; //if the shortest step answers have been found, return the paths.
		    }   
		    return null;
		}

		/**
		 * Next string.
		 *
		 * @param str the str
		 * @param dic the dic
		 * @return the array list
		 */
		public static ArrayList<String> nextString(String str, String[] dic){
		    ArrayList<String> next = new ArrayList<String>();
		    for(String d: dic){
		        if(oneCharDiffered(str, d)) next.add(d);
		    }
		    return next;
		}

		/**
		 * One char differed.
		 *
		 * @param str the str
		 * @param dic the dic
		 * @return true, if successful
		 */
		public static boolean oneCharDiffered(String str, String dic){
		    int length = str.length();
		    int count = 0;
		    for(int i = 0; i < length; i++){
		        if(str.charAt(i) != dic.charAt(i)) count++;
		    }
		    return count == 1;
		}
		
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		HashSet<String> dict  = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		ArrayList<ArrayList<String>> allPaths = new ArrayList<ArrayList<String>>();
		ArrayList<String> path = new ArrayList<String>();
		WordLadder2 wl2 = new WordLadder2();
		allPaths = wl2.findLadders("hit", "cog", dict);
		Iterator<ArrayList<String>> i = allPaths.iterator();
		while(i.hasNext()){
			path = i.next();
			Iterator<String> k = path.iterator();
			while(k.hasNext()){
				System.out.print(k.next()+" ");
			}
			System.out.println();
		}
		
	}
}