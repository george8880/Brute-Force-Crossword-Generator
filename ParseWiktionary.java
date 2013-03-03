import java.io.*;

public class ParseWiktionary {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Wiktionary.tsv"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("WiktionaryWordlist2.txt"));
		String s = br.readLine();
		
		while (s != null) {
			int index = s.indexOf("# ");
			if (index != -1) {
			String word = s.substring(7, index).trim();
			String def = s.substring(index + 1);	
			
			if (word.indexOf("Phrase") != -1) {
				word = word.substring(0, word.indexOf("Phrase"));
			}
			else if (word.indexOf("Conjunction") != -1) {
				word = word.substring(0, word.indexOf("Conjunction"));
			}
			else if (word.indexOf("Adverb") != -1) {
				word = word.substring(0, word.indexOf("Adverb"));
			}
			else if (word.indexOf("Proper noun") != -1) {
				word = word.substring(0, word.indexOf("Proper noun"));
			}
			else if (word.indexOf("Noun") != -1) {
				word = word.substring(0, word.indexOf("Noun"));
			}
			else if (word.indexOf("Adjective") != -1) {
				word = word.substring(0, word.indexOf("Adjective"));
			}
			else if (word.indexOf("Verb") != -1) {
				word = word.substring(0, word.indexOf("Verb"));
			}
			else if (word.indexOf("Preposition") != -1) {
				word = word.substring(0, word.indexOf("Preposition"));
			}
			else if (word.indexOf("Interjection") != -1) {
				word = word.substring(0, word.indexOf("Interjection"));
			}
			else if (word.indexOf("Contraction") != -1) {
				word = word.substring(0, word.indexOf("Contraction"));
			}
			else if (word.indexOf("Pronoun") != -1) {
				word = word.substring(0, word.indexOf("Pronoun"));
			}
			else if (word.indexOf("Suffix") != -1) {
				word = word.substring(0, word.indexOf("Suffix"));
			}
			else if (word.indexOf("{{initialism}}") != -1) {
				word = word.substring(0, word.indexOf("{{initialism}}"));
			}
			else if (word.indexOf("Abbreviation") != -1) {
				word = word.substring(0, word.indexOf("Abbreviation"));
			}
			else if (word.indexOf("{{abbreviation}}") != -1) {
				word = word.substring(0, word.indexOf("{{abbreviation}}"));
			}
			else if (word.indexOf("{{acronym}}") != -1) {
				word = word.substring(0, word.indexOf("{{acronym}}"));
			}
			else if (word.indexOf("Initialism") != -1) {
				word = word.substring(0, word.indexOf("Initialism"));
			}
			
			bw.write(word + " ---- " + def);
			bw.newLine();
			}
			s = br.readLine();
		}
		
		
		bw.close();
		br.close();
	}
}
