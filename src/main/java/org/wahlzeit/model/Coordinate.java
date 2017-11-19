package org.wahlzeit.model;

public interface Coordinate {
    SphericCoordinate asSphericCoordinate ();
    CartesianCoordinate asCartesianCoordinate ();

    double getDistance (Coordinate coordinate);
    double getCartesianDistance (Coordinate coordinate);
    double getSphericDistance (Coordinate coordinate);

    boolean isEqual (Coordinate coordinate);
}
