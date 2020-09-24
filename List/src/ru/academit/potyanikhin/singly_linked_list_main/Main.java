package ru.academit.potyanikhin.singly_linked_list_main;

import ru.academit.potyanikhin.singly_linked_list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list);

        list.reverse();
        System.out.println(list);

        System.out.println(list.removeByData(null));
        System.out.println(list);
    }
}