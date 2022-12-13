package de.geo.analysis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.geo.analysis.WheatherClasses.WheatherApp;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit 5 test case.
 */
class WeatherAppTest {

    WheatherApp wheatherApp;

    @BeforeEach
    void setUp() {
        wheatherApp= new WheatherApp();
    }

    @Test
    void normalFileTest() {
        
        String weatherFilePath = "src\\main\\resources\\de\\geo\\analysis\\weather.csv";
        
        String dayWithSmallestTempSpread = "";
        // try to read data and compute day with minimal spread
        try{
            wheatherApp.readData(weatherFilePath);

            // compute and print day with minimal spread
            dayWithSmallestTempSpread = wheatherApp.getMinSpreadDay();    
        }
        catch (Exception e){
            System.out.printf(e.getMessage());
        }
        assertEquals("14", dayWithSmallestTempSpread, "Min Spread day not computed correctly");
    }

    @Test
    void missingFileTest() {
        
        String weatherFilePath = "src\\main\\resources\\de\\geo\\analysis\\weatherabc.csv";
        
        // try to read data and compute day with minimal spread
        try{
            wheatherApp.readData(weatherFilePath);   
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
        
        String weatherFilePath = "src\\main\\resources\\de\\geo\\analysis\\weather_empty.csv";
        
        // try to read data and compute day with minimal spread
        try{
            wheatherApp.readData(weatherFilePath);   
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
        
        String weatherFilePath = "src\\main\\resources\\de\\geo\\analysis\\weather_empty_line.csv";
        
        String dayWithSmallestTempSpread = "";
        // try to read data and compute day with minimal spread
        try{
            wheatherApp.readData(weatherFilePath);

            // compute and print day with minimal spread
            dayWithSmallestTempSpread = wheatherApp.getMinSpreadDay();    
        }
        catch (Exception e){
            System.out.printf(e.getMessage());
        }
        assertEquals("14", dayWithSmallestTempSpread, "Min spread day not correctly computed if empty line in input file");
    }

    @Test
    void ErrorLineSameSpreadTest() {
        
        String weatherFilePath = "src\\main\\resources\\de\\geo\\analysis\\weather_error_line.csv";
        
        String dayWithSmallestTempSpread = "";
        // try to read data and compute day with minimal spread
        try{
            wheatherApp.readData(weatherFilePath);

            // compute and print day with minimal spread
            dayWithSmallestTempSpread = wheatherApp.getMinSpreadDay();    
        }
        catch (Exception e){
            System.out.printf(e.getMessage());
        }
        assertEquals("14", dayWithSmallestTempSpread, "Min spread day not correctly computed if empty line in input file");
    }

    @Test
    void DataLoadedTest() {
        
        String weatherFilePath = "src\\main\\resources\\de\\geo\\analysis\\weather.csv";
        
        // try to read data and compute day with minimal spread
        try{
            wheatherApp.readData(weatherFilePath);
            int daysAmt = wheatherApp.getWheaterDayAmt(); 
            assertEquals(30, daysAmt, "Not all data loaded");   
        }
        catch (Exception e){
            System.out.printf(e.getMessage());
        }
        
    }

    @Test
    void emptyFileNoDataLoadedTest() {
        
        String weatherFilePath = "src\\main\\resources\\de\\geo\\analysis\\weather_empty.csv";

        // try to read data and compute day with minimal spread
        try{
            wheatherApp.readData(weatherFilePath);
            int daysAmt = wheatherApp.getWheaterDayAmt(); 
            assertEquals(0, daysAmt, "Data was loaded although file empty");   
        }
        catch (Exception e){
            System.out.printf(e.getMessage());
        }
    }

    @Test
    void emptyLineDataLoadedTest() {
        
        String weatherFilePath = "src\\main\\resources\\de\\geo\\analysis\\weather_empty_line.csv";
        
        // try to read data and compute day with minimal spread
        try{
            wheatherApp.readData(weatherFilePath);
            int daysAmt = wheatherApp.getWheaterDayAmt(); 
            assertEquals(29, daysAmt, "Expected number of days not correct if empty line in input file");   
        }
        catch (Exception e){
            System.out.printf(e.getMessage());
        }
    }

    @Test
    void ErrorLineDataLoadedTest() {
        
        String weatherFilePath = "src\\main\\resources\\de\\geo\\analysis\\weather_error_line.csv";
        
        // try to read data and compute day with minimal spread
        try{
            wheatherApp.readData(weatherFilePath);
            int daysAmt = wheatherApp.getWheaterDayAmt(); 
            assertEquals(29, daysAmt, "Expected number of days not correct if error line in input file");   
        }
        catch (Exception e){
            System.out.printf(e.getMessage());
        }
    }

}