/**
 * add new words to generate new text by
 * randomly picking a follow from a list of follows of a lead of length 2 from a training text
 * not efficent since a list of follows is run/found anew for each (same) lead
 * @DinhHuuNguyen
 * @01/27/2016
 */

import java.util.*;

public class MarkovWordTwo implements IMarkovModel {
    private String[] trainingText;
    private Random myRandom;
    
    public MarkovWordTwo() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
		trainingText = text.split("\\s+");
	}

	private ArrayList<String> getFollows(String lead0, String lead1) {
	    Helpers hp = new Helpers();
	    int leadsize = 2;
        ArrayList<String> follows = new ArrayList<String>();
        int indexOfLead = hp.indexOfTwo(trainingText, lead0, lead1, 0);
        while (indexOfLead != -1 && indexOfLead + leadsize < trainingText.length) {
            follows.add(trainingText[indexOfLead + leadsize]);
            indexOfLead = hp.indexOfTwo(trainingText, lead0, lead1, indexOfLead + 1);
        }
        return follows;
    }
    
    public String getRandomText(int numWords){
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(trainingText.length - 2);
		String lead0 = trainingText[index];
		String lead1 = trainingText[index+1];
		sb.append(lead0);
		sb.append(" ");
		sb.append(lead1);
		sb.append(" ");
		for(int k = 0; k < numWords - 2; k++){
		    ArrayList<String> follows = getFollows(lead0, lead1);
		    if (follows.size() == 0) {
		        System.out.println(" no follow");
		        break;
		    }
			index = myRandom.nextInt(follows.size());
			String follow = follows.get(index);
			sb.append(follow);
			sb.append(" ");
			lead0 = lead1;
			lead1 = follow;
		}
		return sb.toString().trim();
	}
	
	public String toString() {
        return "MarkovWordTwo";
    }
	
}