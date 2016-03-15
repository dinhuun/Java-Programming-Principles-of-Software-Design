/**
 * some helpers for WordGramClass Program
 * @DinhHuuNguyen
 * @01/26/2016
 */

import java.util.*;

public class Helpers {
	
	public int indexOf(String[] words, WordGram lead, int start) {
	    int leadsize = lead.length();
	    for (int i = start; i < words.length - leadsize; i ++) {
	        WordGram temp = new WordGram(words, i, leadsize);
	        if (temp.equals(lead)) {
	            return i;
	        }
	    }
	    return -1;
	}
	
	public void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println(); 
                psize = 0;
            } 
        } 
        System.out.println("\n----------------------------------");
    }
    
    public HashMap<WordGram, Integer> sizeOfEachImage (HashMap<WordGram, ArrayList<String>> map) {
        HashMap<WordGram, Integer> maptoimagesize = new HashMap<WordGram, Integer>();
        for (WordGram wg : map.keySet()) {
            if (map.get(wg) == null) {
                maptoimagesize.put(wg, 0);
            }
            else {
                maptoimagesize.put(wg, map.get(wg).size());
            }
        }
        return maptoimagesize;
    }
    
    public int maxValue (HashMap<WordGram, Integer> map) {
       int max = 0;
       for (WordGram wg : map.keySet()) {
           if (max < map.get(wg)) {
               max = map.get(wg);
           }
       }
       return max;
    }
    
    public WordGram inverseImage (HashMap<WordGram, Integer> map, int value) {
       WordGram preimage = null;
       for (WordGram wg : map.keySet()) {
           if (map.get(wg) == value) {
               preimage = wg;
           }
       }
       return preimage;
    }

}