package ru.atademit.potyanikhin.lambda_pow_flow;

import java.util.Scanner;
import java.util.stream.IntStream;

public class PowFlow {

    public static void main(String[] args) {
        //Создать бесконечный поток корней чисел. С консоли прочитать число – сколько элементов нужно вычислить,
        //затем – распечатать эти элементы.
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите колличество элементов, необходимое для вывода в консоль:");
        int limit = scanner.nextInt();

        IntStream.iterate(0, x -> x < limit, x -> x + 1).mapToDouble(Math::sqrt).forEach(System.out::println);
    }
}