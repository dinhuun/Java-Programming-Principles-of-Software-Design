/**
 * add new characters to generate new text by
 * randomly picking a character from a training text
 * @DinhHuuNguyen
 * @01/25/2016
 */

import java.util.*;

public class MarkovZero extends AbstractMarkovModel {
	
	public String getRandomText(int numChars) {
		if (trainingText == null) {
			return "no training text";
		}
		StringBuilder sb = new StringBuilder();
		for(int k = 0; k < numChars; k++) {
			int index = myRandom.nextInt(trainingText.length());
			sb.append(trainingText.charAt(index));
		}
		return sb.toString();
	}
	
	public String toString() {
	    return "MarkovModel 0";
	}
	
}
