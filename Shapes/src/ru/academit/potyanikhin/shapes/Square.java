package ru.academit.potyanikhin.shapes;

import ru.academit.potyanikhin.shape_interface.Shape;

public class Square implements Shape {
    private static final String name = "Квадрат";
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        return Math.pow(sideLength, 2);
    }

    @Override
    public double getPerimeter() {
        return 4 * sideLength;
    }

    @Override
    public String toString() {
        return name + " со стороной " + sideLength;
    }
}