/**
 * sort earthquakes by
 * compareTo method built into QuanEntry class
 * comparators that implement Comparator inferface
 * @DinhHuuNguyen 
 * @01/24/20
 */

import java.util.*;

public class EarthQuakeComparators {
    // uses compareTo in the QuakeEntry class
    public void sortByCompareTo(String filename, int entryposition) {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/" + filename + ".atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        Collections.sort(list);
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
        System.out.println("quake entry in position " + entryposition);
        System.out.println(list.get(entryposition));
    }    

    public void sortByMagnitude(String filename) {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/" + filename + ".atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        Collections.sort(list, new ComparatorByMag());
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

    }

    public void sortByDepth(String filename) {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/" + filename + ".atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        Collections.sort(list, new ComparatorByDepth());
        for(QuakeEntry qe : list) {
            System.out.println(qe);
        }
    }
    
    public void sortByDist(String filename, double lat, double lon) {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/" + filename + ".atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        Location current = new Location(lat, lon);
        Collections.sort(list, new ComparatorByDist(current));
        for(QuakeEntry qe : list) {
            System.out.println(qe);
        }
    }
    
    public void sortByMagAndDepth(String filename, int entryposition) {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/" + filename + ".atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        Collections.sort(list, new ComparatorByMagAndDepth());
        for(QuakeEntry qe : list) {
            System.out.println(qe);
        }
        System.out.println("quake entry in position " + entryposition);
        System.out.println(list.get(entryposition));
    }
    
    public void sortByTitleAndDepth(String filename, int entryposition) {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/" + filename + ".atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        Collections.sort(list, new ComparatorByTitleAndDepth());
        for(QuakeEntry qe : list) {
            System.out.println(qe);
        }
        System.out.println("quake entry in position " + entryposition);
        System.out.println(list.get(entryposition));
    }
    
    public void sortByLastWordAndMag(String filename, int entryposition) {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/" + filename + ".atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        Collections.sort(list, new ComparatorByLastWordAndMag());
        for(QuakeEntry qe : list) {
            System.out.println(qe);
        }
        System.out.println("quake entry in position " + entryposition);
        System.out.println(list.get(entryposition));
    }
    
}
