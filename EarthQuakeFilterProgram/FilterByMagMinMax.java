/**
 * filters quake entries by given magnitude minimum-maximum
 * @DinhHuuNguyen 
 * @01/20/2016
 */
public class FilterByMagMinMax implements Filter {
    private String filtername;
    private double magMin; 
    private double magMax;
    public FilterByMagMinMax(String name, double min, double max) { 
        filtername = name;
        magMin = min;
        magMax = max;
    } 

    public boolean satisfies(QuakeEntry qe) { 
        return magMin <= qe.getMagnitude() && qe.getMagnitude() <= magMax; 
    }
    
    public String getName () {
        return filtername;
    }

}