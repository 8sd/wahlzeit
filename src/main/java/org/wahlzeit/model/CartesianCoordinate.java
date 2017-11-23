/*
 * Copyright (c) 2006-2017 by Sebastian Duda, https://meinewebsite.org
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate{
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

    @Override
    public boolean isEqual (Coordinate coordinate){
        if(coordinate == null){
            return false;
        }

        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();

        if(Double.compare(this.x, cartesianCoordinate.x) != 0){
            return false;
        }
        if(Double.compare(this.y, cartesianCoordinate.y) != 0){
            return false;
        }
        return Double.compare(this.z, cartesianCoordinate.z) == 0;
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

    @Override
    public SphericCoordinate asSphericCoordinate (){
        //https://en.wikipedia.org/wiki/Spherical_coordinate_system#Cartesian_coordinates
        double radius = getCartesianDistance(zero);
        double latitude = 0;
        double longitude = 0;
        if (Double.compare(radius, 0) != 0){
            latitude = Math.acos(z/radius);
            longitude = Math.atan(y/x);
        }

        return new SphericCoordinate(latitude, longitude, radius);
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate (){
        return this;
    }

    @Override
    public double getCartesianDistance (Coordinate coordinate){
        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();
        return Math.sqrt(Math.pow(x - cartesianCoordinate.x, 2) +
                        Math.pow(y - cartesianCoordinate.y, 2) +
                        Math.pow(z - cartesianCoordinate.z, 2));
    }
}
