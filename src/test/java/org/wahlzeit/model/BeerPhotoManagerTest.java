package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

public class BeerPhotoManagerTest {
    @Test
    public void testoBeerPhotoManager(){
        BeerPhotoManager m1 = BeerPhotoManager.getInstance();
        BeerPhotoManager m2 = BeerPhotoManager.getInstance();

        Assert.assertEquals(m1, m2);
    }
}
