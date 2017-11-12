package org.wahlzeit.model;

import com.google.appengine.api.images.Image;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Work;
import org.wahlzeit.model.persistence.ImageStorage;
import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.services.Persistent;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Logger;

public class BeerPhotoManager extends PhotoManager {
    private static final Logger log = Logger.getLogger(BeerPhotoManager.class.getName());

    public BeerPhotoManager() {
        super ();
    }

}
