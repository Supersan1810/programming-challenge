package de.geo.analysis;

import de.geo.analysis.Interfaces.CSVToObj;

public abstract class ThirdPartyApp implements CSVToObj{
    public abstract void readData(String file) throws Exception;
}
