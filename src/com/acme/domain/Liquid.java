package com.acme.domain;

public class Liquid extends Good{
    private double radius;

    public Liquid(String name, int modelNumber, double height, UnitOfMeasureType unitOfMeasure, boolean flammable, double weightPerUofM, double radius) {
        super(name, modelNumber, height, unitOfMeasure, flammable, weightPerUofM);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double volume() {
        return Math.PI * radius * radius * getHeight();
    }

    public String toString() {
        return super.toString() + " (liquid) " + volume() + " " + getUnitOfMeasure();
    }

//    public boolean canShipViaPostOffice() {
//        return true;
//    }
}
