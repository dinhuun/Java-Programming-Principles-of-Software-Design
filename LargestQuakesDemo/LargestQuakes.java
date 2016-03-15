/**
 * Find N-closest quakes
 * @author Duke Software/Learn to Program
 * @version 1.0, November 2015
 */

import java.util.*;

public class LargestQuakes {
   public int indexOfLargest(ArrayList<QuakeEntry> list) {
       int index = 0;
       double magmax = 0;
       for (int i = 0; i < list.size(); i++) {
           if (magmax < list.get(i).getMagnitude()){
               index = i;
               magmax = list.get(i).getMagnitude();
            }
       }
       return index;
   }
    
   public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany) {
       ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
       ArrayList<QuakeEntry> ret = new ArrayList<QuakeEntry>();
       for(int i = 0; i < howMany; i++) {
           int index = indexOfLargest(copy);
           ret.add(copy.get(index));
           copy.remove(index);
       }
       return ret;
   }
    
   public void testgetLargest(int howMany){
       EarthQuakeParser parser = new EarthQuakeParser();
       String source = "data/nov20quakedata.atom";
       //String source = "http://www.dukelearntoprogram.com/course4/data/nov20quakedatasmall.atom";
       ArrayList<QuakeEntry> list = parser.read(source);
       System.out.println("number of quakes " + list.size());
       ArrayList<QuakeEntry> large = getLargest(list, howMany);
       for(int i = 0; i < large.size(); i++){
           QuakeEntry entry = large.get(i);
           System.out.println(entry);
       }
       System.out.println("matched " + large.size());
   }
   
}
