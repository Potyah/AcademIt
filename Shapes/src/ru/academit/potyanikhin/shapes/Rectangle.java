package ru.academit.potyanikhin.shapes;

import ru.academit.potyanikhin.shape_interface.Shape;

public class Rectangle implements Shape {
    private static final String name = "Прямоугольник";
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }

    public String toString() {
        return name + " с шириной " + width + " и высотой " + height;
    }
}