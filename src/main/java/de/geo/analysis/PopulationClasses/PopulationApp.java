package de.geo.analysis.PopulationClasses;


import java.util.ArrayList;
import de.geo.analysis.CSVInitReader;
import de.geo.analysis.ThirdPartyApp;

public class PopulationApp extends ThirdPartyApp {
    ArrayList<Country> countries;

    public PopulationApp(){
        countries = new ArrayList<Country>();
    }

    public void readData(String filepath) throws Exception{
        // read data with CSV reader
        CSVInitReader.readAndInit(filepath, this, 1,';');
        System.out.printf("Population data loaded\n");
    }

    public String getMaxDensityCountry() throws Exception{
        if (countries.size() == 0){
            throw new Exception("No population data given!");
        }
        Country maxDensityCountry = countries.get(0);
        float maxDensity = maxDensityCountry.getDensity();
        
        for(Country country: countries){
            float densitiy = country.getDensity();
            if (densitiy>maxDensity){
                maxDensityCountry=country;
                maxDensity = densitiy;
            }
        }

        return maxDensityCountry.getName();
    }

    public int getCountryAmt(){
        return countries.size();
    }

    // implementation of Readable interface
    @Override
    public void lineToObject(String[] data) {
        try{
            // init wheather day object from String array
            String name = data[0];
            int population = Integer.parseInt(data[3]);
            float area = Float.parseFloat(data[4]);
            Country country = new Country(name, population, area);

            // add object to arraylist
            countries.add(country);
        }
        catch (Exception e){
            System.out.println("Error while reading in line!");
        }
    }

    

}
