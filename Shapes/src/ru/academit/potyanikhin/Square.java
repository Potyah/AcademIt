package ru.academit.potyanikhin;

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


    public String getName() {
        return name;
    }
}
