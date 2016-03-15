/**
 * some helpers for Quake Sort into New List
 * @DinhHuuNguyen 
 * @01/13/2016
 */

import java.util.*;

public class Helpers {
    
    public QuakeEntry getEntryOfSmallestMag(ArrayList<QuakeEntry> list) {
        QuakeEntry entryOfSmallest = list.get(0);
        for(QuakeEntry q: list) {
            if (q.getMagnitude() < entryOfSmallest.getMagnitude()) {
                entryOfSmallest = q;
            }
        }
        return entryOfSmallest;
    }
    
    public boolean checkInOrderByMag(ArrayList<QuakeEntry> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).getMagnitude() > list.get(i+1).getMagnitude()) {
                return false;
            }
        }
        return true;
    }

}