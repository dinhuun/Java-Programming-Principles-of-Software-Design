/**
 * run MarkovWord Models of lead lengths N and N Efficient
 * time MarkovWordN vs MarkovWordNEfficient
 * @DinhHuuNguyen
 * @01/27/2016
 */

import edu.duke.*;

public class MarkovRunner {
    public void runModel(IMarkovModel markov, String text, int generatedsize){ 
        markov.setTraining(text);
        Helpers hp = new Helpers();
        System.out.println("running with " + markov);
        String generated = markov.getRandomText(generatedsize); 
        hp.printOut(generated);
    } 

    public void runModel(IMarkovModel markov, int seed, String text, int generatedsize){ 
        markov.setRandom(seed);
        markov.setTraining(text); 
        Helpers hp = new Helpers();
        System.out.println("running with " + markov);
        String generated = markov.getRandomText(generatedsize); 
        hp.printOut(generated);
    } 

    public void runMarkovModels(int seed, int generatedsize, int N) { 
        FileResource fr = new FileResource(); 
        String text = fr.asString(); 
        text = text.replace('\n', ' '); 
        MarkovWordN markovWN = new MarkovWordN(N); 
        runModel(markovWN, seed, text, generatedsize); 
    }
    
    public void compareMWNvsMWNE (int seed, int generatedsize, int N) {
        FileResource fr = new FileResource();
        String text = fr.asString();
        text = text.replace('\n', ' ');
		MarkovWordN markovWN = new MarkovWordN(N);
		double begin = System.nanoTime();
		for (int i = 0; i < 3; i++) {
		    runModel(markovWN, seed, text, generatedsize);
		}
		double end = System.nanoTime();
		double time0 = (end - begin)/1e9/3;

        MarkovWordNEfficient markovWNE = new MarkovWordNEfficient(N);
        begin = System.nanoTime();
        for (int i = 0; i < 3; i++) {
            runModel(markovWNE, seed, text, generatedsize);
        }
        end = System.nanoTime();
		double time1 = (end - begin)/1e9/3;
        System.out.println(time0 + "\t" + time1);
    }
    
    public void testHashMap(int seed, int generatedsize, int N) {
        FileResource fr = new FileResource();
        String text = fr.asString();
        text = text.replace('\n', ' ');
        MarkovWordNEfficient markovWNE = new MarkovWordNEfficient(N);
        runModel(markovWNE, seed, text, generatedsize);
    }

}
