package ru.academit.potyanikhin.singly_linked_list;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int size;

    // Получение размера списка
    public int getSize() {
        return size;
    }

    // Получение значение первого элемента
    public T getFirstItemData() {
        if (head == null) {
            throw new NullPointerException("The specified collection is null");
        }

        return head.getData();
    }

    // Получение значения по указанному индексу
    public T getData(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range, length is " + (size - 1));
        }

        return getItemByIndex(index).getData();
    }

    // Изменение значения по указанному индексу, пусть выдает старое значение
    public T setData(T data, int index) {
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range, length is " + (size - 1));
        }

        ListItem<T> item = getItemByIndex(index);

        T oldData = item.getData();
        item.setData(data);

        return oldData;
    }

    // Получение элемента по индексу
    public ListItem<T> getItemByIndex(int index) {
        ListItem<T> item;

        for (item = head; index != 0; item = item.getNext()) {
            index--;
        }

        return item;
    }

    // Удаление элемента по индексу, пусть выдает значение элемента
    public T removeByIndex(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range, length is " + (size - 1));
        }

        ListItem<T> currentItem = getItemByIndex(index);
        ListItem<T> previousItem = getItemByIndex(index - 1);

        T removedElementData = currentItem.getData();

        if (previousItem == null) {
            return removeFirstItem();
        }

        previousItem.setNext(currentItem.getNext());

        --size;

        return removedElementData;
    }

    // Вставка элемента в начало.
    public void add(T data) {
        head = new ListItem<>(data, head);

        ++size;
    }

    // Вставка элемента по индексу.
    public void add(T data, int index) {
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range, length is " + (size - 1));
        }

        ListItem<T> previousItem = getItemByIndex(index - 1);

        ListItem<T> item = new ListItem<>(data, previousItem.getNext());
        previousItem.setNext(item);

        ++size;
    }

    public void unlink(ListItem<T> currentItem, ListItem<T> previousItem) {
        if (previousItem == null) {
            removeFirstItem();

            return;
        }

        if (currentItem.getNext() == null) {
            previousItem.setNext(null);
            --size;

            return;
        }

        previousItem.setNext(currentItem.getNext());
        --size;
    }

    // Удаление узла по значению, пусть выдает true, если элемент был удален.
    public boolean removeByData(T data) {
        if (data == null) {
            for (ListItem<T> currentItem = head, previousItem = null; currentItem != null; previousItem = currentItem,
                    currentItem = currentItem.getNext()) {
                if (currentItem.getData() == null) {

                    unlink(currentItem, previousItem);

                    return true;
                }
            }

            return false;
        }

        for (ListItem<T> currentItem = head, previousItem = null; currentItem != null; previousItem = currentItem,
                currentItem = currentItem.getNext()) {
            if (currentItem.getData().equals(data)) {

                unlink(currentItem, previousItem);

                return true;
            }
        }

        return false;
    }

    // Удаление первого элемента, пусть выдает значение элемента.
    public T removeFirstItem() {
        if (head == null) {
            throw new NullPointerException("The specified collection is null");
        }

        T removedData = getFirstItemData();
        head = head.getNext();

        --size;

        return removedData;
    }

    // Разворот списка за линейное время.
    public void reverse() {
        ListItem<T> previousItem = null;
        ListItem<T> currentItem = head;

        while (currentItem != null) {
            ListItem<T> nextItem = currentItem.getNext();

            currentItem.setNext(previousItem);
            previousItem = currentItem;
            head = currentItem;

            currentItem = nextItem;
        }
    }

    // Копирование списка.
    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> copy = new SinglyLinkedList<>();

        for (ListItem<T> item = head; item != null; item = item.getNext()) {
            copy.add(item.getData());
        }

        copy.reverse();

        return copy;
    }
}