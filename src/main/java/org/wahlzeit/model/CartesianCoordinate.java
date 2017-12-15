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

import org.wahlzeit.others.EntityManagement;

import static org.wahlzeit.others.Helpers.compareDouble;
import static org.wahlzeit.others.Helpers.isFinite;

public class CartesianCoordinate extends AbstractCoordinate{
    private static final EntityManagement<Coordinate> entityManagement = new EntityManagement<>();

    private final double x, y, z;

    private CartesianCoordinate(double x, double y, double z){
        assert isFinite(x); //it might be valid to accept +-infinite
        assert isFinite(y);
        assert isFinite(z);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static CartesianCoordinate getCartesianCoordinate(){
        return entityManagement.getEntitiy(new CartesianCoordinate(0,0,0)).asCartesianCoordinate();
    }

    public static CartesianCoordinate getCartesianCoordinate(double x, double y, double z){
        return entityManagement.getEntitiy(new CartesianCoordinate(x,y,z)).asCartesianCoordinate();
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

    public CartesianCoordinate setX(double x) {
        return getCartesianCoordinate(x,y,z);
    }

    public CartesianCoordinate setY(double y) {
        return getCartesianCoordinate(x,y,z);
    }

    public CartesianCoordinate setZ(double z) {
        return getCartesianCoordinate(x,y,z);
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
    public SphericCoordinate asSphericCoordinate (){
        assertClassInvariants();
        double radius = getCartesianDistance(CartesianCoordinate.getCartesianCoordinate());
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

        return SphericCoordinate.getSphericCoordinate(latitude, longitude, radius);
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate (){
        assertClassInvariants ();
        return this;
    }

    public double getCartesianDistance (Coordinate coordinate){
        assert coordinate != null;
        assertClassInvariants ();
        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();
        /*validity is ensured here; Math.sqrt(…) never fails*/
        return Math.sqrt(Math.pow(x - cartesianCoordinate.x, 2) +
                        Math.pow(y - cartesianCoordinate.y, 2) +
                        Math.pow(z - cartesianCoordinate.z, 2));
    }

    public double getSphericDistance (Coordinate coordinate) throws ArithmeticException {
        return this.asSphericCoordinate().getSphericDistance(coordinate);

    }

    @Override
    protected void assertClassInvariants (){
        /*check whether all values are valid*/
        assert isFinite(x);
        assert isFinite(y);
        assert isFinite(z);

        /*there are no requirements for the range of the values*/
    }

    protected int doHashCode() {
        int result = 0xdeadbeef;
        result = 37 * result + (int) (Double.doubleToLongBits(x) ^ (Double.doubleToLongBits(x) >>> 32));
        result = 37 * result + (int) (Double.doubleToLongBits(y) ^ (Double.doubleToLongBits(y) >>> 32));
        result = 37 * result + (int) (Double.doubleToLongBits(z) ^ (Double.doubleToLongBits(z) >>> 32));
        return result;
    }
}
