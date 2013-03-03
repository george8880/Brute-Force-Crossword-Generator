import java.io.*;
import java.util.Scanner;

public class TestRawNStuff {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Cooked.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("Wordlist.txt"));
		
		String[] word = new String[4000];
		String[] clue = new String[4000];
		String category = "";
		int count = 0;
		
		String s = br.readLine();
		
		while (s != null) {
			if (s.indexOf("----------------------") != -1) {
				int start = 0, end = 0;
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) != '-' && start == 0) {
						start = i;
					}
					if (s.charAt(i) == '-' & end == 0 && start != 0) {
						end = i;
					}
				}
				category = "(" + s.substring(start, end).trim() + ")";
				category = category.trim().toUpperCase();
			}
			else if (s.length() >= 5) {
				int indexOfMarker = s.indexOf(" - ");
				word[count] = s.substring(0, indexOfMarker).trim().toUpperCase();
				clue[count] = s.substring(indexOfMarker + 3).trim() + " " + category;
				clue[count] = clue[count].toUpperCase();
				if (word[count].indexOf(' ') != -1) {
					int indexSpace = word[count].indexOf(' ');
					word[count] = word[count].substring(0, indexSpace) + word[count].substring(indexSpace + 1);
				}
				count++;
			}
			s = br.readLine();
		}
		
		System.out.println("Done Input");
		
		for (int i = 2; i < 16; i++) {
			for (int j = 0; j < 4000; j++) {
				if (word[j] != null && word[j].length() == i) {
					bw.write(word[j] + " ---- " + clue[j]);
					bw.newLine();
				}
			}
			bw.newLine();
		}
	}
}
