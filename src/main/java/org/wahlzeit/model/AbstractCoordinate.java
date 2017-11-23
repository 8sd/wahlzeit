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

public abstract class AbstractCoordinate implements Coordinate{
    public static final Coordinate zero = new CartesianCoordinate();

    public abstract SphericCoordinate asSphericCoordinate ();

    public abstract CartesianCoordinate asCartesianCoordinate ();

    public double getDistance (Coordinate coordinate){
        return getCartesianDistance(coordinate);
    }

    public double getDistance (){
        return getDistance(zero);
    }

    public double getCartesianDistance (Coordinate coordinate){
        if(coordinate == null){
            return Double.NaN;
        }
        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();

        if(this.isEqual(cartesianCoordinate)){
            return 0;
        }

        return cartesianCoordinate.getCartesianDistance(this);
    }

    public double getSphericDistance (Coordinate coordinate){
        return getCartesianDistance(coordinate);
    }

    public abstract boolean isEqual (Coordinate coordinate);

    @Override
    public int hashCode(){
        /*TODO implement purposeful hashfunction*/
        return 0;
    }
}
