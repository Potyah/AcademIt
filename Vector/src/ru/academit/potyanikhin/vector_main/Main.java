package ru.academit.potyanikhin.vector_main;

import ru.academit.potyanikhin.vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[] array = {5.6, 4, 6.7};
        double[] array2 = {5.5, 4, 6.5, 5.5, 4, 6.5, 8};

        Vector vector1 = new Vector(3, array);
        Vector vector2 = new Vector(7, array2);



        vector2.vectorDifference(vector1);
        System.out.println(vector2);

        vector1.vectorReturn();
        System.out.println(vector1);

        Vector vector3 = new Vector(vector1);
        System.out.println(vector3.getVectorLength());

        vector1.vectorComponentInstallation(99.99, 2);
        System.out.println(vector1);
    }
}
