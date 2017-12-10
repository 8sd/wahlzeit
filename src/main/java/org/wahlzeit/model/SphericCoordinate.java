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

import static org.wahlzeit.others.Helpers.*;

public class SphericCoordinate extends AbstractCoordinate{
    public static final double pihalf = Math.PI/2;
    public static final double twopi = Math.PI*2;

    private double latitude;
    private double longitude;
    private double radius;

    public SphericCoordinate(){
        /*default behavior is ensuring the invariance*/
    }

    public SphericCoordinate(double latitude, double longitude, double radius){
        assert radius >= 0;
        assertDoubleIsAngular(longitude);
        assertDoubleIsAngular(latitude);

        this.latitude = latitude;
        this.longitude = longitude;
        setRadius(radius); //here is the setter used, because special handling might be required
        /*postcondition (valid object) is ensured by preconditions*/
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
        assertDoubleIsAngular(latitude);
        this.latitude = latitude;
        assertClassInvariants();
    }

    public void setLongitude(double longitude) {
        assertDoubleIsAngular(longitude);
        this.longitude = longitude;
        assertClassInvariants();
    }

    public void setRadius(double radius) {
        assert radius >= 0;
        assert isFinite(radius);
        if (isDoubleZero(radius)){
            this.latitude = 0;
            this.longitude = 0;
            this.radius = 0;
        }
        this.radius = radius;
        assertClassInvariants();
    }

    @Override
    public SphericCoordinate asSphericCoordinate (){
        return this;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate (){
        double x = radius * Math.sin(latitude) * Math.cos(longitude);
        double y = radius * Math.sin(latitude) * Math.sin(longitude);
        double z = radius * Math.cos(latitude);
        return new CartesianCoordinate(x, y, z); //invariance ensured by constructor
    }

    @Override
    public boolean isEqual (Coordinate coordinate){
        assertClassInvariants();
        if(coordinate == null){
            return false;
        }

        SphericCoordinate sphericCoordinate = coordinate.asSphericCoordinate();

        if(isDoubleZero(sphericCoordinate.radius) &&
                isDoubleZero(radius)){
            return true;
        }
        if(!compareDouble(latitude, sphericCoordinate.latitude)){
            return false;
        }
        if(!compareDouble(longitude, sphericCoordinate.longitude)){
            return false;
        }
        return compareDouble(radius, sphericCoordinate.radius);
    }

    @Override
    public boolean equals (Object obj) {
        assertClassInvariants();
        /*Postcondition: the value true or false is returned this is ensured by the use of boolean*/
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
    protected void assertClassInvariants (){
        assert radius >= 0; //not negative
        assertDoubleIsAngular(longitude);
        assertDoubleIsAngular(latitude);

        /*radius == 0 → latitude == 0 && longitude == 0*/
        if (isDoubleZero(radius)){
            assert isDoubleZero(latitude);
            assert isDoubleZero(longitude);
        }
    }

    private void assertDoubleIsAngular (double angular){
        assert isFinite(angular);
        assert angular >= 0; //not negative
        assert angular < twopi; //360° → 0°
    }

    public double getCartesianDistance (Coordinate coordinate){
        return this.asCartesianCoordinate().getCartesianDistance(coordinate);
    }


    public double  getSphericDistance (Coordinate coordinate) throws ArithmeticException {
        assert coordinate != null;
        SphericCoordinate sphericCoordinate = coordinate.asSphericCoordinate();
        if (!compareDouble(radius, sphericCoordinate.radius)){
            throw new ArithmeticException("Radius of both coordinates have to be eaqual");
        }

        //copied from http://www.movable-type.co.uk/scripts/latlong.html
        double φ1 = latitude;
        double φ2 = sphericCoordinate.latitude;
        double Δφ = sphericCoordinate.latitude-latitude;
        double Δλ = sphericCoordinate.longitude-longitude;

        double a = Math.sin(Δφ/2) * Math.sin(Δφ/2) +
                Math.cos(φ1) * Math.cos(φ2) *
                        Math.sin(Δλ/2) * Math.sin(Δλ/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return radius * c;
    }
}
