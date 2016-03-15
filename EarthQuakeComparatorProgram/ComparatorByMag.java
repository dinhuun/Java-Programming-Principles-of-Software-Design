/**
 * compare two earthquakes based on their magnitudes
 * @DinhHuuNguyen 
 * @01/23/2016
 */

import java.util.*;

public class ComparatorByMag implements Comparator<QuakeEntry> {
    
    public int compare(QuakeEntry qe0, QuakeEntry qe1) {
        return Double.compare(qe0.getMagnitude(), qe1.getMagnitude());
    }
    
}
