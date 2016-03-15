/**
 * test WordGram class
 * @DinhHuuNguyen
 * @01/27/2016
 */

import java.util.*;

public class WordGramTester {
	public void testWordGram(){
		String text = "this is a test this is a test this is a test of words";
		String[] words = text.split("\\s+");
		int leadsize = 4;
		for(int index = 0; index <= words.length - leadsize; index += 1) {
			WordGram wg = new WordGram(words, index, leadsize);
			System.out.println(index + "\t" + wg.length() + "\t" + wg.hashCode() + "\t" + wg + "\t" + wg.shiftAdd("shifted"));
		}
	}
	
	public void testWordGramEquals(){
		String text = "this is a test this is a test this is a test of words";
		String[] words = text.split("\\s+");
		ArrayList<WordGram> list = new ArrayList<WordGram>();
		int leadsize = 4;
		for(int index = 0; index <= words.length - leadsize; index += 1) {
			WordGram wg = new WordGram(words, index, leadsize);
			list.add(wg);
		}
		WordGram first = list.get(0);
		System.out.println("\"" + first + "\" is found at");
		for(int k = 0; k < list.size(); k++){
			//if (first == list.get(k)) {
			  if (first.equals(list.get(k))) {
				System.out.println(k + " " + list.get(k));
			}
		}
	}
	
}
