package com.acme.utils;

import java.math.BigDecimal;

public class ConversionService {
    /**
     * weight conversion rates
     */
    public static double kilogramToPounds = 2.2046;
    public static BigDecimal bigKilogramToPounds = new BigDecimal(kilogramToPounds);
    public static BigDecimal kilogramToGrams = new BigDecimal(1000);
    public static BigDecimal kilogramToOunces = new BigDecimal(35.274);

    /**
     * volume conversion rates
     */
    public static float literToFluidOunce = 33.814f;
    public static float literToGallon = 0.2642f;
    public static float literToPints = 2.1134f;
    public static short literToMilliliters = 1_000;

    public static BigDecimal pounds (BigDecimal kilograms) {
        return kilograms.multiply(bigKilogramToPounds);
    }

    public static double pounds (double kilograms) {
        return kilograms * kilogramToPounds;
    }

    public static BigDecimal grams (BigDecimal kilograms) {
        return kilograms.multiply(kilogramToGrams);
    }

    public static BigDecimal ounces (BigDecimal kilograms) {
        return kilograms.multiply(kilogramToOunces);
    }

    public static float gallons (float liters) {
        return liters * literToGallon;
    }

    public static float fluidOunces (float liters) {
        return liters * literToFluidOunce;
    }

    public static float pints (float liters) {
        return liters * literToPints;
    }

    public static int milliliters (int liters) {
        return liters * literToMilliliters;
    }

    public static double[][] allKgToPounds(double... kilogramValues) {
        double[][] k2p = new double[kilogramValues.length][2];
            for(int i = 0; i < kilogramValues.length; i++) {
                k2p[i][0] = kilogramValues[i];
                k2p[i][1] = pounds(kilogramValues[i]);
            }
        return k2p;
    }
}
