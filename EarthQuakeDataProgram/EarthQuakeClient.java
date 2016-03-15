/**
 * a class that
 * dump quake data in CSV format
 * creates a CSV file of quake data
 * filters quakes by magnitude
 * filters quakes by distance to certain location
 * filters quakes by depth
 * filters quakes by phrase contained in title
 */

import java.util.*;
import edu.duke.*;

public class EarthQuakeClient {
    
    public void dumpCSV(ArrayList<QuakeEntry> list) {
		System.out.println("Latitude,Longitude,Magnitude,Info");
		for(QuakeEntry qe : list){
			System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
			                  qe.getLocation().getLatitude(),
			                  qe.getLocation().getLongitude(),
			                  qe.getMagnitude(),
			                  qe.getInfo());
	    }
		
	}

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        dumpCSV(list);
        System.out.println("number of quakes read: " + list.size());
    }
    
    public ArrayList<QuakeEntry> filterByMag(ArrayList<QuakeEntry> quakeData, double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        //TODO
        for (QuakeEntry qe : quakeData) {
            if (qe.getMagnitude() > magMin) {
                answer.add(qe);
            }
        }
        return answer;
    }
    
    public ArrayList<QuakeEntry> filterByDist(ArrayList<QuakeEntry> quakeData, double distMax, Location from) {      
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for (QuakeEntry qe : quakeData) {
            if (qe.getLocation().distanceTo(from) < distMax) {
                answer.add(qe);
            }
        }
        return answer;
    }
    
    public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData, double depthlow, double depthhigh) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for (QuakeEntry qe : quakeData) {
            if (depthlow < qe.getDepth() && qe.getDepth() < depthhigh) {
                answer.add(qe);
            }
        }
        return answer;
    }
    
    public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData, String where, String phrase) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for (QuakeEntry qe : quakeData) {
            if (where.equals("start") && qe.getInfo().startsWith(phrase)) {
                answer.add(qe);
            }
            if (where.equals("end") && qe.getInfo().endsWith(phrase)) {
                answer.add(qe);
            }
            if (where.equals("any") && qe.getInfo().contains(phrase)) {
                answer.add(qe);
            }
        }
        return answer;
    }
            
    public void testfilterByMag(double magMin) {
	    EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        ArrayList<QuakeEntry> listBig = filterByMag(list, magMin);
        for (QuakeEntry qe : listBig) {
           System.out.println(qe); 
        }
        System.out.println("matched " + listBig.size());
	}
	
	public void testfilterByDist() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("number of quakes read: " + list.size());
        //Durham, NC
        //Location city = new Location(35.988, -78.907);
        //Bridgeport, CA
        Location city = new Location(38.17, -118.82);
        ArrayList<QuakeEntry> listClose = filterByDist(list, 1000*1000, city);
        for (int i = 0; i< listClose.size(); i++) {
            QuakeEntry entry = listClose.get(i);
            double distanceInMeters = city.distanceTo(entry.getLocation());
            System.out.println(distanceInMeters/1000 + " " + entry.getInfo());
        }
        System.out.println("matched " + listClose.size());
    }
    
    public void testfilterByDepth(double depthlow, double depthhigh) {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://www.dukelearntoprogram.com/course4/data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("number of quakes read: " + list.size());
        ArrayList<QuakeEntry> listDeep = filterByDepth(list, depthlow, depthhigh);
        for (int i = 0; i< listDeep.size(); i++) {
            QuakeEntry entry = listDeep.get(i);
            System.out.println(entry);
        }
        System.out.println("matched " + listDeep.size());
    }
    
    public void testfilterByPhrase(String where, String phrase) {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://www.dukelearntoprogram.com/course4/data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("number of quakes read: " + list.size());
        ArrayList<QuakeEntry> listPhrased = filterByPhrase(list, where, phrase);
        for (int i = 0; i< listPhrased.size(); i++) {
            QuakeEntry entry = listPhrased.get(i);
            System.out.println(entry);
        }
        System.out.println("matched " + listPhrased.size());
    }
    
}
