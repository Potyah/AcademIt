package ru.academit.potyanikhin.vector;


import java.util.Arrays;

public class Vector {
    // Поля
    private double[] vectorComponents;

    // Конструктор с нулевыми компонентами;
    public Vector(int n) {
        vectorComponents = new double[n];
    }

    // Заполнение вектора значениями из массива;
    public Vector(double[] vectorComponents) {
        this.vectorComponents = Arrays.copyOf(vectorComponents, vectorComponents.length);
    }

    // Заполнение вектора значениями из массива. Если длина массива меньше n, то считать что в остальных компонентах 0;
    public Vector(int n, double[] vectorComponents) {
        this.vectorComponents = new double[n];

        System.arraycopy(vectorComponents, 0, this.vectorComponents, 0, vectorComponents.length);
    }

    // Конструктор копирования;
    public Vector(Vector vector) {
        this.vectorComponents = Arrays.copyOf(vector.vectorComponents, vector.vectorComponents.length);
    }

    // toString;
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < vectorComponents.length; i++) {
            string.append(vectorComponents[i]);

            if (i == vectorComponents.length - 1) {
                break;
            }

            string.append(", ");
        }

        return "{ " + string + " }";
    }

    // Метод для получения размерности вектора;
    public int getSize() {
        return vectorComponents.length;
    }

    // Прибавление к вектору другого вектора;
    public void vectorAddition(Vector vector) {
        if (this.vectorComponents.length < vector.vectorComponents.length) {
            this.vectorComponents.length = vector.getSize();

            Vector tempVector = new Vector(vector.vectorComponents.length, this.vectorComponents);
            this.vectorComponents = tempVector.vectorComponents;

            for (int i = 0; i < vector.vectorComponents.length; i++) {
                this.vectorComponents[i] += vector.vectorComponents[i];
            }

            return;
        }

        for (int i = 0; i < vector.vectorComponents.length; i++) {
            this.vectorComponents[i] += vector.vectorComponents[i];
        }
    }

    // Вычитание из вектора другого вектора;
    public void vectorDifference(Vector vector) {
        if (this.vectorComponents.length < vector.vectorComponents.length) {
            Vector tempVector = new Vector(vector.vectorComponents.length, this.vectorComponents);
            this.vectorComponents = tempVector.vectorComponents;

            for (int i = 0; i < vector.vectorComponents.length; i++) {
                this.vectorComponents[i] -= vector.vectorComponents[i];
            }

            return;
        }

        for (int i = 0; i < vector.vectorComponents.length; i++) {
            this.vectorComponents[i] -= vector.vectorComponents[i];
        }
    }

    // Умножение вектора на скаляр;
    public void scalarMultiplication(double scalar) {
        for (int i = 0; i < this.vectorComponents.length; i++) {
            this.vectorComponents[i] *= scalar;
        }
    }

    //Разворот вектора;
    public void reverse() {
        scalarMultiplication(-1);
    }

    // Получение длины вектора;
    public double getVectorLength() {
        double vectorLength = 0;

        for (double i : this.vectorComponents) {
            vectorLength += i;
        }

        return Math.abs(vectorLength);
    }

    //Установка компоненты вектора по индексу;
    public void vectorComponentInstallation(double component, int index) {
        if (index > this.vectorComponents.length) {
            return;
        }

        this.vectorComponents[index] = component;
    }

    //Получение компоненты вектора по индексу;
    public double setComponent(int index) {
        return this.vectorComponents[index];
    }

    //Сложение двух векторов – должен создаваться новый вектор;
    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector vectorSum = new Vector(Math.max(vector1.vectorComponents.length, vector2.vectorComponents.length));

        for (int i = 0; i < vector1.vectorComponents.length; i++) {
            vectorSum.vectorComponents[i] += vector1.vectorComponents[i];
        }

        for (int i = 0; i < vector2.vectorComponents.length; i++) {
            vectorSum.vectorComponents[i] += vector2.vectorComponents[i];
        }

        return vectorSum;
    }

    //Вычитание векторов – должен создаваться новый вектор;
    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector vectorDifference = new Vector(Math.max(vector1.vectorComponents.length, vector2.vectorComponents.length));

        for (int i = 0; i < vector1.vectorComponents.length; i++) {
            vectorDifference.vectorComponents[i] += vector1.vectorComponents[i];
        }

        for (int i = 0; i < vector2.vectorComponents.length; i++) {
            vectorDifference.vectorComponents[i] -= vector2.vectorComponents[i];
        }

        return vectorDifference;
    }

    // Скалярное произведение векторов;
    public static double getScalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = 0;

        if (vector1.vectorComponents.length > vector2.vectorComponents.length) {
            for (int i = 0; i < vector2.vectorComponents.length; i++) {
                scalarProduct = vector1.vectorComponents[i] * vector2.vectorComponents[i];
            }

            return scalarProduct;
        }

        for (int i = 0; i < vector2.vectorComponents.length; i++) {
            scalarProduct = vector2.vectorComponents[i] * vector1.vectorComponents[i];
        }

        return scalarProduct;
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
        return vectorComponents == vector.vectorComponents;
    }

    //Hash Code
    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + Arrays.hashCode(vectorComponents);

        return hash;
    }
}