package org.wahlzeit.model;

import org.wahlzeit.services.BeerManager;
import org.wahlzeit.services.DataObject;

public class Beer extends DataObject {
    public static BeerManager manager = BeerManager.getInstance();

    private BeerType type;
    private String brewery;

    //default constructor not required here, handled by BeerManager

    public Beer (BeerType type, String brewery) {
        this.type = type;
        this.brewery = brewery;
    }

    public String getBrewery(){
        return brewery;
    }

    public BeerType getType(){
        return type;
    }

    //one might use the composite pattern for an type object, all types of beers in this domain have the same
    //hierarchical level, as a result we omit the pattern here
}
