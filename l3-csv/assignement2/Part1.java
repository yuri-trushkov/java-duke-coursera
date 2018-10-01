import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;
import java.nio.charset.Charset;

public class Part1 {
        
    public CSVRecord getColdestRecord(CSVRecord record1, CSVRecord record2) {
        if (record1 == null || Double.parseDouble(record1.get("TemperatureF")) == -9999) {
            return record2;
        }
        if (record2 == null || Double.parseDouble(record2.get("TemperatureF")) == -9999) {
            return record1;
        }

        if (Double.parseDouble(record1.get("TemperatureF")) <= Double.parseDouble(record2.get("TemperatureF")) ) {
            return record1;
        } else {
            return record2;
        }          
    }
        
    public CSVRecord getColdestRecord(CSVParser parser) {
        CSVRecord minTempRecord = null;
        for (CSVRecord record : parser) {
              minTempRecord = getColdestRecord(minTempRecord, record);
        }
        return minTempRecord;
    }
    
    public File getColdestFile() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord minTempRecord = null;
        File minTempFile = null;
        try {
            for (File f : dr.selectedFiles()) {
                CSVParser parser =  new CSVParser(new FileReader(f), CSVFormat.EXCEL.withHeader());
                CSVRecord record = getColdestRecord(parser);
                minTempRecord = getColdestRecord(minTempRecord, record);
                if (minTempRecord == record) {
                    minTempFile = f;
                }
            }  
        } catch (Exception e) {
        }
        return minTempFile;
    }
    

    public CSVRecord getLowestHumidityRecord(CSVRecord record1, CSVRecord record2) {
        if (record1 == null || Integer.parseInt(record1.get("Humidity")) == -9999) {
            return record2;
        }
        if (record2 == null || Integer.parseInt(record2.get("Humidity")) == -9999) {
            return record1;
        }

        if (Integer.parseInt(record1.get("Humidity")) <= Integer.parseInt(record2.get("Humidity")) ) {
            return record1;
        } else {
            return record2;
        }          
    }
        
    public CSVRecord getLowestHumidityRecord(CSVParser parser) {
        CSVRecord lowestHumidityRecord = null;
        for (CSVRecord record : parser) {
              lowestHumidityRecord = getLowestHumidityRecord(lowestHumidityRecord, record);
        }
        return lowestHumidityRecord;
    }
    
    public CSVRecord getLowestHumidityRecord() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestHumidityRecord = null;
        try {
            for (File f : dr.selectedFiles()) {
                CSVParser parser =  CSVParser.parse(f, Charset.defaultCharset(), CSVFormat.EXCEL.withHeader());
                CSVRecord record = getLowestHumidityRecord(parser);
                lowestHumidityRecord = getLowestHumidityRecord(lowestHumidityRecord, record);
                
            }  
        } catch (Exception e) {
        }
        return lowestHumidityRecord;
    }
    
    public double getAverageTemperature(CSVParser parser) {
        int counter = 0;
        double sumTemperature = 0; 
        for (CSVRecord record : parser) {
            sumTemperature += Double.parseDouble(record.get("TemperatureF"));
            counter++;
        }
        return sumTemperature / counter;
    }

    public double getAverageTemperatureWithHighHumidity(CSVParser parser, int value) {
        int counter = 0;
        double sumTemperature = 0; 
        for (CSVRecord record : parser) {
            if (Integer.parseInt(record.get("Humidity")) > value) {
                sumTemperature += Double.parseDouble(record.get("TemperatureF"));
                counter++;
            }
        }
        
        if (counter != 0) { 
            return sumTemperature / counter;
        } else { 
            return -9999;
        }
    }


    public static void main(String[] args) {
        Part1 p1 = new Part1();
        // p1.testGetColdestRecordFromParser("../nc_weather/2014/weather-2014-05-01.csv");
        // p1.testGetColdestFile();
        // p1.testGetLowestHumidityRecordFromParser("../nc_weather/2014/weather-2014-04-01.csv");
        // p1.testGetLowestHumidityRecordFromDR();
        // p1.testGetAverageTemperatureFromParser("../nc_weather/2014/weather-2014-06-01.csv");
        p1.testGetAverageTemperatureWithHighHumidityFromParser("../nc_weather/2014/weather-2014-03-30.csv");
    }
    
    
    public void testGetColdestRecordFromParser(String filename) {
        FileResource fr = new FileResource(filename);
        CSVRecord minTempRecord = getColdestRecord(fr.getCSVParser());
        System.out.println(minTempRecord);
    }
    
    public void testGetColdestFile() {
        try {
            File coldestFile = getColdestFile();
            CSVParser coldestFileParser =  CSVParser.parse(coldestFile, Charset.defaultCharset(), CSVFormat.EXCEL.withHeader());
            CSVRecord coldestRecord = getColdestRecord(coldestFileParser);
            double coldestTemp = Double.parseDouble(coldestRecord.get("TemperatureF"));     
            
            System.out.println("Coldest day was in file: " + coldestFile.getName()); 
            System.out.println("Coldest temperature on that day was: " + coldestTemp);  
            System.out.println("All the temperatures on the coldest day were:");
            coldestFileParser =  CSVParser.parse(coldestFile, Charset.defaultCharset(), CSVFormat.EXCEL.withHeader());
            for (CSVRecord record : coldestFileParser) {
                System.out.println(record.get("DateUTC") + ": " + record.get("TemperatureF"));
            } 
        } catch(Exception e) {}
    }

    public void testGetLowestHumidityRecordFromParser(String filename) {
        FileResource fr = new FileResource(filename);
        CSVRecord lowestHumidityRecord = getLowestHumidityRecord(fr.getCSVParser());
        System.out.println("Lowest Humidity was " + lowestHumidityRecord.get("Humidity") + 
            " at " + lowestHumidityRecord.get("DateUTC"));
    }
    
    public void testGetLowestHumidityRecordFromDR() {
        CSVRecord lowestHumidityRecord = getLowestHumidityRecord();
        System.out.println("Lowest Humidity was " + lowestHumidityRecord.get("Humidity") + 
            " at " + lowestHumidityRecord.get("DateUTC"));
    }
    
    public void testGetAverageTemperatureFromParser(String filename) {
        FileResource fr = new FileResource(filename);
        double averageTemperature = getAverageTemperature(fr.getCSVParser());
        System.out.println("Average temperature in file is " + averageTemperature);
    }
    
    public void testGetAverageTemperatureWithHighHumidityFromParser(String filename) {
        FileResource fr = new FileResource(filename);
        double averageTemperature = getAverageTemperatureWithHighHumidity(fr.getCSVParser(), 80);
        if (averageTemperature != -9999) {
            System.out.println("Average temperature in file is " + averageTemperature);
        } else {
            System.out.println("No temperatures with that humidity");
        }
    }
    
    
}
