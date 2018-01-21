package org.wahlzeit.others;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Helpers {
    public static final double d = 10e-4;

    public static boolean compareDouble (double d1, double d2){
        return compareDouble(d1, d2, d);
    }

    public static boolean compareDoubleExact (double double1, double double2){
        if (Double.isNaN(double1) || Double.isNaN(double2)){
            return false;
        }

        Double d1 = new Double(double1);
        Double d2 = new Double(double2);

        return d1.doubleValue() == d2.doubleValue();
    }

    public static boolean compareDouble (double double1, double double2, double delta){
        if (Double.isNaN(double1) || Double.isNaN(double2)){
            return false;
        }
        assert isFinite(delta);

        if ((Double.isInfinite(double1) && !Double.isInfinite(double2)) ||
                (!Double.isInfinite(double1) && Double.isInfinite(double2))){
            return false;
        }

        double tmp = double1 - double2;

        tmp = tmp * (tmp > 0 ? 1 : -1); //get absolute value

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

    public static double roundDoubleDec(double d, int n){
        return Math.round(d * Math.pow(10, n)) / Math.pow(10, n);
    }

    public static void printNfo (){
        printNfo("");
    }

    public static void printNfo (String msg){
        StringWriter errors = new StringWriter();
        (new Exception()).printStackTrace(new PrintWriter(errors));

        if(msg != null && !msg.isEmpty()) {
            System.out.println("+-------------------------+");
            System.out.println(msg);
        }

        System.out.println("+-------------------------+");
        System.out.println(errors.toString());
        System.out.println("+-------------------------+");
    }
}
