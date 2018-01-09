package org.wahlzeit.model;

import org.wahlzeit.services.BeerManager;

public class Beer {
    public BeerManager manager = BeerManager.getInstance();

    private BeerType type;
    private String brewery;

    public Beer (){
        type = BeerType.getBeerType(BeerType.Types.Default);
        brewery = "";
    }

    public Beer (BeerType.Types type, String brewery) {
        this.type = BeerType.getBeerType(type);
        this.brewery = brewery;
    }

    public String getBrewery(){
        return brewery;
    }

    public BeerType getType(){
        return type;
    }
}
