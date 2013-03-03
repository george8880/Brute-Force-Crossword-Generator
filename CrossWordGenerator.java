
public class CrossWordGenerator {

}

class Entry {
	String word;
	String clue;
	boolean added;
	
	public Entry (String s) {
		int index = s.indexOf(" ---- ");
		word = s.substring(0, index).trim();
		clue = s.substring(index + 5).trim();
		added = false;
	}
}

class List {
	
}