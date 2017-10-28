package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Test class for {@link Location}.
 */
public class LocationTest {

    @Test
    public void testContructor (){
        Assert.assertEquals(new Location(), new Location(0,0,0));
        Assert.assertEquals(new Location(), new Location());
        Assert.assertNotEquals(new Location(), new Location(1,0,0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException1 (){
        Location test = new Location(Double.NaN ,0 ,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException2 (){
        Location test = new Location(0, Double.NaN ,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException3 (){
        Location test = new Location(0, 0, Double.NaN);
    }

    @Test
    public void testIsEqual (){
        Location a = new Location();
        Location b = new Location(0,0,0);
        Location c = new Location(1, 1, 1);

        Assert.assertTrue(a.equals(b));
        Assert.assertTrue(b.equals(a));
        Assert.assertFalse(a.equals(c));
        Assert.assertFalse(c.equals(a));
        Assert.assertFalse(a.equals(null));
        Assert.assertFalse(a.equals(new ArrayList<String>()));
    }

    @Test
    public void testGetDistance (){
        Location a = new Location();
        Location b = new Location(0, 0, 0);
        Location c = new Location(1, 1, 1);
        Location d = new Location(0, 0, 1);

        Assert.assertEquals(a.getDistance(b), 0, 0);
        Assert.assertEquals(a.getDistance(c), Math.sqrt(3), 0);
        Assert.assertEquals(a.getDistance(d), 1, 0);
        Assert.assertEquals(b.getDistance(b), 0, 0);
        Assert.assertEquals(c.getDistance(c), 0, 0);
        Assert.assertEquals(c.getDistance(d), Math.sqrt(2), 0.);
    }
}
