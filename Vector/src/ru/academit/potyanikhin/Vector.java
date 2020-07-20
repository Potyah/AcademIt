package ru.academit.potyanikhin;


import java.util.Arrays;

public class Vector implements Cloneable {
    private double[] vectorArray;
    private int n;

    public Vector(int n) {
        vectorArray = new double[n];
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

    public Vector(Vector vector) {
        this(vector.getVectorArray());
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

    public Vector vectorSum(Vector vector) {
        if (this.vectorArray.length > vector.vectorArray.length) {
            return getVectorSum(this.vectorArray, vector.vectorArray);
        }

        return getVectorSum(vector.vectorArray, this.vectorArray);
    }

    private static Vector getVectorSum(double[] vector, double[] vector1) {
        Vector vectorSum = new Vector(vector.length);

        for (int i = 0; i < vector.length; i++) {
            vectorSum.vectorArray[i] += vector[i];
        }

        for (int i = 0; i < vector1.length; i++) {
            vectorSum.vectorArray[i] += vector1[i];
        }

        return vectorSum;
    }

    public Vector vectorDifference(Vector vector) {
        if (this.vectorArray.length < vector.vectorArray.length) {
            return getVectorDifference(this.vectorArray, vector.vectorArray, vector.vectorArray.length);
        }

        return getVectorDifference(this.vectorArray, vector.vectorArray, this.vectorArray.length);
    }

    public static Vector getVectorDifference(double[] vector1, double[] vector2, int length) {
        Vector vectorDifference = new Vector(length);

        for (int i = 0; i < vector1.length; i++) {
            vectorDifference.vectorArray[i] += vector1[i];
        }

        for (int i = 0; i < vector2.length; i++) {
            vectorDifference.vectorArray[i] -= vector2[i];
        }

        return vectorDifference;
    }

    public void vectorReturn() {
        for (int i = 0; i < this.vectorArray.length; i++) {
            this.vectorArray[i] = vectorArray[i] * (-1);
        }
    }

    
}