/**
 * add new words to generate new text by
 * randomly picking a follow from a list of follows of a lead of length 1 from a training text
 * not efficent since a list of follows is run/found anew for each (same) lead
 * @DinhHuuNguyen
 * @01/27/2016
 */

import java.util.*;

public class MarkovWordOne implements IMarkovModel {
    private String[] trainingText;
    private Random myRandom;
    
    public MarkovWordOne() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
		trainingText = text.split("\\s+");
	}

	private ArrayList<String> getFollows(String lead) {
	    Helpers hp = new Helpers();
	    int leadsize = 1;
        ArrayList<String> follows = new ArrayList<String>();
        int indexOfLead = hp.indexOfOne(trainingText, lead, 0);
        while (indexOfLead != -1 && indexOfLead + leadsize < trainingText.length) {
            follows.add(trainingText[indexOfLead + leadsize]);
            indexOfLead = hp.indexOfOne(trainingText, lead, indexOfLead + 1);
        }
        return follows;
    }
    
    public String getRandomText(int numWords){
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(trainingText.length - 1);
		String lead = trainingText[index];
		sb.append(lead);
		sb.append(" ");
		for(int k = 0; k < numWords - 1; k++){
		    ArrayList<String> follows = getFollows(lead);
		    if (follows.size() == 0) {
		        System.out.println(" no follow");
		        break;
		    }
			index = myRandom.nextInt(follows.size());
			String follow = follows.get(index);
			sb.append(follow);
			sb.append(" ");
			lead = follow;
		}
		return sb.toString().trim();
	}
	
	public String toString() {
        return "MarkovWordOne";
    }
    
}
