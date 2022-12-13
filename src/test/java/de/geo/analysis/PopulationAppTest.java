package de.geo.analysis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.geo.analysis.PopulationClasses.PopulationApp;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit 5 test case.
 */
class PopulationAppTest {

    PopulationApp populationApp;

    @BeforeEach
    void setUp() {
        populationApp= new PopulationApp();
    }

    @Test
    void normalFileTest() {
        
        String populationFilePath = "src\\main\\resources\\de\\geo\\analysis\\countries.csv";
        
        String countryWithHighestPopulationDensity = "";
        // try to read data and compute country with maximum density
        try{
            populationApp.readData(populationFilePath);

            // compute and print day with minimal spread
            countryWithHighestPopulationDensity = populationApp.getMaxDensityCountry();    
        }
        catch (Exception e){
            System.out.printf(e.getMessage());
        }
        assertEquals("Malta", countryWithHighestPopulationDensity, "Min Spread day not computed correctly");
    }

    @Test
    void missingFileTest() {
        
        String populationFilePath = "src\\main\\resources\\de\\geo\\analysis\\countriesabc.csv";
        
        // try to read data and compute country with maximum density
        try{
            populationApp.readData(populationFilePath);   
        }
        catch (Exception e){
            String expectedMessage = "Input file not found!";
            String actualMessage = e.getMessage();
            assertEquals(expectedMessage, actualMessage, "Wrong excpetion for missing input file");
            System.out.printf(e.getMessage());
        }
        
    }

    @Test
    void emptyFileTest() {
        
        String populationFilePath = "src\\main\\resources\\de\\geo\\analysis\\countries_empty.csv";
        
        // try to read data and compute country with maximum density
        try{
            populationApp.readData(populationFilePath);   
        }
        catch (Exception e){
            String expectedMessage = "No wheather data given!";
            String actualMessage = e.getMessage();
            assertEquals(expectedMessage, actualMessage, "Wrong excpetion for empty input file");
            System.out.printf(e.getMessage());
        }
    }

    @Test
    void emptyLineSameSpreadTest() {
        
        String populationFilePath = "src\\main\\resources\\de\\geo\\analysis\\countries_empty_line.csv";
        
        String countryWithHighestPopulationDensity = "";
        // try to read data and compute country with maximum density
        try{
            populationApp.readData(populationFilePath);

            // compute and print day with country with maximum density
            countryWithHighestPopulationDensity = populationApp.getMaxDensityCountry();    
        }
        catch (Exception e){
            System.out.printf(e.getMessage());
        }
        assertEquals("Malta", countryWithHighestPopulationDensity, "Min spread day not correctly computed if empty line in input file");
    }

    @Test
    void ErrorLineSameSpreadTest() {
        
        String populationFilePath = "src\\main\\resources\\de\\geo\\analysis\\countries_error_line.csv";
        
        String countryWithHighestPopulationDensity = "";
        // try to read data and compute country with maximum density
        try{
            populationApp.readData(populationFilePath);

            // compute and print day with country with maximum density
            countryWithHighestPopulationDensity = populationApp.getMaxDensityCountry();    
        }
        catch (Exception e){
            System.out.printf(e.getMessage());
        }
        assertEquals("Malta", countryWithHighestPopulationDensity, "Min spread day not correctly computed if empty line in input file");
    }

    @Test
    void DataLoadedTest() {
        
        String populationFilePath = "src\\main\\resources\\de\\geo\\analysis\\countries.csv";
        
        // try to read data and compute country with maximum density
        try{
            populationApp.readData(populationFilePath);
            int daysAmt = populationApp.getCountryAmt(); 
            assertEquals(26, daysAmt, "Not all data loaded");   
        }
        catch (Exception e){
            System.out.printf(e.getMessage());
        }
        
    }

    @Test
    void emptyFileNoDataLoadedTest() {
        
        String populationFilePath = "src\\main\\resources\\de\\geo\\analysis\\countries_empty.csv";

        // try to read data and compute country with maximum density
        try{
            populationApp.readData(populationFilePath);
            int daysAmt = populationApp.getCountryAmt(); 
            assertEquals(0, daysAmt, "Data was loaded although file empty");   
        }
        catch (Exception e){
            System.out.printf(e.getMessage());
        }
    }

    @Test
    void emptyLineDataLoadedTest() {
        
        String populationFilePath = "src\\main\\resources\\de\\geo\\analysis\\countries_empty_line.csv";
        
        // try to read data and compute country with maximum density
        try{
            populationApp.readData(populationFilePath);
            int daysAmt = populationApp.getCountryAmt(); 
            assertEquals(25, daysAmt, "Expected number of days not correct if empty line in input file");   
        }
        catch (Exception e){
            System.out.printf(e.getMessage());
        }
    }

    @Test
    void ErrorLineDataLoadedTest() {
        
        String populationFilePath = "src\\main\\resources\\de\\geo\\analysis\\countries_error_line.csv";
        
        // try to read data and compute country with maximum density
        try{
            populationApp.readData(populationFilePath);
            int daysAmt = populationApp.getCountryAmt(); 
            assertEquals(25, daysAmt, "Expected number of days not correct if error line in input file");   
        }
        catch (Exception e){
            System.out.printf(e.getMessage());
        }
    }

}