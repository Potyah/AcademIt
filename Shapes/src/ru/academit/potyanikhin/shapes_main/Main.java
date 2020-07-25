package ru.academit.potyanikhin.shapes_main;

import ru.academit.potyanikhin.shapes.Circle;
import ru.academit.potyanikhin.shapes.Rectangle;
import ru.academit.potyanikhin.shape_interface.Shape;
import ru.academit.potyanikhin.shapes.Square;
import ru.academit.potyanikhin.shapes.Triangle;

import java.util.Arrays;

public class Main {
    public static Shape getMaxAreaShape(Shape[] shapeArray) {
        Arrays.sort(shapeArray, new ShapesAreaComparator());
        return shapeArray[shapeArray.length - 1];
    }

    public static Shape getSecondPerimeterShape(Shape[] shapeArray) {
        Arrays.sort(shapeArray, new ShapesPerimeterComparator());
        return shapeArray[shapeArray.length - 2];
    }

    public static void main(String[] args) {
        Shape[] shapeArray = {new Circle(6),
                new Triangle(3, 5, 9, 7, 9, 10),
                new Square(45),
                new Rectangle(20, 60),
                new Circle(25)};

        System.out.println("Фигура с большей площадью: " + getMaxAreaShape(shapeArray));
        System.out.println("Фигура со вторым по величине периметром: " + getSecondPerimeterShape(shapeArray));
    }
}