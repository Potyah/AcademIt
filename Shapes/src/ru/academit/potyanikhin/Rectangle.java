package ru.academit.potyanikhin;

public class Rectangle extends Shapes {
    private static final String name = "Прямоугольник";
    private double sideLength1;
    private double sideLength2;

    public Rectangle(double sideLength1, double sideLength2) {
        this.sideLength1 = sideLength1;
        this.sideLength2 = sideLength2;
    }

    public double getSideLength1() {
        return sideLength1;
    }

    public double getSideLength2() {
        return sideLength2;
    }

    public void setSideLength1(double sideLength1) {
        this.sideLength1 = sideLength1;
    }

    public void setSideLength2(double sideLength2) {
        this.sideLength2 = sideLength2;
    }

    public String getName() {
        return name;
    }
}
