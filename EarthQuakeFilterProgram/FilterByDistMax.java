/**
 * filters quake entries by given distance max
 * @DinhHuuNguyen 
 * @01/20/2016
 */
public class FilterByDistMax implements Filter {
    private String filtername;
    private Location current;
    private int distMax;
    
    public FilterByDistMax(String name, Location loc, int max) {
        //filtername = name;
        current = loc;
        distMax = max;
    } 

    public boolean satisfies(QuakeEntry qe) { 
        return qe.getLocation().distanceTo(current) <= distMax; 
    }
    
    public String getName () {
        return filtername;
    }

}