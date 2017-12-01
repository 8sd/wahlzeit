package org.wahlzeit.others;

import org.junit.Assert;
import org.junit.Test;

public class HelpersTest {
    @Test
    public void testCompareDouble (){
        double a = 0;
        double b = 0;
        double c = 10e-5;
        double d = 1;

        Assert.assertTrue(Helpers.compareDouble(a, b));
        Assert.assertTrue(Helpers.compareDouble(a, c));
        Assert.assertFalse(Helpers.compareDouble(a, d));

        Assert.assertTrue(Helpers.compareDoubleExact(a, b));
        Assert.assertFalse(Helpers.compareDoubleExact(a, c));
        Assert.assertFalse(Helpers.compareDoubleExact(a, d));

        Assert.assertFalse(Helpers.compareDoubleExact(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY));
        Assert.assertFalse(Helpers.compareDoubleExact(Double.NaN, Double.NaN));
    }

    @Test
    public void testValidateFinityOfDouble(){
        double a = Double.NaN;
        double b = Double.POSITIVE_INFINITY;
        double c = Double.NEGATIVE_INFINITY;
        double d = 0;

        Assert.assertFalse(Helpers.isFinite(a));
        Assert.assertFalse(Helpers.isFinite(b));
        Assert.assertFalse(Helpers.isFinite(c));

        Assert.assertTrue(Helpers.isFinite(d));
    }

    @Test
    public void testIsZero () {
        double a = Double.NaN;
        double b = Double.POSITIVE_INFINITY;
        double c = Double.NEGATIVE_INFINITY;
        double d = 0;
        double e = 10e-5;
        double f = 10;

        Assert.assertFalse(Helpers.isDoubleZero(a));
        Assert.assertFalse(Helpers.isDoubleZero(b));
        Assert.assertFalse(Helpers.isDoubleZero(c));
        Assert.assertFalse(Helpers.isDoubleZero(f));
        Assert.assertTrue(Helpers.isDoubleZero(d));
        Assert.assertTrue(Helpers.isDoubleZero(e));
    }
}
