package ru.academit.potyanikhin;

import java.util.Comparator;

public class areaComparator implements Comparator<Shapes> {

    @Override
    public int compare(Shapes o1, Shapes o2) {
        return o1.getArea(o1) - o2.getArea();
}
