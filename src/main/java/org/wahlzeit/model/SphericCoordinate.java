package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate{
    private double latitude, longitude, radius;

    public SphericCoordinate(){}

    public SphericCoordinate(double latitude, double longitude, double radius){
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getRadius() {
        return radius;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public SphericCoordinate asSphericCoordinate (){
        return this;
    }

    public CartesianCoordinate asCartesianCoordinate (){
        double x = radius * Math.sin(latitude) * Math.cos(longitude);
        double y = radius * Math.sin(latitude) * Math.sin(longitude);
        double z = radius * Math.cos(latitude);
        return new CartesianCoordinate(x, y, z);
    }

    public double getDistance (Coordinate coordinate){
        if(coordinate instanceof SphericCoordinate){
            return getSphericDistance(coordinate);
        }
        return getCartesianDistance(coordinate);
    }

    public double getCartesianDistance (Coordinate coordinate){
        return coordinate.asCartesianCoordinate().getCartesianDistance(this);
    }

    /***
     * Due to the weak description of the task this function just uses the cartesian distance function
     * @param coordinate
     * @return Distance between coorinates
     */
    public double getSphericDistance (Coordinate coordinate){
        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();
        return cartesianCoordinate.getCartesianDistance(this);
    }

    public boolean isEqual (Coordinate coordinate){
        if(coordinate == null){
            return false;
        }

        SphericCoordinate sphericCoordinate = coordinate.asSphericCoordinate();

        if(Double.compare(radius, sphericCoordinate.radius) == 0 &&
                Double.compare(radius, 0) == 0){
            return true;
        }
        if(Double.compare(latitude, sphericCoordinate.getLatitude()) != 0){
            return false;
        }
        if(Double.compare(longitude, sphericCoordinate.getLongitude()) != 0){
            return false;
        }
        return Double.compare(radius, sphericCoordinate.radius) == 0;
    }

    @Override
    public boolean equals (Object obj) {
        if (obj == null){
            return false;
        }
        if (obj == this){
            return true;
        }
        if (obj instanceof Coordinate){
            return isEqual((Coordinate) obj);
        }
        return false;
    }
}
