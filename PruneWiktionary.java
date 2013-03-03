import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class PruneWiktionary {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("WiktionaryPruned8.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("WiktionaryFinalWordlist.txt"));
		String s = br.readLine();
		String[] store = new String[300000];
		int count = 0;
		PriorityQueue<String> q = new PriorityQueue<String>();
		
		while (s!= null) {
			String word = s.substring(0, s.indexOf(" ---- ")).trim();
			if (count == 0) {
				store[0] = word;
				count++;
			}
			else
				if (!store[count - 1].equals(word)) {
					store[count] = word;
					count++;
				}
			s = br.readLine();
		}
		br.close();
		
		for (int i = 1; i <= 10; i++) {
			for (int j = 0; j < count; j++) {
				if (store[j].length() == i) {
					q.add(store[j]);
				}
			}
			
			while (!q.isEmpty()) {
				bw.write(q.remove());
				bw.newLine();
			}
			bw.newLine();
		}
		
		bw.close();
	}
}

/* Word length and unwanted characters

while (word.indexOf(" ") != -1) {
				word = word.substring(0, word.indexOf(" ")) + word.substring(word.indexOf(" ") + 1);
			}
			
			if (word.length() > 15 || word.length() == 1)
				valid = false;
			
			for (int i = 0; i < word.length() && valid; i++) {
				if (!(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'))
					valid = false;
			}
			
			if (valid) {
				bw.write(word + " ---- " + def);
				bw.newLine();
			}

*/

/* clean definitions

			if (def.indexOf("PLURAL OF") != -1 || def.indexOf("W:") != -1)
				valid = false;
			
			if (def.indexOf("{{") != -1) {
				int index1 = def.indexOf("{{");
				int index2 = def.indexOf("}}");
				def = def.substring(0, index1) + def.substring(index2 + 2);
			}
			
			if (valid) {
				for (int i = 0; i < def.length(); i++) {
					if (def.charAt(i) == '[' || def.charAt(i) == ']') {
						def = def.substring(0, i) + def.substring(i + 1);
					}
				}
			}
			
			if (valid) {
				bw.write(word + " ---- " + def);
				bw.newLine();
			}
			
*/