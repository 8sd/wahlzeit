package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

public class CartesianCoordinateTest {
    @Test
    public void testCartesianCoordinate() {
        Coordinate c0 = new CartesianCoordinate();
        Coordinate c1 = new CartesianCoordinate(0,0,1);
        Coordinate c2 = new CartesianCoordinate(1,1,1);

        Assert.assertEquals(c0.getDistance(c0), 0, 0.00001);
        Assert.assertEquals(c0.getDistance(c1), 1, 0.00001);
        Assert.assertEquals(c0.getDistance(c2), Math.sqrt(3), 0.00001);
    }
}
