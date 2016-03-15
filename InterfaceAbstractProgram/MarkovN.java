/**
 * add new characters to generate new text by
 * randomly picking a follow from a list of follows of a lead of length N from a training text
 * not efficent since a list of follows is run/found anew for each (same) lead
 * @DinhHuuNguyen
 * @01/25/2016
 */

import java.util.*;

public class MarkovN extends AbstractMarkovModel {
    private int leadsize;
    
    public MarkovN (int N) {
        leadsize = N;
    }
    
    public String getRandomText(int numChars) {
        if (trainingText == null) {
            return "no training text";
        }
        StringBuilder sb = new StringBuilder();
        int indexStart = myRandom.nextInt(trainingText.length() - leadsize);
        String lead = trainingText.substring(indexStart, indexStart + leadsize);
        sb.append(lead);
        for(int k = 0; k < numChars - leadsize; k++) {
            ArrayList<String> follows = getFollows(lead);
            if (follows.size() == 0) {
                System.out.println(" no follow");
                break;
            }
            int indexOfFollow = myRandom.nextInt(follows.size());
            String follow = follows.get(indexOfFollow);
            sb.append(follow);
            lead = lead.substring(1) + follow;
        }
        return sb.toString();
    }
    
    public String toString() {
	    return "MarkovN " + leadsize;
	}
    
}