/**
 * compare two earthquakes based on their last words in titles and depths
 * @DinhHuuNguyen 
 * @01/23/2016
 */

import java.util.*;

public class ComparatorByLastWordAndMag implements Comparator<QuakeEntry> {
    
    public int compare(QuakeEntry qe0, QuakeEntry qe1) {
        String title0 = qe0.getInfo();
        String title1 = qe1.getInfo();
        String lastWord0 = title0.substring(title0.lastIndexOf(" ") + 1);
        String lastWord1 = title1.substring(title1.lastIndexOf(" ") + 1);
        if (lastWord0.compareTo(lastWord1) == 0) {
            return Double.compare(qe0.getMagnitude(), qe1.getMagnitude());
        }
        else {
            return lastWord0.compareTo(lastWord1);
        }
    }
    
}