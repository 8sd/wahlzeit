package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

public class BeerPhotoFactoryTest {
    @Test
    public void testoBeerPhotoFactory(){
        PhotoFactory f1 = BeerPhotoFactory.getInstance();
        PhotoFactory f2 = BeerPhotoFactory.getInstance();

        Assert.assertEquals(f1, f2);
    }
}
