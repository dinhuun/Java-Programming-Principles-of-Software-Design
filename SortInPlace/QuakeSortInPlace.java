/**
 * use Sort in Place on earth quakes, with and without checking order before sorting
 * @DinhHuuNguyen
 * @01/22/2016
 */

import java.util.*;

public class QuakeSortInPlace {
    
    public void sortByMag(ArrayList<QuakeEntry> quakes) {
        Helpers hp = new Helpers();
        for(int i = 0; i < quakes.size(); i++) {
            int minIndex = hp.getIndexOfSmallestMag(quakes, i);
            QuakeEntry temp = quakes.get(i);
            quakes.set(i, quakes.get(minIndex));
            quakes.set(minIndex, temp);
        }
    }
    
    public void sortByMagWithCheck(ArrayList<QuakeEntry> quakes) {
        int i = 0;
        int passes = 0;
        Helpers hp = new Helpers();
        while (hp.checkInOrderByMag(quakes) == false) {
            int minIndex = hp.getIndexOfSmallestMag(quakes, i);
            QuakeEntry temp = quakes.get(i);
            quakes.set(i, quakes.get(minIndex));
            quakes.set(minIndex, temp);
            i += 1;
            passes += 1;
        }
        System.out.println("number of passes " + passes);
    }
   
    public void sortByDepthNPasses(ArrayList<QuakeEntry> quakes, int N) {
        int passes = 0;
        Helpers hp = new Helpers();
        for(int i = 0; i < N; i++) {
            int maxIndex = hp.getIndexOfLargestDepth(quakes, i);
            QuakeEntry temp = quakes.get(i);
            quakes.set(i, quakes.get(maxIndex));
            quakes.set(maxIndex, temp);
            passes += 1;
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
        System.out.println("number of entries " + list.size());
        sortByMagWithCheck(list);
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
    }
    
    public void testsortByDepthNPasses(String filename, int N) {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/" + filename + ".atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        sortByDepthNPasses(list, N);
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
    }
    
}
