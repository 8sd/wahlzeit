package org.wahlzeit.model;

import java.util.logging.Logger;

public class BeerPhotoManager extends PhotoManager {
    private static final Logger log = Logger.getLogger(BeerPhotoManager.class.getName());


    public BeerPhotoManager() {
        super ();
    }

    public static BeerPhotoManager getInstance() {
        return instance;
    }
}
