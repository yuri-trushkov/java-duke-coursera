


import edu.duke.*;
import java.io.*;

public class Part3 {
	public boolean twoOccurances(String stringa, String stringb) {
        
        int index = -1;
        index = stringb.indexOf(stringa);
        if (index == -1) {return false;}
        
        index = stringb.indexOf(stringa, index + 1);
        if (index == -1) {return false;}
         
        return true;
	}
    
    
	public void testTwoOccurancesHelper(String stringa, String stringb) {
        System.out.println("stringa: " + stringa);
        System.out.println("stringb: " + stringb);
        System.out.println("twoOccurrences: " + twoOccurances(stringa, stringb));
        System.out.println();
    }
    
	public void testTwoOccurances() {
        String stringa, stringb;
        
        stringa = "by"; 
        stringb = "A story by Abby Long"; 
        testTwoOccurancesHelper(stringa, stringb);

        stringa = "a"; 
        stringb = "banana"; 
        testTwoOccurancesHelper(stringa, stringb);

        stringa = "atg"; 
        stringb = "ctgtatgta"; 
        testTwoOccurancesHelper(stringa, stringb);

    }
	
    public String lastPart(String stringa, String stringb) {
        int index = -1;
        
        index = stringb.indexOf(stringa);
        if (index == -1) { 
            return stringb;
        } else {
            return stringb.substring(index + stringa.length());
                         
        }
    }
    
    public void testLastPartHelper(String stringa, String stringb) {
        System.out.println("stringa: " + stringa);
        System.out.println("stringb: " + stringb);
        System.out.println("lastPart: " + lastPart(stringa, stringb));
        System.out.println();
    }    
    
    public void testLastPart() {
        String stringa, stringb;
        
        stringa = "an"; 
        stringb = "banana"; 
        testLastPartHelper(stringa, stringb);

        stringa = "zoo"; 
        stringb = "forest"; 
        testLastPartHelper(stringa, stringb);

    }
    
    public static void main(String[] args) {
        
        Part3 p3 = new Part3();
        // p3.testTwoOccurances(); 
        p3.testLastPart(); 
    }
    
}
