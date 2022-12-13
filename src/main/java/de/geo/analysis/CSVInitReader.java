package de.geo.analysis;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import de.geo.analysis.Interfaces.CSVToObj;

public abstract class CSVInitReader{
    
    // idea from https://www.geeksforgeeks.org/reading-csv-file-java-using-opencsv/
    public static void readAndInit(String filepath, CSVToObj csvToObj, boolean skipFirstLine) throws IOException{
        System.out.printf("Reading data from: %s%n", filepath);

        // read data with CSV reader
        try {
        
            // Create an object of filereader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(filepath);
            
        
            // create csvReader object passing
            // file reader as a parameter
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
        
            // we are going to read data line by line
            boolean firstLine = true;
            while ((nextRecord = csvReader.readNext()) != null) {

                // some csv files contain header line, then it needs to be skipped
                if (skipFirstLine & firstLine){
                    firstLine = false;
                }
                else{
                    // init object in interface implementation, further handling of object there
                    csvToObj.lineToObject(nextRecord);
                }
                
                
            }
            csvReader.close();
        }
        catch (Exception e) {
            if (e instanceof FileNotFoundException){
                throw new FileNotFoundException("Input file not found!");
            }
            else{
                throw new IOException("Error while reading file!");
            }
        }
        System.out.printf("Reading data completed\n");
        
    }
}
