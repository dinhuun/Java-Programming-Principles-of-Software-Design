/**
 * some helpers for WordNGram Program
 * @DinhHuuNguyen 
 * @01/25/2016
 */

public class Helpers {
    
    public int indexOfOne(String[] words, String lead, int start) {
	    for (int i = start; i < words.length; i++) {
	        if (words[i].equals(lead)) {
	            return i;
	        }
	    }
	    return -1;
	}
	
	public int indexOfTwo(String[] words, String lead0, String lead1, int start) {
	    for (int i = start; i < words.length - 1; i ++) {
	        if (words[i].equals(lead0) && words[i+1].equals(lead1)) {
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

}
