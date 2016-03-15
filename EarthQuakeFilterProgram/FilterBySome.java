/**
 * filters quake entries by some filters
 * @DinhHuuNguyen 
 * @01/20/2016
 */

import java.io.*;
import edu.duke.*;
import java.util.*;

public class FilterBySome implements Filter {
    private ArrayList<Filter> filters;
    private String filternames;
    
    public FilterBySome () {
        filters = new ArrayList<Filter>();
        filternames = new String();
    }
    
    public void addFilter (Filter f) {
        filters.add(f);
    }
    
    public boolean satisfies (QuakeEntry qe) {
        for (Filter f : filters) {
            if (! f.satisfies(qe)) {
                return false;
            }
        }
        return true;
    }
    
    public String getName () {
        for (Filter f : filters) {
            filternames = filternames + f.getName() + " ";
        }
        return filternames;    
    }
    
}
