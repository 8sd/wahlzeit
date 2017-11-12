package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

public class BeerPhotoTest {
    @Test
    public void testBeerPhoto(){
        BeerPhoto b1 = new BeerPhoto();
        BeerPhoto b2 = new BeerPhoto(new PhotoId(1337));
        BeerPhoto b3 = new BeerPhoto("blub");

        Assert.assertNotEquals(b1, b2);
        Assert.assertNotEquals(b1, b3);
        Assert.assertArrayEquals("blub".toCharArray(), b3.getBrewery().toCharArray());
    }
}
