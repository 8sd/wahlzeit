package org.wahlzeit.model;

import com.google.appengine.api.datastore.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Parent;
import com.googlecode.objectify.annotation.Subclass;
import org.wahlzeit.others.Helpers;
import org.wahlzeit.services.BeerManager;
import org.wahlzeit.services.DataObject;
import org.wahlzeit.services.ObjectManager;

@Entity
public class Beer extends DataObject {
    public static BeerManager manager = BeerManager.getInstance();

    private BeerType type;
    private String brewery;

    @Id
    long id;
    @Parent
    Key parent = ObjectManager.applicationRootKey;

    //default constructor not required here, handled by BeerManager

    public Beer (BeerType type, String brewery) {
        Helpers.printNfo("Type: " + type.getType() + "; Brewery: " + brewery);

        this.type = type;
        this.brewery = brewery;
    }

    public String getBrewery (){
        return brewery;
    }

    public void setBrewery (String brewery) {
        this.brewery = brewery;
    }

    public BeerType getType (){
        return type;
    }

    public void setType(BeerType type) {
        this.type = type;
    }

    //one might use the composite pattern for an type object, all types of beers in this domain have the same
    //hierarchical level, as a result we omit the pattern here
}
