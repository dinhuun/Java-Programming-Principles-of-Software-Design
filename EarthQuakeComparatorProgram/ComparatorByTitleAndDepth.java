/**
 * compare two earthquakes based on their titles and depths
 * @DinhHuuNguyen 
 * @01/23/2016
 */

import java.util.*;

public class ComparatorByTitleAndDepth implements Comparator<QuakeEntry> {
    
    public int compare(QuakeEntry qe0, QuakeEntry qe1) {
        if (qe0.getInfo().compareTo(qe1.getInfo()) == 0) {
            return Double.compare(qe0.getDepth(), qe1.getDepth());
        }
        else {
            return qe0.getInfo().compareTo(qe1.getInfo());
        }
    }
    
}