package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

public class SphericCoordinateTest {
    private Coordinate c0 = SphericCoordinate.getSphericCoordinate();
    private Coordinate c1 = SphericCoordinate.getSphericCoordinate(0, 0, 1);
    private Coordinate c2 = SphericCoordinate.getSphericCoordinate(1, 1, 1);

    @Test
    public void testSphericCoordinate() {
        Assert.assertEquals(c0.getDistance(c0), 0, 0.00001);
        Assert.assertEquals(c0.getDistance(c1), 1, 0.00001);
        Assert.assertEquals(c0.getDistance(c2), 1, 0.00001);
    }

    @Test(expected = AssertionError.class)
    public void testInvarianceCheck () {
        Coordinate c = SphericCoordinate.getSphericCoordinate(-1, 0, 0);
    }

    @Test(expected = AssertionError.class)
    public void testInvarianceCheck2 () {
        Coordinate c = SphericCoordinate.getSphericCoordinate(0, Double.NaN, 0);
    }

    @Test(expected = AssertionError.class)
    public void testSetterLatitude () {
        SphericCoordinate c = SphericCoordinate.getSphericCoordinate();
        c.setLatitude(Double.NEGATIVE_INFINITY);
    }

    @Test(expected = AssertionError.class)
    public void testSetterLongitude () {
        SphericCoordinate c = SphericCoordinate.getSphericCoordinate();
        c.setLongitude(Double.NEGATIVE_INFINITY);
    }

    @Test
    public void testSetterRadius () {
        SphericCoordinate c = SphericCoordinate.getSphericCoordinate(1,1,1);
        c = c.setRadius(0);
        Assert.assertTrue(0 == c.getLatitude());
        Assert.assertTrue(0 == c.getLongitude());
        Assert.assertTrue(0 == c.getRadius());
    }

    @Test(expected = AssertionError.class)
    public void testSetterRadius2 () {
        SphericCoordinate c = SphericCoordinate.getSphericCoordinate(1,1,1);
        c.setRadius(Double.POSITIVE_INFINITY);
    }
}
