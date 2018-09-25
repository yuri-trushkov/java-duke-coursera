


import edu.duke.*;
import java.io.*;

public class Part2 {
    
    public int howMany(String stringa, String stringb) {
        int index = -1;
        int count = 0;
        while (true) {
            index = stringb.indexOf(stringa, index + stringa.length());
            if (index == -1) {break;}
            count += 1;
        }
        return count;
    }
    
    public void testHowManyHelper(String stringa, String stringb) {
        int count  = howMany(stringa, stringb);
        System.out.println(stringb);
        System.out.println(stringa);
        System.out.println(count);
        System.out.println();
    }
    public void testHowMany() {
        testHowManyHelper("GAA", "ATGAACGAATTGAATC");
        testHowManyHelper("AA", "ATAAAA");
    }
    
    public static void main(String[] args) {
        
        Part2 p2 = new Part2();
        p2.testHowMany(); 
    }

}
