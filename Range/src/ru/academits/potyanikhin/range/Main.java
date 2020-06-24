package ru.academits.potyanikhin.range;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(3, 8);
        Range range2 = new Range(4, 9);

        double number = 5.6;

        System.out.println(range1);


        if (range1.isInside(number)) {
            System.out.println("Число " + number + " принадлежит заданному диапазону");
        } else {
            System.out.println("Число " + number + " не принадлежит заданному диапазону");
        }

        System.out.println("Длинна отрезка: " + range1.getLength());

        range1.getCrossInterval(range2);
        System.out.println("Интервал пересечения данных интервалов от " + range1.getFrom() + " до " + range1.getTo());


    }
}