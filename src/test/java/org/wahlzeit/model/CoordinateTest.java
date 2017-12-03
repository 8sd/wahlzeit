package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

public abstract class CoordinateTest {
    private static final double delta = 0.00001;
    private Coordinate c0 = new CartesianCoordinate();
    private Coordinate c1 = new CartesianCoordinate(1, 1, 1);
    private Coordinate c2 = new CartesianCoordinate(1, 0, 0);
    private Coordinate c3 = new SphericCoordinate();
    private Coordinate c4 = new SphericCoordinate(0, 0, 1);
    private Coordinate c5 = new SphericCoordinate(1, 1, 0);
    private Coordinate c6 = new SphericCoordinate(1, 1, 1);

    @Test
    public void testDynamicObjectHandlingEquals() {

        Assert.assertEquals(c0, c3);
        Assert.assertEquals(c0, c5);
        Assert.assertEquals(c3, c5);

        Assert.assertNotEquals(c0, c1);
        Assert.assertNotEquals(c0, c4);
        Assert.assertNotEquals(c3, c1);
        Assert.assertNotEquals(c3, c4);
    }

    @Test
    public void testDynamicObjectHandlingDistance() {
        Assert.assertEquals(c0.getDistance(c1), Math.sqrt(3), delta);
        Assert.assertEquals(c0.getDistance(c3), 0, delta);
        Assert.assertEquals(c0.getDistance(c5), 0, delta);
        Assert.assertEquals(c0.getDistance(c6), 1, delta);
    }

    @Test
    public void testDynamicObjectHandlingConversion() {
        Assert.assertEquals(c0, c0.asSphericCoordinate().asCartesianCoordinate());
        Assert.assertEquals(c3, c3.asCartesianCoordinate().asSphericCoordinate());
    }


    @Test
    public abstract void testCartesianCoordinateDistance();


    @Test(expected = AssertionError.class)
    public abstract void testInvarianceCheck ();
}
