package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Subclass;
import org.wahlzeit.others.Helpers;
import org.wahlzeit.services.DataObject;

@Subclass
public class BeerType extends DataObject {

    private String type;

    @Id
    long id = 1;

    private BeerType (String type){
        Helpers.printNfo("Type: " + type);
        assertStringIsValidBeerType(type);
        this.type = type;
    }

    public static BeerType getBeerType(String type){
        assertStringIsValidBeerType(type); //always true ensured by constructor
        return new BeerType(type);
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

    public void setType(String type) {
        assertStringIsValidBeerType(type);
        this.type = type;
    }
}
