


import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;

public class Part1 {
    
    public String countryInfo(CSVParser parser, String country) {
        for (CSVRecord record : parser) {
            if (record.get("Country").equals(country)) {
                return record.get("Country") + ": " + record.get("Exports") + ": " + record.get("Value (dollars)");
            }
        }
        return "";
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for (CSVRecord record : parser) {
            if (record.get("Exports").contains(exportItem1) && record.get("Exports").contains(exportItem2)) {
                System.out.println(record.get("Country"));
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem) {
        int counter = 0;
        for (CSVRecord record : parser) {
            if (record.get("Exports").contains(exportItem)) {
                counter++;
            }
        }
        return counter;
    }
    
    public void printBigExporters(CSVParser parser, String amount) {
        String value_field = "Value (dollars)";
        for (CSVRecord record : parser) {
            if (record.get(value_field).length() > amount.length()) {
                System.out.println(record.get("Country") + " " + record.get(value_field));
            }
        }
    }
    
    
    public static void main(String[] args) {
        Part1 p1 = new Part1();
        p1.testCountryInfo();
        p1.testListExportersTwoProducts();
        p1.testNumberOfExporters();
        p1.testPrintBigExporters();
    }
    
    
    public void testCountryInfo() {
        // FileResource fr = new FileResource("exports_small.csv");
        FileResource fr = new FileResource("exportdata.csv");
        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "Germany"));
        System.out.println(countryInfo(parser, "Nauru"));
        System.out.println();
    }
    
    public void testListExportersTwoProducts() {
        // FileResource fr = new FileResource("exports_small.csv");
        FileResource fr = new FileResource("exportdata.csv");
        CSVParser parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "gold", "diamonds");
        System.out.println();
    }
    
    public void testNumberOfExporters() {
        // FileResource fr = new FileResource("exports_small.csv");
        FileResource fr = new FileResource("exportdata.csv");
        CSVParser parser = fr.getCSVParser();
        System.out.println(numberOfExporters(parser, "gold"));
        System.out.println();
}
    
    public void testPrintBigExporters() {
        // FileResource fr = new FileResource("exports_small.csv");
        FileResource fr = new FileResource("exportdata.csv");
        CSVParser parser = fr.getCSVParser();
        // printBigExporters(parser, "$999,999,999");
        printBigExporters(parser, "$999,999,999,999");
        System.out.println();
    }
}
