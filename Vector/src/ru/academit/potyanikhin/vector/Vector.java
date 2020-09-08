package ru.academit.potyanikhin.vector;

import java.util.Arrays;

public class Vector {
    // Поля
    private double[] components;

    // Конструктор с нулевыми компонентами;
    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Длинна вектора равна " + size + ". Значение должно быть больше нуля");
        }

        components = new double[size];
    }

    // Заполнение вектора значениями из массива;
    public Vector(double[] components) {
        if (components.length == 0) {
            throw new IllegalArgumentException("Длинна массива равна " + components.length + ". Значение должно быть больше нуля");
        }

        this.components = Arrays.copyOf(components, components.length);
    }

    // Заполнение вектора значениями из массива. Если длина массива меньше n, то считать что в остальных компонентах 0;
    public Vector(int size, double[] components) {
        if (size <= 0) {
            throw new IllegalArgumentException("Длинна вектора равна " + size + ". Значение должно быть больше нуля");
        }

        this.components = Arrays.copyOf(components, size);
    }

    // Конструктор копирования;
    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    // toString;
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{ ");

        for (double e : components) {
            stringBuilder.append(e).append(", ");
        }

        stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), " }");

        return stringBuilder.toString();
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

    //Получение компоненты вектора по индексу;
    public double getComponent(int index) {
        return components[index];
    }

    //Установка компоненты вектора по индексу;
    public void setComponent(int index, double component) {
        components[index] = component;
    }

    //Сложение двух векторов – должен создаваться новый вектор;
    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector vectorsSum = new Vector(vector1);
        vectorsSum.add(vector2);

        return vectorsSum;
    }

    //Вычитание векторов – должен создаваться новый вектор;
    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector vectorsDifference = new Vector(vector1);
        vectorsDifference.subtract(vector2);

        return vectorsDifference;
    }

    // Скалярное произведение векторов;
    public static double getScalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = 0;
        int minLength = Math.min(vector1.components.length, vector2.components.length);

        for (int i = 0; i < minLength; i++) {
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