


import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;

public class Part1 {
    
    
    public void totalBirths() {
        FileResource fr =   new FileResource();
        int total = 0, boys = 0, girls = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBirths =  Integer.parseInt(rec.get(2));
            total += numBirths;
            if (rec.get(1).equals("M")) {
                boys += numBirths;
            } else if (rec.get(1).equals("F")) {
                girls += numBirths;
            }
        }
        System.out.println("Boys: " + boys);
        System.out.println("Girls: " + girls);
        System.out.println("Total: " + total);
    }
    
    
    public int getRank(int year, String name, String gender) {
        FileResource fr =   new FileResource("../testing/yob" + year + "short.csv");
        int count = 0; 
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if (rec.get(1).equals(gender)) {
                count++;
                if (rec.get(0).equals(name)){
                    return count;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Part1 p1 = new Part1();
        // p1.totalBirths();
        p1.testGetRank();
    }
    
    
    public void testGetRank() {
        int year = 2012;
        String name = "Mason";
        String gender = "M";
        System.out.println(year + " " + name + " " + gender + " : " + getRank(year, name, gender));

        year = 2012;
        name = "Mason";
        gender = "F";
        System.out.println(year + " " + name + " " + gender + " : " + getRank(year, name, gender));
    }
    
}
