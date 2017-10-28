package org.wahlzeit.model;

public class Location {
    private Coordinate coordinate;

    public Location () {
        coordinate = new Coordinate();
    }

    public Location (double x, double y, double z) {
        coordinate = new Coordinate(x, y, z);
    }

    public Location (Coordinate cord) {
        coordinate = cord;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public double getDistance (Location loc){
        return coordinate.getDistance(loc.getCoordinate());
    }

    public double getDistance (Coordinate cord){
        return coordinate.getDistance(cord);
    }

    public boolean isEqual(Location other) {
        if (other == null) {
            return false;
        }
        if (this.coordinate == null) {
            return other.getCoordinate() == null;
        }
        if (other.getCoordinate() == null){
            return false;
        }
        return coordinate.isEqual(other.getCoordinate());
    }

    @Override
    public boolean equals (Object obj){
        if (obj == null){
            return false;
        }
        if (obj instanceof Location){
            return isEqual((Location) obj);
        }
        return false;
    }
}
