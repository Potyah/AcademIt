package ru.academit.potyanikhin.singly_linced_list;

import ru.academit.potyanikhin.singly_linced_list_item.ListItem;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int size;

    // Получение размера списка.
    public int getSize() {
        return size;
    }

    // Получение значение первого элемента.
    public T getData() {
        return head.getData();
    }

    // Получение значения по указанному индексу.
    public T getData(int index) {
        if (index < 0 || index > getSize()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range");
        }

        ListItem<T> p = head;

        for (int i = 0; i != index; i++) {
            p = p.getNext();
        }

        return p.getData();
    }

    // Изменение значения по указанному индексу, пусть выдает старое значение.
    public T seData(int index, T data) {
        if (index < 0 || index > getSize()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range");
        }

        ListItem<T> p;

        for (p = head; index != 0; p = p.getNext()) {
            index--;
        }

        T oldData = p.getData();
        p.setData(data);

        return oldData;
    }

    // Удаление элемента по индексу, пусть выдает значение элемента.
    public T remove(int index) {
        if (index < 0 || index > getSize()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range");
        }

        ListItem<T> p;
        ListItem<T> previous;

        for (p = head, previous = null; index != 0; previous = p, p = p.getNext()) {
            index--;
        }

        T removedElementData = p.getData();

        if (previous == null) {
            return remove();
        }

        previous.setNext(p.getNext());

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
        if (index < 0 || index > getSize()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range");
        }

        ListItem<T> p;

        for (p = head; index != 1; p = p.getNext()) {
            index--;
        }

        ListItem<T> q = new ListItem<>(data, p.getNext());
        p.setNext(q);

        ++size;
    }

    // Удаление узла по значению, пусть выдает true, если элемент был удален.
    public boolean isRemove(T data) {
        for (ListItem<T> p = head, prev = null; p != null; prev = p, p = p.getNext()) {
            if (p.getData().equals(data)) {
                if (prev == null) {
                    remove();

                    return true;
                } else if (p.getNext() == null) {
                    prev.setNext(null);

                    return true;
                } else {
                    prev.setNext(p.getNext());

                    --size;

                    return true;
                }
            }
        }

        return false;
    }

    // Удаление первого элемента, пусть выдает значение элемента.
    public T remove() {
        T removedData = getData();
        head = head.getNext();

        --size;

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
    public void copy(SinglyLinkedList<T> list) {
        if (list == null) {
            throw new NullPointerException("The specified collection is null");
        }

        ListItem<T> copy = head;
        size = list.getSize();

        for (ListItem<T> p = list.head; p != null; p = p.getNext(), copy = copy.getNext()) {
            copy.setData(p.getData());
            copy.setNext(p.getNext());
        }
    }
}