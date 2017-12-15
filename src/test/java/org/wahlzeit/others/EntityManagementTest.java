package org.wahlzeit.others;

import org.junit.Assert;
import org.junit.Test;
import org.wahlzeit.model.CartesianCoordinate;

public class EntityManagementTest {
    private static final EntityManagement <String> entityManagement = new EntityManagement<>();
    private static final EntityManagement <CartesianCoordinate> entityManagement2 = new EntityManagement<>();

    @Test
    public void testConstuctor () {
        Assert.assertNotNull(entityManagement);
        Assert.assertNotNull(entityManagement2);

    }

    @Test
    public void testEntityManagement () {
        String a = entityManagement.getEntitiy("foo");
        String b = "fo";
        String c = b + "o";
        String d = entityManagement.getEntitiy(c);

        Assert.assertFalse(a == b);
        Assert.assertFalse(a.equals(b));
        Assert.assertFalse(a == c);
        Assert.assertTrue(a.equals(c));
        Assert.assertTrue(a == d);
        Assert.assertTrue(a.equals(d));

        Assert.assertTrue(b.equals(entityManagement.getEntitiy("fo")));
        Assert.assertTrue(b == entityManagement.getEntitiy("fo"));
    }
}
