/**
 * Print the line that contains the first occurrence of the word "wisdom" in the given text file.
 *
 * @author Duke Software Team 
 */
import edu.duke.*;
import java.io.*;

public class Wisdom {
	public void findWisdom() {
		FileResource fr = new FileResource("data/confucius.txt");
		for (String l : fr.lines()) {
			if (l.contains("wisdom")) {
				System.out.println(l);
				break;
			}
		}
	}
    
    public static void main(String[] args) {
        Wisdom w = new Wisdom();    
        w.findWisdom();
    }
}
