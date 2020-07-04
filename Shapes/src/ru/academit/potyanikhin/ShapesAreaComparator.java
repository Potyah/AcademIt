package ru.academit.potyanikhin;

import java.util.Comparator;

class ShapesAreaComparator implements Comparator<Shapes> {

    @Override
    public int compare(Shapes o1, Shapes o2) {
        return (int) (o1.getArea() - o2.getArea());
    }
}
