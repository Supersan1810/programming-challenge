package de.geo.analysis;

import de.geo.analysis.PopulationClasses.PopulationApp;
import de.geo.analysis.WheatherClasses.WheatherApp;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    private static WheatherApp wheatherApp;
    private static PopulationApp populationApp;


    public static void main(String... args) {

        //****************************************************************   Setup     ****************************************** */
        // read file paths from args
        String weatherFilePath = args[0];
        System.out.printf("Arguments: Wheather file path: %s%n", weatherFilePath);
        String populationFilePath = args[1];
        System.out.printf("Arguments: Population file path: %s%n", populationFilePath);

        // init apps
        wheatherApp = new WheatherApp();
        populationApp = new PopulationApp();
        

        //****************************************************************   Task 1     ****************************************** */
        // try to read data and compute day with minimal spread
        try{
            wheatherApp.readData(weatherFilePath);

            // compute and print day with minimal spread
            String dayWithSmallestTempSpread = wheatherApp.getMinSpreadDay();    
            System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);
        }
        catch (Exception e){
            System.out.printf(e.getMessage());
        }

        //****************************************************************   Task 2     ****************************************** */
        // try to read data and compute country with maximum density
        try{
            populationApp.readData(populationFilePath);

            // compute and print country with maximum density
            String countryWithHighestPopulationDensity = populationApp.getMaxDensityCountry();    
            System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
        }
        catch (Exception e){
            System.out.printf(e.getMessage());
        }
    }
}
