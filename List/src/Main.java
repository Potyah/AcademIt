public class Main {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>() ;
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addFirst(0);


        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
        list.copy(list2);


        System.out.println(list2.getDataOnIndex(0));
        System.out.println(list2.getDataOnIndex(1));
        System.out.println(list2.getDataOnIndex(2));
        System.out.println(list2.getDataOnIndex(3));
        System.out.println(list2.getDataOnIndex(4));


    }

}
