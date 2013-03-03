import java.io.*;
import java.util.PriorityQueue;

public class FullWordListProcessor {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Wordlist Not ABC.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("Wordlist Fully Processed.txt"));
		PriorityQueue<String> q = new PriorityQueue<String>();
		
		String s = br.readLine();
		
		while(s != null) {
			if (!s.equals("")) {
				q.add(s);
			}
			else {
				while (!q.isEmpty()) {
					bw.write(q.remove());
					bw.newLine();
				}
				bw.newLine();
			}
			s = br.readLine();
		}
	}
}
