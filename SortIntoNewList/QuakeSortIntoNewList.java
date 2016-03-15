/**
 * use Sort into New List on earth quakes, with and without checking order before sorting
 * @DinhHuuNguyen
 * @01/22/2016
 */

import java.util.*;

public class QuakeSortIntoNewList {
    
    public ArrayList<QuakeEntry> sortByMag(ArrayList<QuakeEntry> in) {
        ArrayList<QuakeEntry> out = new ArrayList<QuakeEntry>();
        Helpers hp = new Helpers();
        while(! in.isEmpty()) {
            QuakeEntry entryOfSmallest = hp.getEntryOfSmallestMag(in); 
            in.remove(entryOfSmallest);
            out.add(entryOfSmallest);
        }
        return out;
    }
    
    public ArrayList<QuakeEntry> sortByMagWithCheck(ArrayList<QuakeEntry> in) {
        ArrayList<QuakeEntry> out = new ArrayList<QuakeEntry>();
        int passes = 0;
        Helpers hp = new Helpers();
        while(hp.checkInOrderByMag(in) == false) {
             QuakeEntry entryOfSmallest = hp.getEntryOfSmallestMag(in); 
             out.add(entryOfSmallest);
             in.remove(entryOfSmallest);
             passes += 1;
        }
        for (int i = 0; i < in.size(); i++) {
             out.add(in.get(i));
        }
        System.out.println("number of passes " + passes);
        return out;
    }

    public void testsortByMag(String filename) {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/" + filename + ".atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        list = sortByMag(list);
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
    }
    
    public void testsortByMagWithCheck(String filename) {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/" + filename + ".atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("number of entries " + list.size());
        list = sortByMagWithCheck(list);
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
    }
    
    public void createCSV(String filename) {
        EarthQuakeParser parser = new EarthQuakeParser();     
        String source = "data/" + filename + ".atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("number of entries " + list.size());
    }
    
    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude, Longitude, Magnitude, Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                              qe.getLocation().getLatitude(),
                              qe.getLocation().getLongitude(),
                              qe.getMagnitude(),
                              qe.getInfo());
        }
        
    }

}
