/**
 * an abstract class with some constructor and methods, to be extended by Markov Models with method getRandomText
 * @DinhHuuNguyen
 * @01/26/2016
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String trainingText;
    protected Random myRandom;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTrainingText(String text) {
        trainingText = text.trim();
    }
    
    protected ArrayList<String> getFollows(String lead) {
        int leadsize = lead.length();
        int indexOfLead = trainingText.indexOf(lead, 0);
        ArrayList<String> follows = new ArrayList<String>();
        while (indexOfLead != -1 && indexOfLead + leadsize < trainingText.length()) {
            follows.add(trainingText.substring(indexOfLead + leadsize, indexOfLead + leadsize + 1));
            indexOfLead = trainingText.indexOf(lead, indexOfLead + 1);
        }
        return follows;
    }
 
    abstract public String getRandomText(int numChars);

}
