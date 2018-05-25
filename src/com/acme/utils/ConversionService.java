package com.acme.utils;

import java.math.BigDecimal;

public class ConversionService {
    /**
     * weight conversion rates
     */
    public static BigDecimal kilogramToPounds = new BigDecimal(2.2046);
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
        return kilograms.multiply(kilogramToPounds);
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
}
