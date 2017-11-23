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

public class SphericCoordinate extends AbstractCoordinate{
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

    @Override
    public SphericCoordinate asSphericCoordinate (){
        return this;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate (){
        double x = radius * Math.sin(latitude) * Math.cos(longitude);
        double y = radius * Math.sin(latitude) * Math.sin(longitude);
        double z = radius * Math.cos(latitude);
        return new CartesianCoordinate(x, y, z);
    }

    @Override
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
