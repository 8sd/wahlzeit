package org.wahlzeit.model;

public class Coordinate {
    private double x, y, z;

    public Coordinate (){
        x = 0;
        y = 0;
        z = 0;
    }

    public Coordinate (double x, double y, double z){
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

    public double getDistance(Coordinate other){
        if(other == null){
            return Double.NaN;
        }
        if(this.isEqual(other)){
            return 0;
        }
        return Math.sqrt(Math.pow(this.x-other.x, 2)+Math.pow(this.y-other.y, 2)+Math.pow(this.z-other.z, 2));
    }

    public boolean isEqual (Coordinate other){
        if(other == null){
            return false;
        }
        if(this.x != other.x){
            return false;
        }
        if(this.y != other.y){
            return false;
        }
        return this.z == other.z;
    }

    @Override
    public boolean equals (Object obj) {
        if (obj == null){
            return false;
        }
        if (obj instanceof Coordinate){
            return isEqual((Coordinate) obj);
        }
        return false;
    }
}
