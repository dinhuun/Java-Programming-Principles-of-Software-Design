/**
 * run Markov Models of lead lengths 1, 2
 * @DinhHuuNguyen
 * @01/27/2016
 */

import edu.duke.*;

public class MarkovRunner {
    
    public void runModel(IMarkovModel markov, String text, int generatedsize){ 
        Helpers hp = new Helpers();
        markov.setTraining(text);
        System.out.println("running with " + markov); 
        String generated = markov.getRandomText(generatedsize); 
        hp.printOut(generated); 
    } 

    public void runModel(IMarkovModel markov, int seed, String text, int generatedsize){ 
        Helpers hp = new Helpers();
        markov.setTraining(text); 
        markov.setRandom(seed);
        System.out.println("running with seed " + seed + "\t" + markov);  
        String generated = markov.getRandomText(generatedsize); 
        hp.printOut(generated);
    } 

    public void runMarkovModels(int seed, int generatedsize) { 
        FileResource fr = new FileResource(); 
        String textsize = fr.asString(); 
        textsize = textsize.replace('\n', ' '); 
        MarkovWordOne markovWord1 = new MarkovWordOne(); 
        runModel(markovWord1, seed, textsize, generatedsize);
        
        MarkovWordTwo markovWord2 = new MarkovWordTwo();
        runModel(markovWord2, seed, textsize, generatedsize);
    } 

}
