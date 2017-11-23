package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


public class CoordinateTest {
    static final double delta = 0.00001;

    @Test
    public void testDynamicObjectHandling(){
        Coordinate c0 = new CartesianCoordinate();
        Coordinate c1 = new CartesianCoordinate(1,1,1);
        Coordinate c2 = new CartesianCoordinate(1,0,0);
        Coordinate c3 = new SphericCoordinate();
        Coordinate c4 = new SphericCoordinate(0,0,1);
        Coordinate c5 = new SphericCoordinate(1,1,0);
        Coordinate c6 = new SphericCoordinate(1,1,1);

        Assert.assertEquals(c0, c3);
        Assert.assertEquals(c0, c5);
        Assert.assertEquals(c3, c5);

        Assert.assertNotEquals(c0, c1);
        Assert.assertNotEquals(c0, c4);
        Assert.assertNotEquals(c3, c1);
        Assert.assertNotEquals(c3, c4);

        Assert.assertEquals(c0.getDistance(c1), Math.sqrt(3),delta);
        Assert.assertEquals(c0.getDistance(c3), 0,delta);
        Assert.assertEquals(c0.getDistance(c5), 0,delta);
        Assert.assertEquals(c0.getDistance(c6), 1,delta);

        Assert.assertEquals(c0, c0.asSphericCoordinate().asCartesianCoordinate());
        Assert.assertEquals(c3, c3.asCartesianCoordinate().asSphericCoordinate());
    }
}
