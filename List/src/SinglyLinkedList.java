public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    // Получение размера списка.
    public int getSize() {
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            count++;
        }

        return count;
    }

    // Получение значение первого элемента.
    public T getFirstElementData() {
        return head.getData();
    }

    // Получение значения по указанному индексу.
    public T getDataOnIndex(int index) {
        if (index > getSize()) {
            throw new IllegalArgumentException("Индекс " + index  + " больше длинны списка");
        }

        ListItem<T> p = head;
        for (int i = 0; i != index; i++) {
            p = p.getNext();
        }

        return p.getData();
    }

    // Изменение значения по указанному индексу, пусть выдает старое значение.
    public T setByIndex(int index, T data) {
        ListItem<T> p;

        for (p = head; index != 0; p = p.getNext()) {
            index--;
        }

        T oldData = p.getData();
        p.setData(data);

        return oldData;
    }

    // Удаление элемента по индексу, пусть выдает значение элемента.
    public T removeByIndex(int index) {
        ListItem<T> p;
        ListItem<T> previous;

        for (p = head, previous = null; index != 0; previous = p, p = p.getNext()) {
            index--;
        }

        T removedElementData = p.getData();

        if (previous == null) {
            return removeFirstElement();
        }

        previous.setNext(p.getNext());

        return removedElementData;
    }

    // Вставка элемента в начало.
    public void addFirst(T data) {
        ListItem<T> p = new ListItem<>(data, head);
        head = p;
    }

    // Вставка элемента по индексу.
    public void addByIndex(T data, int index) {
        ListItem<T> p;

        for (p = head; index != 1; p = p.getNext()) {
            index--;
        }

        ListItem<T> q = new ListItem<>(data, p.getNext());
        p.setNext(q);
    }

    // Удаление узла по значению, пусть выдает true, если элемент был удален.
    public boolean isRemoveByData(T data) {
        boolean isEqualsData = false;

        for (ListItem<T> p = head, prev = null; p != null; prev = p, p = p.getNext()) {
            if (p.getData().equals(data)) {
                if (prev == null) {
                    removeFirstElement();
                } else if (p.getNext() == null) {
                    prev.setNext(null);
                } else {
                    prev.setNext(p.getNext());
                }

                isEqualsData = true;
            }
        }

        return isEqualsData;
    }

    // Удаление первого элемента, пусть выдает значение элемента.
    public T removeFirstElement() {
        T removedData = getFirstElementData();
        head = head.getNext();

        return removedData;
    }

    // Разворот списка за линейное время.
    public void reverse() {
        ListItem<T> previous = null;
        ListItem<T> current = head;
        ListItem<T> forward;

        while (current != null) {
            forward = current.getNext();

            current.setNext(previous);
            previous = current;
            head = current;

            current = forward;
        }
    }

    // Копирование списка.
    public void copy(SinglyLinkedList<T> original) {
   /*     ListItem<T> copy = new SinglyLinkedList<>();

        LinkedListTest nextCopy = original.getNext();
        LinkedListTest current = copy;

        while (nextCopy != null) {

            LinkedListTest newCopy = new LinkedListTest(nextCopy.getData() + " copied");
            newCopy.setNext(nextCopy.getNext());

            current.setNext(newCopy);

            current = newCopy;
            nextCopy = newCopy.getNext();
        }

        return copy;
    } */


    }
}

