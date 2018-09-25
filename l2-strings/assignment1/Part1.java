


import edu.duke.*;
import java.io.*;

public class Part1 {
	public String findSimpleGene(String dna) {
        
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {return "";} 
        
        int endIndex = dna.indexOf("TAA", startIndex);
        if (endIndex == -1) {return "";} 
        
        if ( (endIndex - startIndex) % 3 != 0 ) {return "";}
        
        return dna.substring(startIndex, endIndex + 3);
	}
	
    public void testFindSimpleGeneHelper(String dna) {
        String gene = findSimpleGene(dna);
        System.out.println("DNA: " + dna);
        System.out.println("Gene: " + gene);
        System.out.println();
    }
	public void testFindSimpleGene() {
        String dna, gene;
        
        testFindSimpleGeneHelper("ATATATAAA");
        testFindSimpleGeneHelper("ATGATATAG");
        testFindSimpleGeneHelper("ATATATAAA");
        
        testFindSimpleGeneHelper("AT" + "ATG" + "AT" + "TAA");
        testFindSimpleGeneHelper("AT" + "ATG" + "ATA" + "TAA");
    }
	
    
    public static void main(String[] args) {
        
        Part1 p1 = new Part1();
        p1.testFindSimpleGene(); 
    }
    
}
