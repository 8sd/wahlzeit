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
        assert latitude >= 0;
        assert latitude < twopi;
        assert longitude >= 0;
        assert longitude < twopi;
        assert isFinite(radius);
        assert isFinite(longitude);
        assert isFinite(latitude);

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
        assert latitude >= 0;
        assert latitude < twopi;
        this.latitude = latitude;
        assertClassInvariants();
    }

    public void setLongitude(double longitude) {
        assert longitude >= 0;
        assert longitude < twopi;
        this.longitude = longitude;
        assertClassInvariants();
    }

    public void setRadius(double radius) {
        assert radius >= 0;
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
        CartesianCoordinate tmp = new CartesianCoordinate(x, y, z);
        tmp.assertClassInvariants();
        return tmp;
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
        /*check whether all values are valid*/
        assert isFinite(latitude);
        assert isFinite(longitude);
        assert isFinite(radius);

        /*radius == 0 → latitude == 0 && longitude == 0*/
        if (isDoubleZero(radius)){
            assert isDoubleZero(latitude);
            assert isDoubleZero(longitude);
        }

        /*values must be in certain range*/
        assert radius >= 0; //not negative
        assert latitude >= 0; //not negative
        assert latitude < twopi; //360° → 0°
        assert longitude >= 0; //not negative
        assert longitude < twopi; //360° → 0°
    }
}
