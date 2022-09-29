import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.io.IOException;

public class IDs {
	public static void main(String[] args) {
		int counter = 0;
		String word = "";
		try {
			URL url = new URL("https://terraria.fandom.com/wiki/Item_IDs");
			URLConnection urlCon = url.openConnection();
			InputStream input = urlCon.getInputStream();
			FileWriter fWriter = new FileWriter("TerrariaIDs.txt", true);
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			int i = 0;
			char c;
			boolean wordOut = false;
			while((i=input.read()) != -1) {
				c = ((char)i); // get the current character
				String test = String.valueOf(c); // convert current character into a string
				if((test.equals("<")) && !word.equals("<td><code>")) // should've used a switch case (and prob could've been more efficient) but too late, may change later
					word = word + test;	
				else if((test.equals("t")) && !word.equals("<td><code>"))
					word = word + test;
				else if((test.equals("d")) && !word.equals("<td><code>"))
					word = word + test;
				else if((test.equals(">")) && !word.equals("<td><code>"))
					word = word + test;
				else if((test.equals("<")) && !word.equals("<td><code>"))
					word = word + test;
				else if((test.equals("c")) && !word.equals("<td><code>"))
					word = word + test;
				else if((test.equals("o")) && !word.equals("<td><code>"))
					word = word + test;
				else if((test.equals("d")) && !word.equals("<td><code>"))
					word = word + test;
				else if((test.equals("e")) && !word.equals("<td><code>"))
					word = word + test;
				else if((test.equals(">")) && !word.equals("<td><code>"))
					word = word + test;
				else if(word.equals("<td><code>")) {
					counter++;
					wordOut = true;
					word = "";
				}
				else
					word = "";			
				if(wordOut) {
					if(c != '<') 
						bWriter.write(c);
					else {
						bWriter.write("\n");
						wordOut = false;
					}
				}
			}
			bWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
