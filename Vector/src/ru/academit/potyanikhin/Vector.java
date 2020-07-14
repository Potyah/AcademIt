package ru.academit.potyanikhin;


import java.util.Arrays;

public class Vector {
    private double[] vectorArray;
    private int n;

    public Vector(int n) {
        vectorArray = new double[n];
    }

    public Vector(Vector vector) {
        this.n = vector.n;
        this.vectorArray = vector.vectorArray;

    }

    public Vector(double[] vectorArray) {
        this.vectorArray = vectorArray;
    }

    public Vector(int n, double[] vectorArray) {
        this.vectorArray = new double[n];

        for (int i = 0; i < vectorArray.length; i++) {
            this.vectorArray[i] = vectorArray[i];
        }
    }

    public double[] getVectorArray() {
        return vectorArray;
    }

    public int getN() {
        return n;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "n=" + n +
                ", vectorArray=" + Arrays.toString(vectorArray) +
                '}';
    }

    public int getSize(Vector vector) {
        return vector.vectorArray.length;
    }


}


