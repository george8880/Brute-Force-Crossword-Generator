import java.io.*;
import java.util.*;

public class RawProcessor {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new FileReader("AggregateWordlist.txt"));
		
		String line = br.readLine();
		String compared = "";
		
		while (line != null) {
			if (!compared.equals("")) {
				if (line.compareTo(compared) > 0)
					System.out.println("ERROR");
			}
			compared = line;
			line = br.readLine();
		}
		
		br.close();
	}
}

/*
int counter = 0; //even number = word; odd number = clue;
		
		BufferedReader br = new BufferedReader(new FileReader("Raw.txt"));
		String line = br.readLine();
		
		while (line != null) {
			if (!line.equals("") && line.substring(0,5).equals("$$$$$")) {
				if (counter%2 != 0) {
					System.out.println("--------------------------ERROR--------------------------------");
					counter++;
				}
				System.out.println();
				System.out.println(line.substring(5).trim());
				line = br.readLine();
			}
			else {
				int valueIndex = line.indexOf("value=");
				while (valueIndex != -1) {
					int quot1Index = line.indexOf("\"", valueIndex);
					int quot2Index = line.indexOf("\"", quot1Index + 1);
					if (counter%2 == 0) {
						System.out.print(line.substring(quot1Index+1, quot2Index) + " - ");
					}
					else {
						System.out.println(line.substring(quot1Index+1, quot2Index));
					}
					counter++;
					line = line.substring(quot2Index+1);
					valueIndex = line.indexOf("value=");
				}
				line = br.readLine();
			}
		}
	}
*/