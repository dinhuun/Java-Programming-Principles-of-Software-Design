import java.util.*;

public class SortTimings {
	Random random = new Random();
	
	private String makeString(int wordSize) {
		StringBuilder sb = new StringBuilder();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for(int k = 0; k < wordSize; k++) {
			sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
		}
		return sb.toString();
	}
	
	public ArrayList<String> makeListOfStrings(int wordSize, int arraySize){
		ArrayList<String> list = new ArrayList<String>();
		for(int k = 0; k < arraySize; k++){
			list.add(makeString(wordSize));
		}
		return list;
	}
	
	public void sortSelect(String[] list) {
	    for(int k = 0; k < list.length; k++){
			int indexOfMin = k;
			for(int j = k + 1; j < list.length; j++){
				if (list[j].compareTo(list[indexOfMin]) < 0){
					indexOfMin = j;
				}
			}
			String temp = list[k];
			list[k] = list[indexOfMin];
			list[indexOfMin] = temp;
		}
	}
	
	public void sortSelect(ArrayList<String> list) {
		for(int k=0; k < list.size(); k++) {
			int indexOfMin = k;
			for(int j = k + 1; j < list.size(); j++){
				if (list.get(j).compareTo(list.get(indexOfMin)) < 0) {
					indexOfMin = j;
				}
			}
			Collections.swap(list, k, indexOfMin);
		}
	}
	
	public void sortBubble(ArrayList<String> list) {
		for(int k = 0; k < list.size(); k++) {
			for(int j = 0; j < list.size() - k - 1; j++) {
				if (list.get(j).compareTo(list.get(j + 1)) > 0) {
					Collections.swap(list, j, j + 1);
				}
			}
		}
	}
	
	public boolean isSorted(ArrayList<String> list) {
		for(int k = 1; k < list.size(); k++){
			if (list.get(k).compareTo(list.get(k - 1)) < 0) {
				return false;
			}
		}
		return true;
	}
	
	public void timer(int start, int stop, int increment, int trials) {
		for(int k = start; k <= stop; k += increment) {
			ArrayList<String> list = makeListOfStrings(10, k);
			
		    double begin = System.nanoTime();
			for(int j = 0; j < trials; j++) {
				ArrayList<String> copy = new ArrayList<String>(list);
				sortSelect(copy);
				if (! isSorted(copy)) {
					System.out.println("trouble on sorted select " + k);
				}
			}	
			double end = System.nanoTime();
			double stime = (end - begin)/1e9/trials;
			
			begin = System.nanoTime();
			for(int j = 0; j < trials; j++) {
				ArrayList<String> copy = new ArrayList<String>(list);
				Collections.sort(copy);
				if (! isSorted(copy)) {
					System.out.println("trouble on sorted tim " + k);
				}
			}	
			end = System.nanoTime();
			double ttime = (end - begin)/1e9/trials;
			
			System.out.printf("%d\t%3.2f\t%3.2f\n", k, stime, ttime);
		}
	}
	
	public void runSelect(){
	    String[] cats = {"tiger", "lion", "cheetah", "puma", "leopard"};
	    sortSelect(cats);
	    for(String s : cats){
	        System.out.println(s);
	    }
	}

	public void runner(){
		timer(10000, 100000, 10000, 2);
	}

}

