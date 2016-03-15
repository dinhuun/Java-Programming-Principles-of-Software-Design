/**
 * compare two earthquakes based on their depths
 * @DinhHuuNguyen 
 * @01/23/2016
 */

import java.util.*;

public class ComparatorByDepth implements Comparator<QuakeEntry> {
    
    public int compare(QuakeEntry qe0, QuakeEntry qe1) {
        return Double.compare(qe0.getDepth(), qe1.getDepth());
        //to be used with Collections.sort(list, new ComparatorByMag());
    }
    
}