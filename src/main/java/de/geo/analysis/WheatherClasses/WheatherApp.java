package de.geo.analysis.WheatherClasses;


import java.io.IOException;
import java.util.ArrayList;
import de.geo.analysis.CSVInitReader;
import de.geo.analysis.Interfaces.CSVToObj;

public class WheatherApp implements CSVToObj {
    ArrayList<WheatherDay> days;

    public WheatherApp(){
        days = new ArrayList<WheatherDay>();
    }

    public void readData(String filepath)throws IOException{
        // read data with CSV reader
        CSVInitReader.readAndInit(filepath, this, true);
        System.out.printf("Wheater data loaded\n");
    }

    public String getMinSpreadDay() throws Exception{
        if (days.size() == 0){
            throw new Exception("No wheather data given!");
        }
        WheatherDay minSpreadDay = days.get(0);
        float minSpread = minSpreadDay.getSpread();
        
        for(WheatherDay day: days){
            float spread = day.getSpread();
            if (spread<minSpread){
                minSpreadDay=day;
                minSpread = spread;
            }
        }

        return minSpreadDay.getDate();
    }

    public int getWheaterDayAmt(){
        return days.size();
    }

    // implementation of Readable interface
    @Override
    public void lineToObject(String[] data) {
        try{
        // init wheather day object from String array
        String date = data[0];
        float maxTemp = Float.parseFloat(data[1]);
        float minTemp = Float.parseFloat(data[2]);
        WheatherDay day = new WheatherDay(date, maxTemp, minTemp);

        // add object to arraylist
        days.add(day);
        }
        catch (Exception e){
            System.out.println("Error while reading in line!");
        }
    }

    

}
