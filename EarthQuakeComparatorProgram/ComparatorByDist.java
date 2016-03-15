/**
 * compare two earthquakes based on their distances to certain location
 * @DinhHuuNguyen 
 * @01/23/2016
 */

import java.util.*;

public class ComparatorByDist implements Comparator<QuakeEntry> {
    Location current;
    
    public ComparatorByDist(Location loc) {
        current = loc;
    }
    
    public int compare(QuakeEntry qe0, QuakeEntry qe1) {
        double dist0 = qe0.getLocation().distanceTo(current);
        double dist1 = qe1.getLocation().distanceTo(current);
        return Double.compare(dist0, dist1);
        //to be used with Collections.sort(list, new ComparatorByMag());
    }
    
}