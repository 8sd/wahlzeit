package org.wahlzeit.services;


import org.wahlzeit.model.Beer;
import org.wahlzeit.model.BeerType;
import org.wahlzeit.model.PhotoManager;

import java.util.HashMap;
import java.util.Map;

public class BeerManager extends ObjectManager{
    private static final BeerManager instance = new BeerManager ();

    private Map<Integer, Beer> beers = new HashMap<>();
    private static Beer defaultBeer = new Beer (BeerType.getBeerType("default"), "default");

    public BeerManager() {
    }

    public static BeerManager getInstance() {
        return instance;
    }

    public Beer getBeer (){
        return getBeer(null, null);
    }

    public Beer getBeer(String type, String brewery){
        if (type == null && brewery == null){
            return defaultBeer;
        }

        BeerType tmpType;
        if (type == null || type == "") {
            tmpType = BeerType.getBeerType("default");
        } else {
            tmpType = BeerType.getBeerType(type);
        }

        if (brewery == null || brewery == ""){
            brewery = "default";
        }

        int hash = tmpType.getType().hashCode()/2 + brewery.hashCode()/2;
        if (beers.containsKey(hash)) {
            return beers.get(hash);
        }

        Beer newBeer = new Beer (tmpType, brewery);
        beers.put(hash, newBeer);
        return newBeer;
    }
}
