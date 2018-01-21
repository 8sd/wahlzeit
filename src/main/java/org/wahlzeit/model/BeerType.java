package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Subclass;
import org.wahlzeit.others.EntityManagement;
import org.wahlzeit.services.BeerManager;
import org.wahlzeit.services.DataObject;

@Subclass
public class BeerType extends DataObject {
//    public static BeerManager manager = BeerManager.getInstance();

//    private static final EntityManagement<BeerType> entityManagement = new EntityManagement<>();

    private String type;

    @Id
    long id = 1;

    private BeerType (String type){
        assertStringIsValidBeerType(type);
        this.type = type;
    }

    public static BeerType getBeerType(String type){
        assertStringIsValidBeerType(type); //always true ensured by constructor
   //     return entityManagement.getEntitiy(new BeerType(type));
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
