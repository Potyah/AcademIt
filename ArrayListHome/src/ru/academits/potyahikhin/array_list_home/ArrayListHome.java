package ru.academits.potyahikhin.array_list_home;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHome {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileInputStream("input.txt"), "windows-1251")) {
            ArrayList<String> stringsList = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                stringsList.add(string);
            }

            System.out.println(stringsList);
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка. Файл не найден.");
        }

        ArrayList<Integer> integerNumbersList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        for (int i = 0; i < integerNumbersList.size(); i++) {
            if (integerNumbersList.get(i) % 2 == 0) {
                integerNumbersList.remove(i);

                i--;
            }
        }

        System.out.println(integerNumbersList);

        ArrayList<Integer> integerNumbersListWithRecurrence = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5));
        ArrayList<Integer> integerNumberListWithoutRecurrence = new ArrayList<>();

        for (Integer e : integerNumbersListWithRecurrence) {

            if (!integerNumberListWithoutRecurrence.contains(e)) {
                integerNumberListWithoutRecurrence.add(e);
            }
        }

        System.out.println(integerNumbersListWithRecurrence);
        System.out.println(integerNumberListWithoutRecurrence);
    }
}