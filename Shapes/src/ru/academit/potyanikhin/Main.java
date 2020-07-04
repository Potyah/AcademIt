package ru.academit.potyanikhin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle(56);
        Triangle triangle = new Triangle(3, 5, 9, 7, 9, 10);
        Square square = new Square(45);
        Rectangle rectangle = new Rectangle(58, 60);

        System.out.println(Shapes.getWidth(square));
        System.out.println(Shapes.getWidth(triangle));
        System.out.println(Shapes.getWidth(rectangle));
        System.out.println(Shapes.getWidth(circle));


        System.out.println(Shapes.getHeight(rectangle));


        Shapes[] shapesArray = new Shapes[]{new Circle(6),
                new Triangle(3, 5, 9, 7, 9, 10),
                new Square(45),
                new Rectangle(58, 60),
                new Circle(56)};

        Arrays.sort (shapesArray, areaComparator);

        //   for (Object o : shapesArray) {

    }
}

