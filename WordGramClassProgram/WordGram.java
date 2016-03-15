/**
 * build WordGram class with some methods similar to those of char class and String class
 * @DinhHuuNguyen
 * @01/27/2016
 */

import java.util.Arrays;
import java.io.*;

public class WordGram {
    private String[] myWords;
    private int myHash;

    public WordGram(String[] words, int start, int leadsize) {
        myWords = new String[leadsize];
        System.arraycopy(words, start, myWords, 0, leadsize);
    }

    public String wordAt(int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt " + index);
        }
        return myWords[index];
    }

    public int length(){
        return myWords.length;
    }

    public boolean equals(Object o) {
        WordGram other = (WordGram) o;
        if (this.length() != other.length()) {
            return false;
        }
        for (int i = 0; i < myWords.length; i++) {
            if (! myWords[i].equals(other.wordAt(i))) {
                return false;
            }
        }
        return true;
    }

    public WordGram shiftAdd(String word) {
        String[] temp = new String[myWords.length];
        System.arraycopy(myWords, 1, temp, 0, myWords.length - 1);
        temp[myWords.length - 1] = word;
        WordGram out = new WordGram(temp, 0, temp.length);
        return out;
    }
    
    public int hashCode() {
        return toString().hashCode();
    }
    
    public String toString() {
        String s = "";
        for (int i = 0; i < myWords.length; i++) {
            s = s + myWords[i] + " ";
        }
        return s.trim();
    }

}