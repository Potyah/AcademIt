package ru.academit.potyanikhin.shapes;

import ru.academit.potyanikhin.shape_interface.Shape;

public class Triangle implements Shape {
    private static final String name = "Треугольник";
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double x2, double x3, double y1, double y2, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    public double getX3() {
        return x3;
    }

    public double getY3() {
        return y3;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public void setY3(double y3) {
        this.y3 = y3;
    }

    private static double getSideLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public String getName() {
        return name;
    }

    @Override
    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    @Override
    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    @Override
    public double getArea() {
        double epsilon = 1.0e-10;

        if (Math.abs((x3 - x1 * y2 - y1) - (y3 - y1) * (x3 - x1)) <= epsilon) {
            return 0;
        }

        double a = getSideLength(x1, y1, x2, y2);
        double b = getSideLength(x2, y2, x3, y3);
        double c = getSideLength(x1, y1, x3, y3);

        double halfPerimeter = a + b + c / 2;

        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }

    @Override
    public double getPerimeter() {

        double a = getSideLength(x1, y1, x2, y2);
        double b = getSideLength(x2, y2, x3, y3);
        double c = getSideLength(x1, y1, x3, y3);

        return a + b + c;
    }

    public String toString() {
        return name + " с точками x1 = " + x1 + " x2 = " + x2 + " x3 = " + x3 + " y1 = " + y1 + " y2 = " + y2 + " y3 = " + y3;
    }
}