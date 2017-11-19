package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

public class SphericCoordinateTest {
    @Test
    public void testSphericCoordinate() {
        Coordinate c0 = new SphericCoordinate();
        Coordinate c1 = new SphericCoordinate(0, 0, 1);
        Coordinate c2 = new SphericCoordinate(1, 1, 1);

        Assert.assertEquals(c0.getDistance(c0), 0, 0.00001);
        Assert.assertEquals(c0.getDistance(c1), 1, 0.00001);
        Assert.assertEquals(c0.getDistance(c2), 1, 0.00001);
    }
}
