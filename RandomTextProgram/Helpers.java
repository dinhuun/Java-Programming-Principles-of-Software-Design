/**
 * some helpers for MarkovRunner
 * @DinhHuuNguyen 
 * @01/25/2016
 */
public class Helpers {
    
    public void printOut(String s) {
		String[] words = s.split("\\s+");
		int linesize = 0;
		System.out.println("----------------------------------");
		for(int k = 0; k < words.length; k++){
			System.out.print(words[k]+ " ");
			linesize += words[k].length() + 1;
			if (linesize > 60) {
				System.out.println();
				linesize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	}

}
