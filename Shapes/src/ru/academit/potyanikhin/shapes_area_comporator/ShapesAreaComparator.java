package ru.academit.potyanikhin.shapes_area_comporator;

import ru.academit.potyanikhin.shapes.Shapes;

import java.util.Comparator;

public class ShapesAreaComparator implements Comparator<Shapes> {
    @Override
    public int compare(Shapes o1, Shapes o2) {
        return (int) (o1.getArea() - o2.getArea());
    }
}
