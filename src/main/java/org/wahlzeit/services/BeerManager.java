package org.wahlzeit.services;


import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Work;
import org.wahlzeit.model.Beer;
import org.wahlzeit.model.BeerType;
import org.wahlzeit.model.PhotoManager;

import java.util.*;
import java.util.logging.Logger;

/*This class is mainly inspired by https://github.com/BS88/wahlzeit/compare/adap-cw11...adap-cw12*/
public class BeerManager extends ObjectManager{
    private static final BeerManager instance = new BeerManager ();
    private static final Logger log = Logger.getLogger(BeerManager.class.getName());

    private final Map<Integer, Beer> beers = new HashMap<>();
    private final Map<String, BeerType> beerTypes = new HashMap<>();

    private static Beer defaultBeer = new Beer (BeerType.getBeerType("default"), "default");

    public BeerManager() {
        super ();
    }

    public static BeerManager getInstance() {
        return instance;
    }

    public Beer getBeer (){
        return getBeer("", "");
    }

    public Beer getBeer (String type, String brewery){
        return getBeer(getBeerType(type), brewery);
    }

    public Beer getBeer (BeerType type, String brewery){
        if (type == null && brewery == null){
            return defaultBeer;
        }

        BeerType tmpType;
        if (type == null) {
            tmpType = getBeerType("default");
        } else {
            tmpType = type;
        }

        if (brewery == null || brewery == ""){
            brewery = "default";
        }

        int hash = tmpType.getType().hashCode()/2 + brewery.hashCode()/2;
        if (beers.containsKey(hash)) {
            return beers.get(hash);
        }

        Beer newBeer = new Beer (tmpType, brewery);
        addBeerToMap(newBeer);
        return newBeer;
    }

    public BeerType getBeerType (String type){
        assert type != null;

        if (type.isEmpty()){
            type = "default";
        }

        if (beerTypes.containsKey(type)){
            return beerTypes.get(type);
        }

        BeerType tmpType = BeerType.getBeerType(type);
        addBeerTypeToMap(tmpType);
        return tmpType;
    }

    public void init (){
        loadBeers();
        loadBeerTypes();
    }

    public void loadBeers() {
        ObjectifyService.run(new Work<Void>() {
            @Override
            public Void run() {
                Collection<Beer> existingBeers = new ArrayList<>();
                readObjects(existingBeers, Beer.class);

                for (Beer beer : existingBeers) {
                    addBeerToMap(beer);
                    log.config(LogBuilder.createSystemMessage().addParameter("Beer has been loaded",
                            beer.getClass()).toString());
                }

                return null;
            }
        });
        log.info(LogBuilder.createSystemMessage().addMessage("loaded all stored Types").toString());
    }

    private void addBeerToMap (Beer beer){
        int hash = beer.getType().hashCode()/2 + beer.getBrewery().hashCode()/2;
        beers.put(hash, beer);
    //    super.writeObject(beer);
    }

    public void loadBeerTypes() {
        ObjectifyService.run(new Work<Void>() {
            @Override
            public Void run() {
                Collection<BeerType> existingBeerTypes = new ArrayList<>();
                readObjects(existingBeerTypes, BeerType.class);

                for (BeerType beerType : existingBeerTypes) {
                    addBeerTypeToMap(beerType);
                    log.config(LogBuilder.createSystemMessage().addParameter("BeerType has been loaded",
                            beerType.getClass()).toString());
                }

                return null;
            }
        });
        log.info(LogBuilder.createSystemMessage().addMessage("loaded all stored Types").toString());
    }

    private void addBeerTypeToMap (BeerType beerType){
        beerTypes.put(beerType.getType(), beerType);
    //    super.writeObject(beerType);
    }

    public void saveBeers (){
    //    updateObjects(beers.values());
    }

    public void saveBeerTypes (){
    //    updateObjects(beerTypes.values());
    }
}
