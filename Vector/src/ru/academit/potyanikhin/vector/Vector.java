package ru.academit.potyanikhin.vector;


import java.util.Arrays;
import java.util.Objects;

public class Vector {
    // Поля
    private double[] vectorArray;
    private int n;

    // Конструктор с нулевыми компонентами;
    public Vector(int n) {
        vectorArray = new double[n];
    }

    // Заполнение вектора значениями из массива;
    public Vector(double[] vectorArray) {
        this.vectorArray = vectorArray;
    }

    // Заполнение вектора значениями из массива. Если длина массива меньше n, то считать что в остальных компонентах 0;
    public Vector(int n, double[] vectorArray) {
        this.vectorArray = new double[n];

        System.arraycopy(vectorArray, 0, this.vectorArray, 0, vectorArray.length);
    }

    // Конструктор копирования;
    public Vector(Vector vector) {
        n = vector.n;
        vectorArray = vector.vectorArray;
    }

    // Геттер массива компонент;
    public double[] getVectorArray() {
        return vectorArray;
    }

    // Геттер n;
    public int getN() {
        return n;
    }

    // toString;
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < vectorArray.length; i++) {
            string.append(vectorArray[i]);

            if (i == vectorArray.length - 1) {
                break;
            }

            string.append(", ");
        }

        return "{ " + string + " }";
    }

    // Метод для получения размерности вектора;
    public int getSize() {
        return vectorArray.length;
    }

    // Прибавление к вектору другого вектора;
    public void vectorAddition(Vector vector) {
        if (this.vectorArray.length < vector.vectorArray.length) {
            Vector tempVector = new Vector(vector.vectorArray.length, this.vectorArray);
            this.vectorArray = tempVector.vectorArray;

            for (int i = 0; i < vector.vectorArray.length; i++) {
                this.vectorArray[i] += vector.vectorArray[i];
            }

            return;
        }

        for (int i = 0; i < vector.vectorArray.length; i++) {
            this.vectorArray[i] += vector.vectorArray[i];
        }
    }

    // Вычитание из вектора другого вектора;
    public void vectorDifference(Vector vector) {
        if (this.vectorArray.length < vector.vectorArray.length) {
            Vector tempVector = new Vector(vector.vectorArray.length, this.vectorArray);
            this.vectorArray = tempVector.vectorArray;

            for (int i = 0; i < vector.vectorArray.length; i++) {
                this.vectorArray[i] -= vector.vectorArray[i];
            }

            return;
        }

        for (int i = 0; i < vector.vectorArray.length; i++) {
            this.vectorArray[i] -= vector.vectorArray[i];
        }
    }

    // Умножение вектора на скаляр;
    public void scalarMultiplication(double scalar) {
        for (int i = 0; i < this.vectorArray.length; i++) {
            this.vectorArray[i] *= scalar;
        }
    }

    //Разворот вектора;
    public void vectorReturn() {
        for (int i = 0; i < this.vectorArray.length; i++) {
            this.vectorArray[i] *= (-1);
        }
    }

    // Получение длины вектора;
    public double getVectorLength() {
        double vectorLength = 0;

        for (double i : this.vectorArray) {
            vectorLength += i;
        }

        return Math.abs(vectorLength);
    }

    //Установка компоненты вектора по индексу;
    public void vectorComponentInstallation(double component, int index) {
        if (index > this.vectorArray.length) {
            return;
        }

        this.vectorArray[index] = component;
    }

    //Получение компоненты вектора по индексу;
    public double getVectorComponent(int index) {
        return this.vectorArray[index];
    }

    //Сложение двух векторов – должен создаваться новый вектор;
    public static Vector getVectorSum(Vector vector1, Vector vector2) {
        Vector vectorSum = new Vector(Math.max(vector1.vectorArray.length, vector2.vectorArray.length));

        for (int i = 0; i < vector1.vectorArray.length; i++) {
            vectorSum.vectorArray[i] += vector1.vectorArray[i];
        }

        for (int i = 0; i < vector2.vectorArray.length; i++) {
            vectorSum.vectorArray[i] += vector2.vectorArray[i];
        }

        return vectorSum;
    }

    //Вычитание векторов – должен создаваться новый вектор;
    public static Vector getVectorDifference(Vector vector1, Vector vector2) {
        Vector vectorDifference = new Vector(Math.max(vector1.vectorArray.length, vector2.vectorArray.length));

        for (int i = 0; i < vector1.vectorArray.length; i++) {
            vectorDifference.vectorArray[i] += vector1.vectorArray[i];
        }

        for (int i = 0; i < vector2.vectorArray.length; i++) {
            vectorDifference.vectorArray[i] -= vector2.vectorArray[i];
        }

        return vectorDifference;
    }

    // Скалярное произведение векторов;
    public static Vector getVectorScalarMultiplication(Vector vector1, Vector vector2) {
        if (vector1.vectorArray.length > vector2.vectorArray.length) {
            for (int i = 0; i < vector2.vectorArray.length; i++) {
                vector1.vectorArray[i] *= vector2.vectorArray[i];
            }

            return vector1;
        }

        for (int i = 0; i < vector2.vectorArray.length; i++) {
            vector2.vectorArray[i] *= vector1.vectorArray[i];
        }

        return vector2;
    }

    // Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Vector vector = (Vector) o;
        return n == vector.n && vectorArray == vector.vectorArray;
    }

    //Hash Code
    @Override
    public int hashCode() {
        final int PRIME = 21;
        int hash = 1;

        hash = PRIME * hash + n;
        hash = 31 * hash + Arrays.hashCode(vectorArray);

        return hash;
    }
}