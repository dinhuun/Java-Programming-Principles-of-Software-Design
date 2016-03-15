
/**
 * an interface Filter that promises method satisfies of type boolean
 * @DinhHuuNguyen 
 * @01/20/2016
 */
public interface Filter {
    
    public  boolean satisfies(QuakeEntry qe);
    
    public String getName();
    
}
