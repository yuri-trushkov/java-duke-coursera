


import edu.duke.*;
import java.io.*;

public class Part2 {
	public String findSimpleGene(String dna, String startCodon, String endCodon) {
        
        String dnaOriginal = dna;

        dna = dna.toLowerCase();
        startCodon = startCodon.toLowerCase();
        endCodon = endCodon.toLowerCase();

        int startIndex = dna.indexOf(startCodon);
        if (startIndex == -1) {return "";} 
        
        int endIndex = dna.indexOf(endCodon, startIndex);
        if (endIndex == -1) {return "";} 
        
        if ( (endIndex - startIndex) % 3 != 0 ) {return "";}
        
        return dnaOriginal.substring(startIndex, endIndex + 3);
	}
	
    public void testFindSimpleGeneHelper(String dna, String startCodon, String endCodon) {
        String gene = findSimpleGene(dna, startCodon, endCodon);
        System.out.println("DNA: " + dna);
        System.out.println("Gene: " + gene);
        System.out.println();
    }
    
	public void testFindSimpleGene() {
        String dna, startCodon, endCodon, gene;
        
        startCodon = "ATG";
        endCodon = "TAA";
        
        dna = "ATATATAAA";
        testFindSimpleGeneHelper(dna, startCodon, endCodon);
        
        dna = "ATGATATAG";
        testFindSimpleGeneHelper(dna, startCodon, endCodon);
        
        dna = "ATATATAAA";
        testFindSimpleGeneHelper(dna, startCodon, endCodon);
        
        dna = "AT" + "ATG" + "AT" + "TAA";
        testFindSimpleGeneHelper(dna, startCodon, endCodon);
        
        dna = "AT" + "ATG" + "ATA" + "TAA";
        testFindSimpleGeneHelper(dna, startCodon, endCodon);
        
        dna = dna.toLowerCase();
        testFindSimpleGeneHelper(dna, startCodon, endCodon);
    }
	
    
    public static void main(String[] args) {
        
        Part2 p2 = new Part2();
        p2.testFindSimpleGene(); 
    }
    
}
