package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

public class SphericCoordinateTest {
    private Coordinate c0 = new SphericCoordinate();
    private Coordinate c1 = new SphericCoordinate(0, 0, 1);
    private Coordinate c2 = new SphericCoordinate(1, 1, 1);

    @Test
    public void testSphericCoordinate() {
        Assert.assertEquals(c0.getDistance(c0), 0, 0.00001);
        Assert.assertEquals(c0.getDistance(c1), 1, 0.00001);
        Assert.assertEquals(c0.getDistance(c2), 1, 0.00001);
    }

    @Test(expected = AssertionError.class)
    public void testInvarianceCheck () {
        Coordinate c = new SphericCoordinate(-1, 0, 0);
    }

    @Test(expected = AssertionError.class)
    public void testInvarianceCheck2 () {
        Coordinate c = new SphericCoordinate(0, Double.NaN, 0);
    }

    @Test(expected = AssertionError.class)
    public void testSetterLatitude () {
        SphericCoordinate c = new SphericCoordinate();
        c.setLatitude(Double.NEGATIVE_INFINITY);
    }

    @Test(expected = AssertionError.class)
    public void testSetterLongitude () {
        SphericCoordinate c = new SphericCoordinate();
        c.setLongitude(Double.NEGATIVE_INFINITY);
    }

    @Test
    public void testSetterRadius () {
        SphericCoordinate c = new SphericCoordinate(1,1,1);
        c.setRadius(0);
        Assert.assertTrue(0 == c.getLatitude());
        Assert.assertTrue(0 == c.getLongitude());
        Assert.assertTrue(0 == c.getRadius());
    }

    @Test(expected = AssertionError.class)
    public void testSetterRadius2 () {
        SphericCoordinate c = new SphericCoordinate(1,1,1);
        c.setRadius(Double.POSITIVE_INFINITY);
    }
}
