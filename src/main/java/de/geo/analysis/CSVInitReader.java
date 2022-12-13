package de.geo.analysis;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.CSVParser;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVParserBuilder;

import de.geo.analysis.Interfaces.CSVToObj;

public abstract class CSVInitReader{
    
    // idea from https://www.geeksforgeeks.org/reading-csv-file-java-using-opencsv/, 
    // extended with documentation from von https://opencsv.sourceforge.net/apidocs/
    public static void readAndInit(String filepath, CSVToObj csvToObj, int skipLines, char separator) throws IOException{
        System.out.printf("Reading data from: %s%n", filepath);

        // read data with CSV reader
        try {
            // create parser with chosen seperator, add to reader
            final CSVParser parser =
                new CSVParserBuilder()
                    .withSeparator(separator)
                    .build();
            final CSVReader csvReader =
                new CSVReaderBuilder(new FileReader(filepath))
                    .withCSVParser(parser)
                    .withSkipLines(skipLines)       // skip header lines 
                    .build();

            String[] nextRecord;
        
            //read data line by line
            while ((nextRecord = csvReader.readNext()) != null) {
                // init object in interface implementation, further handling of object there
                csvToObj.lineToObject(nextRecord);             
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
