


import edu.duke.*;
import java.io.*;

public class Part3 {
    
    public void processGenes(StorageResource sr, int lenThreshold) {
        int counter = 0; 
        int maxLength = 0;
        System.out.println("Genes with length > " +  lenThreshold +": ");
        for (String s : sr.data()) {
            if (s.length() > lenThreshold) {
                System.out.println(s);
                counter++;
            }
            if (s.length() > maxLength) {
                maxLength = s.length();
            }
        }
        System.out.println("Number of genes with length > " + lenThreshold + ": " + counter);
        System.out.println("The longest gene length: " + maxLength);
        
        counter = 0; 
        Part2 p2 = new Part2(); 
        System.out.println("Genes with CG ratio > 0.35: ");
        for (String s : sr.data()) {
            if (p2.getCGRatio(s) > 0.25) {
                System.out.println(s);
                counter++;
            }
        }
        System.out.println("Number of genes with CG ratio > 0.35: " + counter);
    }


    public static void main(String[] args) {
        Part3 p3 = new Part3();
        p3.testProcessGenes2();
    }


    public void testProcessGenes1() {
        String dna = 
        "xxxyyyATGuuuvvvwwwTAArrrzzz" + 
        "xxxyyyATGwwwTAArrrzzz" + 
        "xxxyyyATGuuuCCCGGGwwwTAArrrzzz" +
        "xxxyyyATGuuuvvvwwwTAArrrzzz" + 
        "xxxyyyATGuuuvvvwwwTAArrrzzz";
        
        Part1 p1 = new Part1(); 
        processGenes(p1.getAllGenes(dna), 9);
    }
    
    public void testProcessGenes2() {
        FileResource fr = new FileResource("../dna/brca1line.fa");
        String dna = fr.asString().toUpperCase();
        
        Part1 p1 = new Part1(); 
        processGenes(p1.getAllGenes(dna), 60);
    }

}
