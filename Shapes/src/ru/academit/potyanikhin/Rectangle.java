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

    @Override
    public double getWidth() {
        return Math.max(sideLength1, sideLength2);
    }

    @Override
    public double getHeight() {
        return Math.min(sideLength1, sideLength2);
    }

    @Override
    public double getArea() {
        return sideLength1 * sideLength2;
    }

    @Override
    public double getPerimeter() {
        return (sideLength1 + sideLength2) * 2;
    }

    public String toString() {
        return name + " со сторонами " + sideLength1 + " и " + sideLength2;
    }
}