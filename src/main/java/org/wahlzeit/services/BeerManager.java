package org.wahlzeit.services;


import org.wahlzeit.model.PhotoManager;

public class BeerManager extends ObjectManager{
    private static final BeerManager instance = new BeerManager ();

    public BeerManager() {
    }

    public static BeerManager getInstance() {
        return instance;
    }

}
