package org.wahlzeit.model;

import org.wahlzeit.others.EntityManagement;
import org.wahlzeit.services.BeerManager;

public class BeerType {
    public enum Types {
        Default,
        Kellerbier,
        Landbier,
        Exportbier,
        Weizen,
        Dunkel,
        Pils
    }

    public BeerManager manager = BeerManager.getInstance();

    private static final EntityManagement<BeerType> entityManagement = new EntityManagement<>();

    public final Types type;

    private BeerType (Types type){
        this.type = type;
    }

    public static BeerType getBeerType(Types type){
        return entityManagement.getEntitiy(new BeerType(type));
    }

    public boolean isSubtype (Object obj){
        return obj instanceof BeerType;
    }
}
