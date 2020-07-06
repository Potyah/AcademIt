package ru.academit.potyanikhin.square;

import ru.academit.potyanikhin.shapes.Shapes;

public class Square extends Shapes {
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

    public double getPerimeter() {
        return 4 * sideLength;
    }

    public String toString() {
        return name + " со стороной " + sideLength;
    }
}
