import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4, 55));

        HashTable<Integer> hashTable = new HashTable<>(10);

        hashTable.add(4);
        hashTable.add(56);
        hashTable.add(2);
        hashTable.add(4574);
        hashTable.add(5367);
        hashTable.add(45446789);
        hashTable.add(55);
        hashTable.add(4745);
        hashTable.add(43564);

        System.out.println(hashTable);

      //  hashTable.retainAll(list);
    //    System.out.println(hashTable);

        for (Integer t : hashTable) {
            System.out.println(t);
        }






    }
}
