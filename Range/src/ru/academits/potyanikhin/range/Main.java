package ru.academits.potyanikhin.range;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(1.5, 7.6);

        double number = 5.6;

        if (range.isInside(number)) {
            System.out.println("Число " + number + " принадлежит заданному диапазону");
        } else {
            System.out.println("Число " + number + " не принадлежит заданному диапазону");
        }

        System.out.println("Длинна отрезка: " + range.getLength());
    }
}