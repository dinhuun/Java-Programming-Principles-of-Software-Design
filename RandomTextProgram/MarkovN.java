/**
 * add new characters to generate new text by
 * randomly picking a follow from a list of follows of a lead of length N from a training text
 * @DinhHuuNguyen
 * @01/25/2016
 */

import java.util.*;

public class MarkovN {
    private String trainingText;
    private Random myRandom;
    private int leadsize;
    
    public MarkovN(int N) {
        myRandom = new Random();
        leadsize = N;
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTrainingText(String s) {
        trainingText = s.trim();
    }
    
    public ArrayList<String> getFollows(String lead) {
        int indexOfLead = trainingText.indexOf(lead, 0);
        ArrayList<String> follows = new ArrayList<String>();
        while (indexOfLead != -1 && indexOfLead + leadsize < trainingText.length()) {
            follows.add(trainingText.substring(indexOfLead + leadsize, indexOfLead + leadsize + 1));
            indexOfLead = trainingText.indexOf(lead, indexOfLead + 1);
        }
        return follows;
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
    
}