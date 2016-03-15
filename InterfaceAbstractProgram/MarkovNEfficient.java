/**
 * add new characters to generate new text by
 * storing all leads of length N and their follows from a training text in a HashMap<String, ArrayList<String>>
 * for each lead randomly picking a follow from its list of follows
 * @DinhHuuNguyen
 * @01/25/2016
 */

import java.util.*;

public class MarkovNEfficient extends AbstractMarkovModel {
    private int leadsize;
    private HashMap<String, ArrayList<String>> leadsAndFollows;
    
    public MarkovNEfficient(int N) {
        leadsize = N;
        leadsAndFollows = new HashMap<String, ArrayList<String>>();
    }
    
    private void buildMap () {
        leadsAndFollows.clear();
        for (int i = 0; i < trainingText.length() - leadsize; i++) {
            String lead = trainingText.substring(i, i + leadsize);
            if (! leadsAndFollows.containsKey(lead)) {
                ArrayList<String> follows = new ArrayList<String>();
                follows.add(trainingText.substring(i + leadsize, i + leadsize + 1));
                leadsAndFollows.put(lead, follows);
            }
            else {
                leadsAndFollows.get(lead).add(trainingText.substring(i + leadsize, i + leadsize + 1));
            }
        }
        ArrayList<String> n = null;
        leadsAndFollows.put(trainingText.substring(trainingText.length() - leadsize), n);
        /*
        for (String s : leadsAndFollows.keySet()) {
            System.out.println(s);
            System.out.println(leadsAndFollows.get(s));
        }
        */
        System.out.println("size " + leadsAndFollows.size());
        Helpers hp = new Helpers();
        HashMap<String, Integer> map = hp.sizeOfEachImage(leadsAndFollows);
        int max = hp.maxValue(map);
        System.out.println("max value " + max);
        for (String s : map.keySet()) {
            if (map.get(s) == max) {
                System.out.println("lead " + s);
            }
        }
    }
    
    public ArrayList<String> getFollows (String lead) {
        return leadsAndFollows.get(lead);
    }
    
    public String getRandomText (int numChars) {
        buildMap();
        if (trainingText == null) {
            return "no training text";
        }
        StringBuilder sb = new StringBuilder();
        int indexStart = myRandom.nextInt(trainingText.length() - leadsize);
        String lead = trainingText.substring(indexStart, indexStart + leadsize);
        sb.append(lead);
        int indexOfFollow = 0;
        for(int k = 0; k < numChars - leadsize; k++) {
            ArrayList<String> follows = getFollows(lead);
            if (follows == null) {
                System.out.println("no follow");
                break;
            }
            indexOfFollow = myRandom.nextInt(follows.size());
            String follow = follows.get(indexOfFollow);
            sb.append(follow);
            lead = lead.substring(1) + follow;
        }
        return sb.toString();
    }
    
    public String toString () {
        return "MarkovNEfficient " + leadsize;
    }
    
}