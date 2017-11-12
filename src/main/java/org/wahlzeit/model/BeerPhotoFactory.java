package org.wahlzeit.model;

import org.wahlzeit.services.LogBuilder;

import java.util.logging.Logger;

public class BeerPhotoFactory extends PhotoFactory {
    private static final Logger log = Logger.getLogger(BeerPhotoFactory.class.getName());

    protected BeerPhotoFactory (){

    }

    public static void initialize (){
        getInstance();
    }

    /**
     * Public singleton access method.
     */
    public static synchronized PhotoFactory getInstance() {
        if (instance == null) {
            log.config(LogBuilder.createSystemMessage().addAction("setting generic PhotoFactory").toString());
            setInstance(new BeerPhotoFactory());
        }

        return instance;
    }

    /**
     * @methodtype factory
     */
    public BeerPhoto createPhoto(String brewery) {
        return new BeerPhoto(brewery);
    }


    public BeerPhoto createPhoto() {
        return new BeerPhoto();
    }

    /**
     * Creates a new photo with the specified id
     */
    public BeerPhoto createPhoto(PhotoId id, String brewery) {
        return new BeerPhoto(id, brewery);
    }

    public BeerPhoto createPhoto(PhotoId id) {
        return new BeerPhoto(id);
    }
}
