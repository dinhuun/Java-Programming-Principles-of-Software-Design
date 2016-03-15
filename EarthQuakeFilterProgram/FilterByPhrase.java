/**
 * filters quake entries by given phrase at where in title
 * @DinhHuuNguyen 
 * @01/20/2016
 */

public class FilterByPhrase implements Filter {
    private String filtername;
    private String where;
    private String phrase;
    
    public FilterByPhrase(String name, String at, String s) { 
        filtername = name;
        where = at;
        phrase = s;
    } 

    public boolean satisfies(QuakeEntry qe) {
        if (where.equals("start")) {
            return qe.getInfo().startsWith(phrase);
        }
        if (where.equals("end")) {
            return qe.getInfo().endsWith(phrase);
        }
        if (where.equals("any")) {
            return qe.getInfo().contains(phrase);
        }
        else {
            return false;
        }
    }
    
    public String getName () {
        return filtername;
    }
    
}