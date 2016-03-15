/**
 * compare two earthquakes based on their magnitudes and depths
 * @DinhHuuNguyen 
 * @01/23/2016
 */

import java.util.*;

public class ComparatorByMagAndDepth implements Comparator<QuakeEntry> {
    
    public int compare(QuakeEntry qe0, QuakeEntry qe1) {
        if (Double.compare(qe0.getMagnitude(), qe1.getMagnitude()) == 0) {
            return Double.compare(qe0.getDepth(), qe1.getDepth());
        }
        else {
            return Double.compare(qe0.getMagnitude(), qe1.getMagnitude());
        }
    }
    
}