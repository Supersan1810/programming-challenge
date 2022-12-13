package de.geo.analysis;

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


    public static void main(String... args) {

        // read file paths from args
        String weatherFilePath = args[0];
        System.out.printf("Arguments: Wheather file path: %s%n", args[0]);

        // init other apps
        wheatherApp= new WheatherApp();
        
        // try to read data and compute minimal spread
        try{
            wheatherApp.readData(weatherFilePath);

            // compute and print day with minimal spread
            String dayWithSmallestTempSpread = wheatherApp.getMinSpreadDay();    
            System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);
        }
        catch (Exception e){
            System.out.printf(e.getMessage());
        }

        

        //String countryWithHighestPopulationDensity = "Some country"; // Your population density analysis function call …
        //System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);

    }
}
