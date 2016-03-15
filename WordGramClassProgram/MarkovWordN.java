
/**
 * Write a description of MarkovWordN here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class MarkovWordN implements IMarkovModel {
    private String[] trainingText;
    private Random myRandom;
    private int leadsize;
    
    public MarkovWordN(int N) {
        myRandom = new Random();
        leadsize = N;
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
        trainingText = text.split("\\s+");
    }

    private ArrayList<String> getFollows(WordGram lead) {
        Helpers hp = new Helpers();
        ArrayList<String> follows = new ArrayList<String>();
        int indexOfLead = hp.indexOf(trainingText, lead, 0);
        while (indexOfLead != -1 && indexOfLead + leadsize < trainingText.length) {
            follows.add(trainingText[indexOfLead + leadsize]);
            indexOfLead = hp.indexOf(trainingText, lead, indexOfLead + leadsize);
        }
        return follows;
    }
    
    public String getRandomText(int numWords) {
        if (trainingText == null) {
            return "no training text";
        }
        StringBuilder sb = new StringBuilder();
        int indexStart = myRandom.nextInt(trainingText.length - leadsize);
        WordGram lead = new WordGram(trainingText, indexStart, leadsize);
        sb.append(lead);
        int indexOfFollow = 0;
        for(int k = 0; k < numWords - leadsize; k++) {
            ArrayList<String> follows = getFollows(lead);
            if (follows.size() == 0) {
                break;
            }
            indexOfFollow = myRandom.nextInt(follows.size());
            String follow = follows.get(indexOfFollow);
            sb.append(" " + follow);
            lead = lead.shiftAdd(follow);
        }
        return sb.toString().trim();
    }
    
    public String toString() {
        return "MarkovWordN " + leadsize;
    }

}