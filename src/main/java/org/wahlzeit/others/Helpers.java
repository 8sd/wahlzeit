package org.wahlzeit.others;

public class Helpers {
    public static final double Δ = 10e-4;

    public static boolean compareDouble (double d1, double d2){
        return compareDouble(d1, d2, Δ);
    }

    public static boolean compareDoubleExact (double double1, double double2){
        Double d1 = new Double(double1);
        Double d2 = new Double(double2);

        return d1.doubleValue() == d2.doubleValue();
    }

    public static boolean compareDouble (double d1, double d2, double delta){
        double tmp = d1 - d2;

        tmp = tmp * (tmp > 0 ? 1 : -1);

        return tmp < delta;
    }

    public static boolean isFinite(double d){
        if (Double.isInfinite(d)){
            return false;
        }
        if (Double.isNaN(d)){
            return false;
        }
        return true;
    }

    public static boolean isDoubleZero(double d){
        return compareDouble(d, 0d);
    }
}
