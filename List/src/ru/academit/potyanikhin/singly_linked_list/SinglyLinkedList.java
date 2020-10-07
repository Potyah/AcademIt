package ru.academit.potyanikhin.singly_linked_list;

import java.util.NoSuchElementException;
import java.util.Objects;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int size;

    // Получение размера списка
    public int getSize() {
        return size;
    }

    // Получение значение первого элемента
    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException("The specified collection is null");
        }

        return head.getData();
    }

    // Получение значения по указанному индексу
    public T getData(int index) {
        rangeCheck(index);

        return getItemByIndex(index).getData();
    }

    // Изменение значения по указанному индексу, пусть выдает старое значение
    public T setData(int index, T data) {
        rangeCheck(index);

        ListItem<T> item = getItemByIndex(index);

        T oldData = item.getData();
        item.setData(data);

        return oldData;
    }

    // Получение элемента по индексу
    private ListItem<T> getItemByIndex(int index) {
        ListItem<T> item;
        int i = index;

        for (item = head; i != 0; item = item.getNext()) {
            i--;
        }

        return item;
    }

    // Вставка элемента в начало.
    public void add(T data) {
        head = new ListItem<>(data, head);

        ++size;
    }

    // Вставка элемента по индексу.
    public void add(int index, T data) {
        rangeCheckForAdd(index);

        if (index == 0) {
            add(data);

            return;
        }

        ListItem<T> previousItem = getItemByIndex(index - 1);
        previousItem.setNext(new ListItem<>(data, previousItem.getNext()));

        ++size;
    }

    private void remove(ListItem<T> item) {
        if (item == null) {
            removeFirst();

            return;
        }

        item.setNext(item.getNext().getNext());
        --size;
    }

    // Удаление элемента по индексу, пусть выдает значение элемента
    public T removeByIndex(int index) {
        rangeCheck(index);

        if (index == 0) {
            return removeFirst();
        }

        ListItem<T> previousItem = getItemByIndex(index - 1);
        ListItem<T> currentItem = previousItem.getNext();

        T removedData = currentItem.getData();
        previousItem.setNext(currentItem.getNext());

        --size;

        return removedData;
    }

    // Удаление узла по значению, пусть выдает true, если элемент был удален.
    public boolean removeByData(T data) {
        for (ListItem<T> currentItem = head, previousItem = null; currentItem != null; previousItem = currentItem,
                currentItem = currentItem.getNext()) {
            if (Objects.equals(currentItem.getData(), data)) {

                remove(previousItem);

                return true;
            }
        }

        return false;
    }

    // Удаление первого элемента, пусть выдает значение элемента.
    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("The specified collection is null");
        }

        T removedData = head.getData();
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
        int i = 0;

        for (ListItem<T> item = head; item != null; item = item.getNext()) {
            copy.add(i, item.getData());
            i++;
        }

        return copy;
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > getSize()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range, permissible value from 0 to " + size);
        }
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range, permissible value from 0 to " + (size - 1));
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "{ }";
        }

        StringBuilder stringBuilder = new StringBuilder("{");

        for (int i = 0; i < size; i++) {
            stringBuilder.append(getItemByIndex(i).getData()).append(", ");
        }

        stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "}");

        return stringBuilder.toString();
    }
}