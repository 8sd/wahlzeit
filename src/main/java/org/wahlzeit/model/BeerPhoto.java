package org.wahlzeit.model;

public class BeerPhoto extends Photo {
    private String brewery = "";

/*    public BeerPhoto (){
        super();
    }
*/
    public BeerPhoto (String brewery){
        super();
        this.brewery = brewery;
    }

/*    public BeerPhoto (PhotoId id) {
        super(id);
    }
*/
    public BeerPhoto (PhotoId id, String brewery){
        super(id);
        this.brewery = brewery;
    }

    public String getBrewery() {
        return brewery;
    }
}
