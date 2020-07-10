package ru.academit.potyanikhin.shapes_main;

import ru.academit.potyanikhin.shape_interface.Shape;

import java.util.Comparator;

public class ShapesAreaComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        return Double.compare(o1.getArea(), o2.getArea());
    }
}