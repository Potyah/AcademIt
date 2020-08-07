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
    }
}