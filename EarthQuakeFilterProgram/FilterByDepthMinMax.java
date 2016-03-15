/**
 * filters quake entries by given depth min-max
 * @DinhHuuNguyen 
 * @01/20/2016
 */
public class FilterByDepthMinMax implements Filter {
    private String filtername;
    private double depthMin;
    private double depthMax;
    
    public FilterByDepthMinMax(String name, double min, double max) { 
        filtername = name;
        depthMin = min;
        depthMax = max;
    } 

    public boolean satisfies(QuakeEntry qe) { 
        return depthMin <= qe.getDepth() && qe.getDepth() <= depthMax; 
    }
    
    public String getName() {
        return filtername;
    }
   
}