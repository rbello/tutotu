package com.capgemini.tuto;

public class Class2 {

    private String name;
    private double x;
    private double y;

    public Class2(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static void process(Class2 instance, double factor) {
        instance.setX(instance.getX() * factor);
        instance.setY(instance.getY() * factor);
    }

}
