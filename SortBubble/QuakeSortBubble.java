/**
 * use Sort Bubble on earth quakes, with and without checking order before sorting
 * @DinhHuuNguyen
 * @01/22/2016
 */

import java.util.*;

public class QuakeSortBubble {
    
    public void sortByMag(ArrayList<QuakeEntry> quakes) {
        Helpers hp = new Helpers();
        for(int numSorted = 0; numSorted < quakes.size() - 1; numSorted++) {
            hp.bubbleSortByMag(quakes, numSorted);
        }
    }
    
    public void sortByMagWithCheck(ArrayList<QuakeEntry> quakes) {
        int passes = 0;
        Helpers hp = new Helpers();
        for(int numSorted = 0; numSorted < quakes.size() - 1; numSorted++) {
            if (hp.checkInOrderByMag(quakes) == false) {
                hp.bubbleSortByMag(quakes, numSorted);
                passes += 1;
            }
            else {
                break;
            }
        }
        System.out.println("number of passes " + passes);
    }

    public void testsortByMag(String filename) {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/" + filename + ".atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        sortByMag(list);
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
    }
    
    public void testsortByMagWithCheck(String filename) {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/" + filename + ".atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println(list.size());
        sortByMagWithCheck(list);
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
    }
    
}