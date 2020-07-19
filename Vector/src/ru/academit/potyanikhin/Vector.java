package ru.academit.potyanikhin;


import java.util.Arrays;

public class Vector {
    private final double[] vectorArray;
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


    public static Vector getVectorSum (double[] vector, double[] vector1) {
        Vector vectorSum = new Vector(vector);

        for (int i = 0; i < vector1.length; i++) {
            vectorSum.vectorArray[i] += vector1 [i];
        }

        return vectorSum;
    }

    public Vector vectorSum(Vector vector) {
        if (this.vectorArray.length > vector.vectorArray.length) {
            return getVectorSum(this.vectorArray, vectorArray);
        }

        return getVectorSum(vector.vectorArray, this.vectorArray);
    }

    public void vectorReturn() {
        for (int i = 0; i < this.vectorArray.length; i++) {
            this.vectorArray[i] = vectorArray[i] * (-1);
        }
    }
}