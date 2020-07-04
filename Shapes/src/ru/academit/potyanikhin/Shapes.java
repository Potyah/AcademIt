package ru.academit.potyanikhin;

public class Shapes {

    public static double getWidth(Square square) {
        return square.getSideLength();
    }

    public static double getWidth(Triangle triangle) {
        return Math.max(Math.max(triangle.getX1(), triangle.getX2()), triangle.getX3()) - Math.min(Math.min(triangle.getX1(), triangle.getX2()), triangle.getX3());
    }

    public static double getWidth(Rectangle rectangle) {
        return Math.max(rectangle.getSideLength1(), rectangle.getSideLength2());
    }

    public static double getWidth(Circle circle) {
        return 2 * circle.getRadius();
    }

    public static double getHeight(Square square) {
        return square.getSideLength();
    }

    public static double getHeight(Triangle triangle) {
        return Math.max(Math.max(triangle.getY1(), triangle.getY2()), triangle.getY3()) - Math.min(Math.min(triangle.getY1(), triangle.getY2()), triangle.getY3());
    }

    public static double getHeight(Rectangle rectangle) {
        return Math.min(rectangle.getSideLength1(), rectangle.getSideLength2());
    }

    public static double getHeight(Circle circle) {
        return 2 * circle.getRadius();
    }

    public static double getArea(Square square) {
        return Math.pow(square.getSideLength(), 2);
    }

    public static double getArea(Triangle triangle) {
        double epsilon = 1.0e-10;

        if (Math.abs((triangle.getX3() - triangle.getX1()) * (triangle.getY2() - triangle.getY1()) - (triangle.getY3() - triangle.getY1()) * (triangle.getX3() - triangle.getX1())) <= epsilon) {
            return 0;
        }

        double a = Math.sqrt(Math.pow(triangle.getX2() - triangle.getX1(), 2) + Math.pow(triangle.getY2() - triangle.getY1(), 2));
        double b = Math.sqrt(Math.pow(triangle.getX3() - triangle.getX2(), 2) + Math.pow(triangle.getY3() - triangle.getY2(), 2));
        double c = Math.sqrt(Math.pow(triangle.getX3() - triangle.getX1(), 2) + Math.pow(triangle.getY3() - triangle.getY1(), 2));

        double halfPerimeter = (a + b + c) / 2;

        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }

    public static double getArea(Rectangle rectangle) {
        return rectangle.getSideLength1() * rectangle.getSideLength2();
    }

    public static double getArea(Circle circle) {
        return Math.PI * Math.pow(circle.getRadius(), 2);
    }


    public static double getPerimeter(Square square) {
        return 4 * square.getSideLength();
    }

    public static double getPerimeter(Triangle triangle) {
        double epsilon = 1.0e-10;

        if (Math.abs((triangle.getX3() - triangle.getX1()) * (triangle.getY2() - triangle.getY1()) - (triangle.getY3() - triangle.getY1()) * (triangle.getX3() - triangle.getX1())) <= epsilon) {
            return 0;
        }

        double a = Math.sqrt(Math.pow(triangle.getX2() - triangle.getX1(), 2) + Math.pow(triangle.getY2() - triangle.getY1(), 2));
        double b = Math.sqrt(Math.pow(triangle.getX3() - triangle.getX2(), 2) + Math.pow(triangle.getY3() - triangle.getY2(), 2));
        double c = Math.sqrt(Math.pow(triangle.getX3() - triangle.getX1(), 2) + Math.pow(triangle.getY3() - triangle.getY1(), 2));

        return a + b + c;
    }

    public static double getPerimeter(Rectangle rectangle) {
        return (rectangle.getSideLength1() + rectangle.getSideLength2()) * 2;
    }

    public static double getPerimeter(Circle circle) {
        return 2 * Math.PI * circle.getRadius();
    }


}

class CompareShapes implements Comporator
