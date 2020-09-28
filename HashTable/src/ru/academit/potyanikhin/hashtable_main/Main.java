package ru.academit.potyanikhin.hashtable_main;

import ru.academit.potyanikhin.hashtable.HashTable;

public class Main {
    public static void main(String[] args) {
        HashTable<Integer> hashTable1 = new HashTable<>();
        hashTable1.add(4);
        hashTable1.add(56);
        hashTable1.add(2);

        HashTable<Integer> hashTable2 = new HashTable<>(5);
        hashTable2.add(4);
        hashTable2.add(56);
        hashTable2.add(2);
        hashTable2.add(4574);
        hashTable2.add(5367);

        hashTable1.retainAll(hashTable2);
        System.out.println(hashTable1);

        hashTable2.clear();
        System.out.println(hashTable2);
    }
}
