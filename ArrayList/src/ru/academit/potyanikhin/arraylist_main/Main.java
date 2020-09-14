package ru.academit.potyanikhin.arraylist_main;

import ru.academit.potyanikhin.arraylist.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>(5);
        lines.add("111");
        lines.add("222");
        lines.add("777");
        lines.add("555");
        lines.add("666");
        lines.add("777");
        lines.add(6,"0000");

        System.out.println(lines);

        ArrayList<String> lines2 = new ArrayList<>();
        lines2.add("000776700");
        lines2.add("700000077");


      //  lines.addAll(7, lines2);
        System.out.println(lines);
        System.out.println(lines.removeAll(lines2));
        System.out.println(lines);


  //      ArrayList<String> lines3 = new ArrayList<>(0);

  //      lines.retainAll(lines2);

    //    System.out.println(lines3);
  //      lines3.add("111");

 //       System.out.println(lines3);
    }
}