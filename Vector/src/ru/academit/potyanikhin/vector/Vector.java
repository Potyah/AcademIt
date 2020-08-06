package ru.academit.potyanikhin.vector;

import java.util.Arrays;

public class Vector {
    // Поля
    private double[] vectorComponents;

    // Конструктор с нулевыми компонентами;
    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Длинна вектора должа быть больше нуля");
        }

        vectorComponents = new double[n];
    }

    // Заполнение вектора значениями из массива;
    public Vector(double[] vectorComponents) {
        this.vectorComponents = Arrays.copyOf(vectorComponents, vectorComponents.length);
    }

    // Заполнение вектора значениями из массива. Если длина массива меньше n, то считать что в остальных компонентах 0;
    public Vector(int n, double[] vectorComponents) {
        if (n <= 0) {
            throw new IllegalArgumentException("Длинна вектора должа быть больше нуля");
        }

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
        StringBuilder string = new StringBuilder("{ ");

        for (int i = 0; i < vectorComponents.length; i++) {
            string.append(vectorComponents[i]);

            if (i == vectorComponents.length - 1) {
                string.append(" }");

                break;
            }

            string.append(", ");
        }

        return "" + string;
    }

    // Метод для получения размерности вектора;
    public int getSize() {
        return vectorComponents.length;
    }

    // Прибавление к вектору другого вектора;
    public void add(Vector vector) {
        if (vectorComponents.length < vector.vectorComponents.length) {
            vectorComponents = Arrays.copyOf(vectorComponents, vector.vectorComponents.length);
        }

        for (int i = 0; i < vector.vectorComponents.length; i++) {
            vectorComponents[i] += vector.vectorComponents[i];
        }
    }

    // Вычитание из вектора другого вектора;
    public void subtract(Vector vector) {
        if (vectorComponents.length < vector.vectorComponents.length) {
            vectorComponents = Arrays.copyOf(vectorComponents, vector.vectorComponents.length);
        }

        for (int i = 0; i < vector.vectorComponents.length; i++) {
            vectorComponents[i] -= vector.vectorComponents[i];
        }
    }

    // Умножение вектора на скаляр;
    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < vectorComponents.length; i++) {
            vectorComponents[i] *= scalar;
        }
    }

    //Разворот вектора;
    public void deploy() {
        multiplyByScalar(-1);
    }

    // Получение длины вектора;
    public double getLength() {
        double componentsPowSum = 0;

        for (double e : vectorComponents) {
            componentsPowSum += Math.pow(e, 2);
        }

        return Math.sqrt(componentsPowSum);
    }

    //Установка компоненты вектора по индексу;
    public void setComponent(double component, int index) {
        vectorComponents[index] = component;
    }

    //Получение компоненты вектора по индексу;
    public double getComponent(int index) {
        return vectorComponents[index];
    }

    //Сложение двух векторов – должен создаваться новый вектор;
    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector vectorSum = new Vector(vector1);
        vectorSum.add(vector2);

        return vectorSum;
    }

    //Вычитание векторов – должен создаваться новый вектор;
    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector vectorDifference = new Vector(vector1);
        vectorDifference.add(vector2);

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
        return Arrays.equals(vectorComponents, vector.vectorComponents);
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