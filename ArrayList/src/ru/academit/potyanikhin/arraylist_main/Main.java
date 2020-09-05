package ru.academit.potyanikhin.arraylist_main;

import ru.academit.potyanikhin.arraylist.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();
        lines.add("111");
        lines.add("222");
        lines.add("777");
        lines.add("555");
        lines.add("666");
        lines.add("777");

        ArrayList<String> lines2 = new ArrayList<>();
        lines2.add("666");
        lines2.add("777");

        lines.retainAll(lines2);

        System.out.println(lines);
    }
}