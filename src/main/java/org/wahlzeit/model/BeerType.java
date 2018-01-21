package org.wahlzeit.model;

import org.wahlzeit.others.EntityManagement;
import org.wahlzeit.services.BeerManager;

public class BeerType {
    public static BeerManager manager = BeerManager.getInstance();

    private static final EntityManagement<BeerType> entityManagement = new EntityManagement<>();

    public final String type;

    private BeerType (String type){
        assertStringIsValidBeerType(type);
        this.type = type;
    }

    public static BeerType getBeerType(String type){
        assertStringIsValidBeerType(type); //always true ensured by constructor
        return entityManagement.getEntitiy(new BeerType(type));
    }

    public boolean isSubtype (Object obj){
        return false;   //there is no hierarchical structure of beer types → always false
    }

    public static void assertStringIsValidBeerType (String type){
        assert type != null;
        assert type != "";
    }

    public String getType() {
        return type;
    }
}
