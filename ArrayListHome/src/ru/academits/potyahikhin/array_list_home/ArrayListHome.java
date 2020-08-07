package ru.academits.potyahikhin.array_list_home;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListHome {
    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileInputStream("input.txt"), "windows-1251")) {
            ArrayList<String> list = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                String[] splitString = string.split(" ");

                Collections.addAll(list, splitString);
            }

            System.out.println(list);
        }

        ArrayList<Integer> integersList = new ArrayList<>();
        integersList.add(1);
        integersList.add(2);
        integersList.add(3);
        integersList.add(4);
        integersList.add(5);
        integersList.add(6);

        for (int i = 0; i < integersList.size(); i++) {
            if (integersList.get(i) % 2 == 0) {
                integersList.remove(i);
            }
        }

        System.out.println(integersList);

        ArrayList<Integer> integersList2 = new ArrayList<>();
        integersList2.add(1);
        integersList2.add(5);
        integersList2.add(2);
        integersList2.add(1);
        integersList2.add(3);
        integersList2.add(5);

        for (int i = 0; i < integersList2.size(); i++) {
            for (int j = i + 1; j < integersList2.size(); j++) {
                if (integersList2.get(i).equals(integersList2.get(j))) {
                    integersList2.remove(j);
                }
            }
        }

        System.out.println(integersList2);
    }
}