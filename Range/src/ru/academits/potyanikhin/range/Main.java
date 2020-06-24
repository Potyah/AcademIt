package ru.academits.potyanikhin.range;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(2, 8);
        Range range2 = new Range(8, 10);

        double number = 5.6;

        if (range1.isInside(number)) {
            System.out.println("Число " + number + " принадлежит заданному диапазону");
        } else {
            System.out.println("Число " + number + " не принадлежит заданному диапазону");
        }

        System.out.println("Длинна отрезка: " + range1.getLength());

        System.out.println("Пересечение данных интервалов: " + range1.getCrossInterval(range2));

        System.out.println("Объединение данных интервалов: " + range1.getUnionInterval(range2));

        System.out.println("Разность данных интервалов: " + range1.getDifferenceInterval(range2));
    }
}