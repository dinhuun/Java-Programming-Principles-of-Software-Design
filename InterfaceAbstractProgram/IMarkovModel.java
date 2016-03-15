/**
 * an interface that promises 3 methods to be fulfilled by Markov Models
 * DinhHuuNguyen
 * 01/26/2016
 */

public interface IMarkovModel {
    
    public void setRandom(int seed);
    
    public void setTrainingText(String trainingtext);
    
    public String getRandomText(int numChars);
    
}
