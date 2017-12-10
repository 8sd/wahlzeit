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
        assertClassInvariants();
        assert coordinate != null;

        if(this.isEqual(coordinate)){
            return 0;
        }

        try { //does not violate lsp both subclasses behave in the same way
            return getSphericDistance(coordinate);
        } catch (ArithmeticException e) { //is radius are nt equal
            return getCartesianDistance(coordinate);
        }
    }

    public double getDistance (){
        return getDistance(zero);
    }

    public abstract double getCartesianDistance (Coordinate coordinate);

    public abstract double  getSphericDistance (Coordinate coordinate) throws ArithmeticException;

    public abstract boolean isEqual (Coordinate coordinate);

    @Override
    public int hashCode(){
        /*TODO implement purposeful hashfunction*/
        return 0;
    }

    protected abstract void assertClassInvariants ();
}
