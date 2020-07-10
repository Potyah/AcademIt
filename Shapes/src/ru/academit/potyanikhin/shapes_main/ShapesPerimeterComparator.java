package ru.academit.potyanikhin.shapes_main;

import ru.academit.potyanikhin.shape_interface.Shape;

import java.util.Comparator;

public class ShapesPerimeterComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        return Double.compare(o1.getPerimeter(), o2.getPerimeter());
    }
}