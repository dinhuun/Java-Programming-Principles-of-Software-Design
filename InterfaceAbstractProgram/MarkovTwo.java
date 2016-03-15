/**
 * add new characters to generate new text by
 * randomly picking a follow from a list of follows of a lead of length 2 from a training text
 * not efficent since a list of follows is run/found anew for each (same) lead
 * @DinhHuuNguyen
 * @01/25/2016
 */

import java.util.*;

public class MarkovTwo extends AbstractMarkovModel {
    
    public String getRandomText(int numChars) {
        if (trainingText == null) {
            return "no training text";
        }
        StringBuilder sb = new StringBuilder();
        int indexStart = myRandom.nextInt(trainingText.length() - 2);
        String lead = trainingText.substring(indexStart, indexStart + 2);
        sb.append(lead);
        for(int k = 0; k < numChars - 2; k++) {
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
	    return "MarkovModel 2";
	}
    
}