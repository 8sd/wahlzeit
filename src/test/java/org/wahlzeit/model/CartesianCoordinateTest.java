package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;
import org.wahlzeit.others.EntityManagement;

public class CartesianCoordinateTest extends CoordinateTest{
    @Test
    public void testCartesianCoordinateDistance() {
        Coordinate c0 = CartesianCoordinate.getCartesianCoordinate();
        Coordinate c1 = CartesianCoordinate.getCartesianCoordinate(0,0,1);
        Coordinate c2 = CartesianCoordinate.getCartesianCoordinate(1,1,1);

        Assert.assertEquals(c0.getDistance(c0), 0, 0.00001);
        Assert.assertEquals(c0.getDistance(c1), 1, 0.00001);
        Assert.assertEquals(c0.getDistance(c2), Math.sqrt(3), 0.00001);
    }

    @Test(expected = AssertionError.class)
    public void testInvarianceCheck (){
        Coordinate c = CartesianCoordinate.getCartesianCoordinate(0, Double.NaN, 0);
    }
}
