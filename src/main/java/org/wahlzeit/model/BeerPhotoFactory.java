package org.wahlzeit.model;

import org.wahlzeit.services.LogBuilder;

import java.util.logging.Logger;

public class BeerPhotoFactory extends PhotoFactory {
    private static final Logger log = Logger.getLogger(BeerPhotoFactory.class.getName());
    private static BeerPhotoFactory instance = null;

    protected BeerPhotoFactory (){

    }

    public static void initialize (){
        getInstance();
    }

    /**
     * Public singleton access method.
     */
    public static synchronized BeerPhotoFactory getInstance() {
        if (instance == null) {
            log.config(LogBuilder.createSystemMessage().addAction("setting generic PhotoFactory").toString());
            setInstance(new BeerPhotoFactory());
        }

        return instance;
    }

    /**
     * @methodtype factory
     */
    public Photo createPhoto(String brewery) {
        return new BeerPhoto(brewery);
    }

    /**
     * Creates a new photo with the specified id
     */
    public Photo createPhoto(PhotoId id, String brewery) {
        return new BeerPhoto(id, brewery);
    }
}
