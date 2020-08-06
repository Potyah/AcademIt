package ru.academit.potyanikhin.vector_main;

import ru.academit.potyanikhin.vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[] array = {5.6, 4, 6.7};
        double[] array2 = {5.5, 4, 6.5, 5.5, 4, 6.5, 8};

        Vector vector1 = new Vector(array);
        Vector vector2 = new Vector(array2);
        Vector vector3 = new Vector(vector1);

        Vector.getSum(vector1, vector2);

        vector1.add(vector2);
        System.out.println(Vector.getSum(vector1, vector2));

        System.out.println(vector3.getLength());

        vector1.setComponent(99.99, 2);
        System.out.println(vector1);
    }
}