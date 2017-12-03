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

import static org.wahlzeit.others.Helpers.compareDouble;
import static org.wahlzeit.others.Helpers.isFinite;

public class CartesianCoordinate extends AbstractCoordinate{
    private double x, y, z;

    public CartesianCoordinate(){
        /*default behavior is ensuring the invariance*/
    }

    public CartesianCoordinate(double x, double y, double z){
        assert isFinite(x);
        assert isFinite(y);
        assert isFinite(z);
        this.x = x;
        this.y = y;
        this.z = z;
        /*postcondition (valid object) is ensured by preconditions*/
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
        assert isFinite(x);
        this.x = x;
        assertClassInvariants();
    }

    public void setY(double y) {
        assert isFinite(y);
        this.y = y;
        assertClassInvariants();
    }

    public void setZ(double z) {
        assert isFinite(z);
        this.z = z;
        assertClassInvariants();
    }

    @Override
    public boolean isEqual (Coordinate coordinate){
        assertClassInvariants ();
        if(coordinate == null){
            return false;
        }

        if(this == coordinate){
            return true;
        }

        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();

        if(!compareDouble(x, cartesianCoordinate.x)){
            return false;
        }
        if(!compareDouble(y, cartesianCoordinate.y)){
            return false;
        }
        return compareDouble(z, cartesianCoordinate.z);
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
        assertClassInvariants();
        double radius = getDistance();
        double latitude = 0;
        double longitude = 0;
        if (!compareDouble(radius, 0)){
            if(compareDouble(x, 0)){
                if(compareDouble(y, 0)){
                    longitude = 0;
                } else {
                    longitude = SphericCoordinate.pihalf * (y > 0 ? 1 : -1);
                }
            } else {
                longitude = Math.atan(y / x);
            }
            latitude = Math.asin(z / radius);
        }

        return new SphericCoordinate(latitude, longitude, radius);
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate (){
        assertClassInvariants ();
        return this;
    }

    @Override
    public double getCartesianDistance (Coordinate coordinate){
        assertClassInvariants ();
        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();
        /*validity is ensured here; Math.sqrt(…) never fails*/
        return Math.sqrt(Math.pow(x - cartesianCoordinate.x, 2) +
                        Math.pow(y - cartesianCoordinate.y, 2) +
                        Math.pow(z - cartesianCoordinate.z, 2));
    }

    @Override
    protected void assertClassInvariants (){
        /*check whether all values are valid*/
        assert isFinite(x);
        assert isFinite(y);
        assert isFinite(z);

        /*there are no requirements for the range of the values*/
    }
}
