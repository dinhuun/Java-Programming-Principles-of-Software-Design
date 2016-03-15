/**
 * run subclasses Markov Models of lead lengths 0, 1, 2, 3, 4, N and N Efficient
 * test/print the HashMap<String, ArrayList<String>> to make MarkovNEfficient efficient
 * time MarkovN vs MarkovNEfficient
 * @DinhHuuNguyen
 * @01/26/2016
 */

import edu.duke.*;
import java.util.*;

public class MarkovRunnerWithInterface {
    
    public void runModel(IMarkovModel markov, int seed, String text, int generatedsize) {
        markov.setRandom(seed);
        markov.setTrainingText(text);
        Helpers hp = new Helpers();
        System.out.println("running with " + markov);
        String generated = markov.getRandomText(generatedsize);
        hp.printOut(generated);
    }
    
    public void runMarkovModels(int seed, int generatedsize, int N) {
        FileResource fr = new FileResource();
        String text = fr.asString();
        text = text.replace('\n', ' ');
        
        MarkovZero markov0 = new MarkovZero();
        runModel(markov0, seed, text, generatedsize);
    
        MarkovOne markov1 = new MarkovOne();
        runModel(markov1, seed, text, generatedsize);
        
        MarkovTwo markov2 = new MarkovTwo();
        runModel(markov2, seed, text, generatedsize);
        
        MarkovFour markov4 = new MarkovFour();
        runModel(markov4, seed, text, generatedsize);
        
        MarkovN markovN = new MarkovN(N);
        runModel(markovN, seed, text, generatedsize);

    }
    
    public void testHashMap (int seed, int generatedsize, int N) {
        FileResource fr = new FileResource();
        String text = fr.asString();
        text = text.replace('\n', ' ');
        MarkovNEfficient markovNE = new MarkovNEfficient(N);
        runModel(markovNE, seed, text, generatedsize);
    }
    
    public void compareMMvsMME (int seed, int generatedsize, int N) {
        FileResource fr = new FileResource();
        String text = fr.asString();
        text = text.replace('\n', ' ');
		MarkovN markovN = new MarkovN(N);
		double begin = System.nanoTime();
		for (int i = 0; i < 3; i++) {
		    runModel(markovN, seed, text, generatedsize);
		}
		double end = System.nanoTime();
		double time0 = (end - begin)/1e9/3;

        MarkovNEfficient markovNE = new MarkovNEfficient(N);
        begin = System.nanoTime();
        for (int i = 0; i < 3; i++) {
            runModel(markovNE, seed, text, generatedsize);
        }
        end = System.nanoTime();
		double time1 = (end - begin)/1e9/3;
        System.out.println(time0 + "\t" + time1);
    }

}
