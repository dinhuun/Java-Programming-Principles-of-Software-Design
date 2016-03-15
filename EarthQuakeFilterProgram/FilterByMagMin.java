/**
 * filters quake entries by given magnitude minimum
 * @DinhHuuNguyen 
 * @01/20/2016
 */
public class FilterByMagMin implements Filter {
    private String filtername;
    private double magMin; 
    
    public FilterByMagMin (String name, double min) { 
        filtername = name;
        magMin = min;
    } 

    public boolean satisfies (QuakeEntry qe) { 
        return qe.getMagnitude() >= magMin; 
    }
    
    public String getName () {
        return filtername;
    }

}