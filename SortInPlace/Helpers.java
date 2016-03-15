/**
 * some helpers for Quake Sort in Place
 * @DinhHuuNguyen
 * @01/22/2016
 */

import java.util.*;

public class Helpers {
    
    public boolean checkInOrderByMag(ArrayList<QuakeEntry> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).getMagnitude() > list.get(i+1).getMagnitude()) {
                return false;
            }
        }
        return true;
    }
    
    public int getIndexOfSmallestMag(ArrayList<QuakeEntry> list, int from) {
        int minIndex = from;
        for (int i = from + 1; i < list.size(); i++) {
            if (list.get(i).getMagnitude() < list.get(minIndex).getMagnitude()) {
                minIndex = i;
            }
        }
        return minIndex;
    }
    
    public int getIndexOfLargestDepth(ArrayList<QuakeEntry> list, int from) {
        int maxIndex = from;
        for (int i = from +1; i < list.size(); i++) {
            if (list.get(i).getDepth() > list.get(maxIndex).getDepth()) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}
