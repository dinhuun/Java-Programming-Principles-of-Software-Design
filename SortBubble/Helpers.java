/**
 * some helpers for Quake Sort Bubble
 * @DinhHuuNguyen
 * @01/22/2016
 */

import java.util.*;

public class Helpers {
    
    public void bubbleSortByMag(ArrayList<QuakeEntry> list, int numSorted) {
        for (int i = 0; i < list.size() - numSorted - 1; i++) {
            if (list.get(i).getMagnitude() > list.get(i+1).getMagnitude()) {
                QuakeEntry temp = list.get(i);
                list.set(i, list.get(i+1));
                list.set(i+1, temp);
            }
        }
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
