/**
 * Write a description of MarkovWordNEfficient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class MarkovWordNEfficient implements IMarkovModel {
    private String[] trainingText;
    private Random myRandom;
    private int leadsize;
    private HashMap<WordGram, ArrayList<String>> leadsAndFollows;
    
    public MarkovWordNEfficient(int N) {
        myRandom = new Random();
        leadsize = N;
        leadsAndFollows = new HashMap<WordGram, ArrayList<String>>();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
        trainingText = text.split("\\s+");
    }
    
    private void buildMap() {
        leadsAndFollows.clear();
        for (int i = 0; i < trainingText.length - leadsize; i++) {
            WordGram lead = new WordGram(trainingText, i, leadsize);
            if (! leadsAndFollows.containsKey(lead)) {
                ArrayList<String> follows = new ArrayList<String>();
                follows.add(trainingText[i + leadsize]);
                leadsAndFollows.put(lead, follows);
            }
            else {
                leadsAndFollows.get(lead).add(trainingText[i + leadsize]);
            }
        }
        ArrayList<String> n = null;
        WordGram lastlead = new WordGram(trainingText, trainingText.length - leadsize, leadsize);
        leadsAndFollows.put(lastlead, n);
        /*
        for (int s : leadsAndFollows.keySet()) {
            System.out.println(s);
            System.out.println(leadsAndFollows.get(s));
        }
        */
        System.out.println("size " + leadsAndFollows.size());
        
        Helpers hp = new Helpers();
        HashMap<WordGram, Integer> map = hp.sizeOfEachImage(leadsAndFollows);
        int max = hp.maxValue(map);
        System.out.println("max value " + max);
        for (WordGram wg : map.keySet()) {
            if (map.get(wg) == max) {
                System.out.println(wg);
            }
        }
        
    }

    private ArrayList<String> getFollows(WordGram lead) {
        return leadsAndFollows.get(lead);
    }
    
    public String getRandomText(int numWords) {
        buildMap();
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
            if (follows == null) {
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
        return "MarkovWordNEfficient " + leadsize;
    }

}