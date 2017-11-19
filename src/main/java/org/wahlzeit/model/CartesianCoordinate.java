package org.wahlzeit.model;

public class CartesianCoordinate implements Coordinate{
    private double x, y, z;

    public CartesianCoordinate(){
        x = 0;
        y = 0;
        z = 0;
    }

    public CartesianCoordinate(double x, double y, double z){
        if(Double.isNaN(x)||Double.isNaN(y)||Double.isNaN(z)){
            throw new IllegalArgumentException("Value of coordinate must not be NaN");
        }

        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        if(Double.isNaN(x)){
            throw new IllegalArgumentException ();
        }
        this.x = x;
    }

    public void setY(double y) {
        if(Double.isNaN(z)){
            throw new IllegalArgumentException ();
        }
        this.y = y;
    }

    public void setZ(double z) {
        if(Double.isNaN(z)){
            throw new IllegalArgumentException ();
        }
        this.z = z;
    }

    /**
     * Set some values; NaN if current value ought to be kept
     * @param x new value for x; NaN is current value ought to be kept
     * @param y new value for y; NaN is current value ought to be kept
     * @param z new value for z; NaN is current value ought to be kept
     */
    public void setSome(double x, double y, double z){
        if(!Double.isNaN(x)){
            this.x = x;
        }
        if(!Double.isNaN(y)){
            this.y = y;
        }
        if(!Double.isNaN(z)){
            this.z = z;
        }
    }

    public double getDistance (Coordinate coordinate){
        return getCartesianDistance(coordinate);
    }

    public double getCartesianDistance(Coordinate coordinate){
        if(coordinate == null){
            return Double.NaN;
        }
        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();

        if(this.isEqual(cartesianCoordinate)){
            return 0;
        }
        return Math.sqrt(Math.pow(this.x-cartesianCoordinate.x, 2) +
                         Math.pow(this.y-cartesianCoordinate.y, 2) +
                         Math.pow(this.z-cartesianCoordinate.z, 2));
    }

    public boolean isEqual (Coordinate coordinate){
        if(coordinate == null){
            return false;
        }

        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();

        if(this.x != cartesianCoordinate.x){
            return false;
        }
        if(this.y != cartesianCoordinate.y){
            return false;
        }
        return this.z == cartesianCoordinate.z;
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

    public SphericCoordinate asSphericCoordinate (){
        //https://en.wikipedia.org/wiki/Spherical_coordinate_system#Cartesian_coordinates
        double radius = getCartesianDistance(new CartesianCoordinate());
        double latitude = Math.acos(z/radius);
        double longitude = Math.atan(y/x);
        return new SphericCoordinate(latitude, longitude, radius);
    }

    public CartesianCoordinate asCartesianCoordinate (){
        return this;
    }

    public double getSphericDistance (Coordinate coordinate){
        return coordinate.asSphericCoordinate().getSphericDistance(this);
    }
}
