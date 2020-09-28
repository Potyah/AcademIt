package ru.academit.potyanikhin.hashtable;

import java.util.*;

public class HashTable<T> implements Collection<T> {
    private int size;
    private final ArrayList<T>[] array;

    @SuppressWarnings("unchecked")
    public HashTable() {
        array = new ArrayList[10];
    }

    @SuppressWarnings("unchecked")
    public HashTable(int length) {
        array = new ArrayList[length];
    }

    public int getIndex(Object o) {
        return Math.abs(hashCode(o) % array.length);
    }

    public int hashCode(Object o) {
        return Objects.hashCode(o);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<T> {
        private int arrayIndex = 0;
        private int collectionIndex = -1;
        private int count = 0;

        public boolean hasNext() {
            return count < size;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("The collection element is ended");
            }

            while ((array[arrayIndex] == null) || (array[arrayIndex].size() <= collectionIndex + 1)) {
                ++arrayIndex;
                collectionIndex = -1;
            }

            ++collectionIndex;
            ++count;

            return array[arrayIndex].get(collectionIndex);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object[] toArray() {
        T[] dataArray = (T[]) new Object[size];
        int i = 0;

        for (T t : this) {
            dataArray[i] = t;
            i++;
        }

        return dataArray;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a == null) {
            throw new NullPointerException("The specified array is null");
        }

        if (a.length > size) {
            int i = 0;

            for (T t : this) {
                //noinspection unchecked
                a[i] = (T1) t;

                i++;
            }

            return a;
        }

        //noinspection unchecked
        return (T1[]) this.toArray();
    }

    @Override
    public boolean add(T t) {
        int index = getIndex(t);

        if (array[index] == null) {
            array[index] = new ArrayList<>();
        }

        array[index].add(t);

        size++;

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c == null) {
            throw new NullPointerException("The specified collection is null");
        }

        for (T t : c) {
            add(t);
        }

        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (contains(o)) {
            int index = getIndex(o);

            size--;

            return array[index].remove(o);
        }

        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("The specified collection is null");
        }

        boolean result = false;

        for (Object o : c) {
            if (contains(o)) {
                remove(o);
                result = true;
            }
        }

        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("The specified collection is null");
        }

        boolean result = false;
        ArrayList<T> list = new ArrayList<>();

        for (T t : this) {
            if (!c.contains(t)) {
                list.add(t);
                result = true;
            }
        }

        if (result) {
            removeAll(list);
        }

        return result;
    }

    @Override
    public boolean contains(Object o) {
        int index = getIndex(o);

        if (array[index] == null) {
            return false;
        }

        return array[index].contains(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("The specified collection is null");
        }

        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}