package ru.academit.potyanikhin;

import java.util.Arrays;

public class Main {
    public static Shapes getMaxAreaShapes(Shapes[] shapesArray) {
        Arrays.sort(shapesArray, new ShapesAreaComparator());
        return shapesArray[shapesArray.length - 1];
    }

    public static Shapes getSecondPerimeterShapes(Shapes[] shapesArray) {
        Arrays.sort(shapesArray, new ShapesPerimeterComparator());
        return shapesArray[shapesArray.length - 2];
    }

    public static void main(String[] args) {
        Shapes[] shapesArray = new Shapes[]{new Circle(6),
                new Triangle(3, 5, 9, 7, 9, 10),
                new Square(45),
                new Rectangle(20, 60),
                new Circle(25)};

        System.out.println("Фигура с большей площадью: " + getMaxAreaShapes(shapesArray));
        System.out.println("Фигура со вторым по величине периметром: " + getSecondPerimeterShapes(shapesArray));
    }
}