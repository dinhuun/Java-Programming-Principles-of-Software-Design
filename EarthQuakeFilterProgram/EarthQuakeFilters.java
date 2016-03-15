/**
 * filter earthquakes by
 * filters that implement Filter inferface
 * @DinhHuuNguyen 
 * @01/20/2016
 */

import java.util.*;
import edu.duke.*;

public class EarthQuakeFilters {
    
    public EarthQuakeFilters() {
        // TODO Auto-generated constructor stub
    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        dumpCSV(list);
        System.out.println("number of quakes read " + list.size());
    }

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

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> filtered = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                filtered.add(qe); 
            } 
        } 
        return filtered;
    } 

    public void filterByMagMin(String filename, int min) { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/" + filename + ".atom";
        ArrayList<QuakeEntry> list = parser.read(source); 
        System.out.println("read data for " + list.size() + " quakes");
        Filter f = new FilterByMagMin("MagMin", min); 
        ArrayList<QuakeEntry> filtered = filter(list, f); 
        for (QuakeEntry qe: filtered) { 
            System.out.println(qe);
        }
        System.out.println("matched " + filtered.size());
    }
    
    public void filterByMagMinMax(String filename, double min, double max) { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/" + filename + ".atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for " + list.size() + " quakes");
        Filter f = new FilterByMagMinMax("MagMinMax", min, max); 
        ArrayList<QuakeEntry> filtered = filter(list, f); 
        for (QuakeEntry qe: filtered) { 
            System.out.println(qe);
        }
        System.out.println("matched " + filtered.size());
    }
    
    public void filterByDepthMinMax(String filename, double min, double max) { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/" + filename + ".atom";
        ArrayList<QuakeEntry> list = parser.read(source); 
        System.out.println("read data for " + list.size() + " quakes");
        Filter f = new FilterByDepthMinMax("DepthMinMax", min, max); 
        ArrayList<QuakeEntry> filtered = filter(list, f); 
        for (QuakeEntry qe: filtered) { 
            System.out.println(qe);
        }
        System.out.println("matched " + filtered.size());
    }
    
    public void filterByDistMax(String filename, double lat, double lon, int dist) { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/" + filename + ".atom";
        ArrayList<QuakeEntry> list = parser.read(source); 
        System.out.println("read data for " + list.size() + " quakes");
        Location current = new Location(lat, lon);
        Filter f = new FilterByDistMax("DistMax", current, dist); 
        ArrayList<QuakeEntry> filtered = filter(list, f); 
        for (QuakeEntry qe: filtered) { 
            System.out.println(qe);
        }
        System.out.println("matched " + filtered.size());
    }
    
    public void filterByPhrase(String filename, String at, String s) { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/" + filename + ".atom";
        ArrayList<QuakeEntry> list = parser.read(source); 
        System.out.println("read data for " + list.size() + " quakes");
        Filter f = new FilterByPhrase("Phrase", at, s); 
        ArrayList<QuakeEntry> filtered = filter(list, f); 
        for (QuakeEntry qe: filtered) { 
            System.out.println(qe);
        }
        System.out.println("matched " + filtered.size());
    }
    
    public void filterBySome1() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source); 
        System.out.println("read data for " + list.size() + " quakes");
        FilterBySome maf = new FilterBySome();
        maf.addFilter (new FilterByMagMinMax("MagMinMax", 0.0, 5.0));
        maf.addFilter (new FilterByDepthMinMax("DepthMinMax", -180000.0, -30000.0));
        maf.addFilter (new FilterByPhrase("Phrase", "any", "o"));
        ArrayList<QuakeEntry> filtered = filter(list, maf); 
        for (QuakeEntry qe: filtered) { 
            System.out.println(qe);
        }
        System.out.println("matched " + filtered.size());
        System.out.println("filters used " + maf.getName());
    }
    
    public void filterBySome2() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source); 
        System.out.println("read data for " + list.size() + " quakes");
        Location billund = new Location(55.7308, 9.1153);
        //Location tokyo = new Location(35.42, 139.43);
        FilterBySome maf = new FilterBySome();
        maf.addFilter (new FilterByMagMinMax("MagMinMax", 0.0, 5.0));
        maf.addFilter (new FilterByDistMax("DistMax", billund, 3000000));
        maf.addFilter (new FilterByPhrase("Phrase", "any", "e"));
        ArrayList<QuakeEntry> filtered = filter(list, maf); 
        for (QuakeEntry qe: filtered) { 
            System.out.println(qe);
        }
        System.out.println("matched " + filtered.size());
        System.out.println("filters used " + maf.getName());
    }

}
