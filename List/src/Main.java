public class Main {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>() ;
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addFirst(0);


        //SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
       // list2.copy(list);

        System.out.println(345);

        list.reverse();


        System.out.println(list.getDataOnIndex(0));
        System.out.println(list.getDataOnIndex(1));
        System.out.println(list.getDataOnIndex(2));
        System.out.println(list.getDataOnIndex(3));
        System.out.println(list.getDataOnIndex(4));


    }

}
