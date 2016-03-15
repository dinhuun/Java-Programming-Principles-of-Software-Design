/**
 * some helpers for MarkovRunnerWithInterface
 * @DinhHuuNguyen 
 * @01/25/2016
 */

import java.io.*;
import java.util.*;

public class Helpers {
    
    public void printOut(String s) {
		String[] words = s.split("\\s+");
		int linesize = 0;
		System.out.println("----------------------------------");
		for(int k = 0; k < words.length; k++){
			System.out.print(words[k]+ " ");
			linesize += words[k].length() + 1;
			if (linesize > 60) {
				System.out.println();
				linesize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	}
	
	public HashMap<String, Integer> sizeOfEachImage (HashMap<String, ArrayList<String>> map) {
        HashMap<String, Integer> maptoimagesize = new HashMap<String, Integer>();
        for (String s : map.keySet()) {
            if (map.get(s) == null) {
                maptoimagesize.put(s, 0);
            }
            else {
                maptoimagesize.put(s, map.get(s).size());
            }
        }
        return maptoimagesize;
    }
    
    public int maxValue (HashMap<String, Integer> map) {
       int max = 0;
       for (String s : map.keySet()) {
           if (max < map.get(s)) {
               max = map.get(s);
           }
       }
       return max;
    }
    
    public String inverseImage (HashMap<String, Integer> map, int value) {
       String preimage = new String();
       for (String s : map.keySet()) {
           if (map.get(s) == value) {
               preimage = s;
           }
       }
       return preimage;
    }

}