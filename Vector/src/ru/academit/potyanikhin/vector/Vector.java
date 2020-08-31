package ru.academit.potyanikhin.vector;

import java.util.Arrays;

public class Vector {
    // Поля
    private double[] components;

    // Конструктор с нулевыми компонентами;
    public Vector(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Длинна вектора равна " + length + ". Значение должно быть больше нуля");
        }

        components = new double[length];
    }

    // Заполнение вектора значениями из массива;
    public Vector(double[] components) {
        this.components = Arrays.copyOf(components, components.length);
    }

    // Заполнение вектора значениями из массива. Если длина массива меньше n, то считать что в остальных компонентах 0;
    public Vector(int length, double[] components) {
        if (length <= 0) {
            throw new IllegalArgumentException("Длинна вектора равна " + length + ". Значение должно быть больше нуля");
        }

        this.components = Arrays.copyOf(components, length);
    }

    // Конструктор копирования;
    public Vector(Vector vector) {
        this.components = Arrays.copyOf(vector.components, vector.components.length);
    }

    // toString;
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("{ ");

        for (double e : components) {
            string.append(e).append(", ");
        }

        string.replace(string.length() - 2, string.length(), " }");

        return String.valueOf(string);
    }

    // Метод для получения размерности вектора;
    public int getSize() {
        return components.length;
    }

    // Прибавление к вектору другого вектора;
    public void add(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] += vector.components[i];
        }
    }

    // Вычитание из вектора другого вектора;
    public void subtract(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] -= vector.components[i];
        }
    }

    // Умножение вектора на скаляр;
    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }

    //Разворот вектора;
    public void reverse() {
        multiplyByScalar(-1);
    }

    // Получение длины вектора;
    public double getLength() {
        double componentsPowSum = 0;

        for (double e : components) {
            componentsPowSum += Math.pow(e, 2);
        }

        return Math.sqrt(componentsPowSum);
    }

    //Установка компоненты вектора по индексу;
    public void setComponent(int index, double component) {
        components[index] = component;
    }

    //Получение компоненты вектора по индексу;
    public double getComponent(int index) {
        return components[index];
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
        vectorDifference.subtract(vector2);

        return vectorDifference;
    }

    // Скалярное произведение векторов;
    public static double getScalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = 0;

        for (int i = 0; i < Math.min(vector1.components.length, vector2.components.length); i++) {
            scalarProduct += vector1.components[i] * vector2.components[i];
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
        return Arrays.equals(components, vector.components);
    }

    //Hash Code
    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + Arrays.hashCode(components);

        return hash;
    }
}