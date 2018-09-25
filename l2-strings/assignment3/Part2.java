


import edu.duke.*;
import java.io.*;

public class Part2 {
	
    public double getCGRatio(String dna) {    
        int counter = 0;
        for (int i = 0; i < dna.length(); i++) {
            if (dna.charAt(i) == 'C' || dna.charAt(i) == 'G') {
                counter++;
            }
        } 
        return counter / (double) dna.length();
	}

    public double countCTGGenes(String dna) {    
        int counter = 0;
        int ind = 0;
        
        ind = dna.indexOf("CTG", 0);
        while (ind != -1) {
            counter++;
            ind = dna.indexOf("CTG", ind + 1);
        } 
        return counter;
	}


    public static void main(String[] args) {
        Part2 p2 = new Part2();
        // p2.testGetCGRatio();
        p2.testCountCTGGenes();
    }


    public void testGetCGRatioHelper(String dna) {
        System.out.println(dna + ": " + getCGRatio(dna));    
    }
    public void testGetCGRatio() {
        testGetCGRatioHelper("ATGCCATAG");
    }


    public void testCountCTGGenesHelper(String dna) {
        System.out.println(dna + ": " + countCTGGenes(dna));
    }
    public void testCountCTGGenes() {
        testCountCTGGenesHelper("CTGACTGCTG");
    }

}
