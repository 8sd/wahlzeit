package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate{
    public abstract SphericCoordinate asSphericCoordinate ();

    public abstract CartesianCoordinate asCartesianCoordinate ();

    public double getDistance (Coordinate coordinate){
        return getCartesianDistance(coordinate);
    }

    public double getCartesianDistance (Coordinate coordinate){
        if(coordinate == null){
            return Double.NaN;
        }
        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();

        if(this.isEqual(cartesianCoordinate)){
            return 0;
        }

        return cartesianCoordinate.getCartesianDistance(this);
    }

    public double getSphericDistance (Coordinate coordinate){
        return getCartesianDistance(coordinate);
    }

    public abstract boolean isEqual (Coordinate coordinate);
}
