


import edu.duke.*;
import java.io.*;

public class Part1 {
	public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startIndex);
        while (currIndex != -1) {
            if ( (currIndex - startIndex) % 3 == 0 ) {return currIndex;}        
            currIndex = dna.indexOf(stopCodon, currIndex + 1);
        }
        return -1;        
	}
    
    int getMinIndex(int ind1, int ind2){
        if (ind1 == -1 && ind2 == -1) {return -1;} 
        else if (ind1 == -1 || ind2 == -1) {return Math.max(ind1, ind2);}
        else {return Math.min(ind1, ind2);}
        
    }
    int getMinIndex(int ind1, int ind2, int ind3) {
        int indt = getMinIndex(ind1, ind2);
        return getMinIndex(indt, ind3);
    }

    public String findGene(String dna, int startIndex) {
        startIndex = dna.indexOf("ATG", startIndex);
        if (startIndex == -1) {return "";}
        
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        
        int minIndex = getMinIndex(taaIndex, tagIndex, tgaIndex);
        if (minIndex == -1) {return "";}
        return dna.substring(startIndex, minIndex + 3);
    }
    
    public void printAllGenes(String dna) {
        String gene;
        int startIndex = 0;
        while(true) {            
            gene = findGene(dna, startIndex);
            if (gene.isEmpty()) {break;}
            System.out.println(gene);
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
        return;
    }
    
    
    public void testFindStopCodonHelper(String dna, int startIndex, String stopCodon) {
       int endIndex = findStopCodon(dna, startIndex, stopCodon);
       System.out.println("DNA: " + dna);
       System.out.println("Codon: " + stopCodon);
       System.out.println("Start index: " + startIndex);
       System.out.println("Codon index: " + endIndex);
       System.out.println();
    }
    public void testFindStopCodon() {
        testFindStopCodonHelper("xxxyyyATGuuuvvvTAArrrzzz", 0, "TAA");
        testFindStopCodonHelper("xxxyyyATGuuuvvvTAArrrzzz", 1, "TAA");
        testFindStopCodonHelper("xxxyyyATGuuuvvvTARrrrzzz", 0, "TAA");
    }
    
    
    public void testFindGeneHelper(String dna, int startIndex) {
       String gene = findGene(dna, startIndex);
       System.out.println("DNA: " + dna);
       System.out.println("StartIndex: " + startIndex);
       System.out.println("Gene: " + gene);
       System.out.println();
    }
    public void testFindGene() {
        testFindGeneHelper("xxxyyyATGuuuvvvTAArrrzzz", 0);
        testFindGeneHelper("xxxyyyATGuuuvvvTAGrrrzzz", 0);
        testFindGeneHelper("xxxyyyATGuuuvvvTGArrrzzz", 0);
        testFindGeneHelper("xxxyyyATGuuuvvvTAArrrzzzTAA", 0);
        testFindGeneHelper("xxxyyyATGuuuvTAArrrzzz", 0);
        testFindGeneHelper("xxxyyyuuuvvvTGArrrzzz", 0);
        testFindGeneHelper("xxxyyyATGuuuvrrrzzz", 0);
        testFindGeneHelper("AxxxyyyATGuuuvvvTAArrrzzz", 1);
    }
    
	
    public void testPrintAllGenes() {
        printAllGenes("atggatcctccatatacaacggtatctccacctcaggtttagatctcaacaacggaaccattgccgacatgatggatcctccatatacaacggtatctccacctcaggtttagatctcaacaacggaaccattgccgacatg".toUpperCase());
        
    }
	
    
    public static void main(String[] args) {
        
        Part1 p1 = new Part1();
        // p1.testFindStopCodon(); 
        p1.testFindGene(); 
        // p1.testPrintAllGenes();
    }
    
}
