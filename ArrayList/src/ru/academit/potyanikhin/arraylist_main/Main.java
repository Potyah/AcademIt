package ru.academit.potyanikhin.arraylist_main;

import ru.academit.potyanikhin.arraylist.ArrayList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> lines1 = new ArrayList<>(6);
        lines1.add(111);
        lines1.add(77);
        lines1.add(66);
        lines1.add(3, 7565);

        System.out.println(lines1);

        ArrayList<Integer> lines2 = new ArrayList<>(Arrays.asList(111, 11, 666, 444, 222));
        System.out.println(lines2);

        ArrayList<Integer> lines3 = new ArrayList<>(lines1);
        System.out.println(lines3);

        System.out.println(lines1.size());
    }
}