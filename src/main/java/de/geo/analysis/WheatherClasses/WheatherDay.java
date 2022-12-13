package de.geo.analysis.WheatherClasses;

public class WheatherDay {
    private String date;
    private float maxTemp;
    private float minTemp;
    private float spread;

    public WheatherDay(String date, float maxTemp, float minTemp){
        this.date = date;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.spread = maxTemp-minTemp;
    }
    
    public float getSpread(){
        return spread;
    }

    public String getDate(){
        return date;
    }
}
