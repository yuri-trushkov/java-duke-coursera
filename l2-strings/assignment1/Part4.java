


import edu.duke.*;
import java.io.*;

public class Part4 {
    
        
    public static void main(String[] args) {
        
        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        
        for (String word : ur.words()) {
            int ind = -1, indStart = -1, indEnd = -1;
            
            String word_lower = word.toLowerCase();
            ind = word_lower.indexOf("youtube.com");
            if (ind != -1) {
            
                indStart = word.lastIndexOf("\"", ind); 
                indEnd = word.indexOf("\"", ind); 
                
                System.out.println(word.substring(indStart + 1, indEnd));
            }
        }
        
    }
    
}
