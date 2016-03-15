/**
 * an interface that promises 3 methods to be fulfilled by MarkovWord Models
 * DinhHuuNguyen
 * 01/27/2016
 */

public interface IMarkovModel {
    public void setTraining(String text);
    
    public void setRandom(int seed);
    
    public String getRandomText(int numChars);

}
