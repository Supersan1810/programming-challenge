package de.geo.analysis.PopulationClasses;

public class Country {
    private String name;
    private int population;
    private float area;
    private float density;

    public Country(String name, int population, float area){
        this.name = name;
        this.population = population;
        this.area = area;
        this.density = population/area;
    }
    
    public float getDensity(){
        return density;
    }

    public String getName(){
        return name;
    }
}
