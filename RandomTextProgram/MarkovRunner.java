/**
 * run different Markov Models to generate random text by
 * random seed
 * training text
 * leads of different lengths
 * @DinhHuuNguyen
 * @01/25/2016
 */

import edu.duke.*;

public class MarkovRunner {
    
    public void testgetFollows() {
        String text = "this is a test yes this is a test.";
        text = text.replace('\n', ' ');
        MarkovOne markov1 = new MarkovOne();
        markov1.setTrainingText(text);
        System.out.println(markov1.getFollows("t").size());
        System.out.println(markov1.getFollows("t"));
    }
    
    public void testgetFollowsWithFile(String lead) {
        FileResource fr = new FileResource();
        String text = fr.asString();
        text = text.replace('\n', ' ');
        MarkovOne markov1 = new MarkovOne();
        markov1.setTrainingText(text);
        System.out.println(markov1.getFollows(lead).size());
        System.out.println(markov1.getFollows(lead));
    }
    
    public void runMarkovZero(int seed, int generatedsize) {
        FileResource fr = new FileResource();
        String text = fr.asString();
        text = text.replace('\n', ' ');
        MarkovZero markov0 = new MarkovZero();
        markov0.setRandom(seed);
        markov0.setTrainingText(text);
        Helpers hp = new Helpers();
        String generated = markov0.getRandomText(generatedsize);
        hp.printOut(generated);
    }
    
    public void runMarkovOne(int seed, int generatedsize) {
        FileResource fr = new FileResource();
        String text = fr.asString();
        text = text.replace('\n', ' ');
        MarkovOne markov1 = new MarkovOne();
        markov1.setRandom(seed);
        markov1.setTrainingText(text);
        Helpers hp = new Helpers();
        String generated = markov1.getRandomText(generatedsize);
        hp.printOut(generated);
    }
    
    public void runMarkovTwo(int seed, int generatedsize) {
        FileResource fr = new FileResource();
        String text = fr.asString();
        text = text.replace('\n', ' ');
        MarkovTwo markov2 = new MarkovTwo();
        markov2.setRandom(seed);
        markov2.setTrainingText(text);
        Helpers hp = new Helpers();
        String generated = markov2.getRandomText(generatedsize);
        hp.printOut(generated);
    }
    
    public void runMarkovFour(int seed, int generatedsize) {
        FileResource fr = new FileResource();
        String text = fr.asString();
        text = text.replace('\n', ' ');
        MarkovFour markov4 = new MarkovFour();
        markov4.setRandom(seed);
        markov4.setTrainingText(text);
        Helpers hp = new Helpers();
        String generated = markov4.getRandomText(generatedsize);
        hp.printOut(generated);
    }
    
    public void runMarkovN(int seed, int generatedsize, int N) {
        FileResource fr = new FileResource();
        String text = fr.asString();
        text = text.replace('\n', ' ');
        MarkovN markovN = new MarkovN(N);
        markovN.setTrainingText(text);
        markovN.setRandom(seed);
        Helpers hp = new Helpers();
        String generated = markovN.getRandomText(generatedsize);
        hp.printOut(generated);
    }
    
}
