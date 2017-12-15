package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

public abstract class CoordinateTest {
    private static final double delta = 0.00001;
    private Coordinate c0 = CartesianCoordinate.getCartesianCoordinate();
    private Coordinate c1 = CartesianCoordinate.getCartesianCoordinate(1, 1, 1);
    private Coordinate c2 = CartesianCoordinate.getCartesianCoordinate(1, 0, 0);
    private Coordinate c3 = SphericCoordinate.getSphericCoordinate();
    private Coordinate c4 = SphericCoordinate.getSphericCoordinate(0, 0, 1);
    private Coordinate c5 = SphericCoordinate.getSphericCoordinate(1, 1, 0);
    private Coordinate c6 = SphericCoordinate.getSphericCoordinate(1, 1, 1);

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
        Assert.assertEquals(Math.sqrt(3), c0.getDistance(c1), delta);
        Assert.assertEquals(0, c0.getDistance(c3), delta);
        Assert.assertEquals(0, c0.getDistance(c5), delta);
        Assert.assertEquals(1, c0.getDistance(c6), delta);
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
