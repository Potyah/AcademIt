package ru.academit.potyanikhin.arraylist;

import java.util.*;

public class ArrayList<T> implements List<T> {
    private T[] items;
    private int size;
    private int modCount;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        items = (T[]) new Object[10];
    }

    public ArrayList(Collection<? extends T> c) {
        if (c == null) {
            throw new NullPointerException("The specified collection is null");
        }

        //noinspection unchecked
        items = (T[]) c.toArray();
        size = c.size();
    }

    public ArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("The specified initial capacity is negative");
        }

        //noinspection unchecked
        items = (T[]) new Object[initialCapacity];
    }

    public void trimToSize() {
        if (size < items.length) {
            items = Arrays.copyOf(items, size);
        }
    }

    // Увеличить размер внутреннего массива, чтобы в него поместилось количество элементов, переданных в minCapacity
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > items.length) {
            items = Arrays.copyOf(items, minCapacity);
        }
    }

    // Добавить новый элемент в конец списка
    @Override
    public boolean add(T t) {
        if (size >= items.length) {
            if (size > 0) {
                ensureCapacity(size * 2);
            } else {
                ensureCapacity(10);
            }
        }

        add(0, t);

        return true;
    }

    // Добавить элемент в позицию index
    @Override
    public void add(int index, T t) {
        if (isIndexOutOfBounds(index)) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range. Length is " + size);
        }

        if (size >= items.length) {
            if (size > 0) {
                ensureCapacity(size * 2);
            } else {
                ensureCapacity(10);
            }
        }

        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = t;

        ++size;
        ++modCount;
    }

    // Добавить все элементы коллекции collection в список в порядке их расположения в collection
    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c == null) {
            throw new NullPointerException("The specified collection is null");
        }

        return addAll(items.length, c);
    }

    // Добавить все элементы collection в список начиная с индекса
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (c == null) {
            throw new NullPointerException("The specified collection is null");
        }

        if (isIndexOutOfBounds(index)) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range. Length is " + size);
        }

        ensureCapacity(items.length + c.size());

        System.arraycopy(items, index, items, index + c.size(), size - index);

        int i = index;

        for (T t : c) {
            items[i] = t;

            ++i;
        }

        size += c.size();

        ++modCount;

        return c.size() != 0;
    }

    // Удалить все элементы из списка
    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
            items[i] = null;

        size = 0;

        ++modCount;
    }

    // Проверка наличия объекта в списке
    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
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

    // Возвращение элемента, расположенного в указанной позиции списка
    @Override
    public T get(int index) {
        if (isIndexOutOfBounds(index)) {
            throw new IndexOutOfBoundsException("index " + index + " is out of range. Length is " + size);
        }

        return items[index];
    }

    // Замена элемента в указанной позиции index на переданный element
    @Override
    public T set(int index, T t) {
        if (isIndexOutOfBounds(index)) {
            throw new IndexOutOfBoundsException("index " + index + " is out of range. Length is " + size);
        }

        T result = items[index];
        items[index] = t;

        return result;
    }

    // Получение индекса первого вхождения элемента в списке
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, items[i])) {
                return i;
            }
        }

        return -1;
    }

    // Получение индекса последнего элемента в списке
    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--)
            if (Objects.equals(o, items[i])) {
                return i;
            }

        return -1;
    }

    // Получение размера массива
    @Override
    public int size() {
        return size;
    }

    // Метод возвращает true, если список пустой, false в обратном случае
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{ ");

        for (int i = 0; i < size; i++) {
            stringBuilder.append(items[i]).append(", ");
        }

        stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), " }");

        return stringBuilder.toString();
    }

    // Возвращение итератора для списка для последующего использования в цикле или при любой другой обработке
    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<T> {
        private int currentIndex = -1;
        private final int iteratorModCount = modCount;

        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        public T next() {
            if (iteratorModCount != modCount) {
                throw new ConcurrentModificationException("The collection element is changed");
            }

            if (!hasNext()) {
                throw new NoSuchElementException("The collection element is ended");
            }

            ++currentIndex;

            return items[currentIndex];
        }
    }

    // Удаление элемента в указанной позиции индекса
    @Override
    public T remove(int index) {
        if (isIndexOutOfBounds(index)) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range. Length is " + size);
        }

        T removedElement = items[index];

        if (index < size - 1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
        }

        items[size - 1] = null;
        --size;

        ++modCount;

        return removedElement;
    }

    // Удаление из списка переданного элемента
    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);

        if (index != -1) {
            remove(index);

            return true;
        }

        return false;
    }

    // Удаление коллекции элементов
    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("The specified collection is null");
        }

        boolean result = false;

        for (int i = 0; i < size; i++) {
            if (c.contains(items[i])) {
                remove(items[i]);
                i--;

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

        for (int i = 0; i < size; i++) {
            if (!c.contains(items[i])) {
                remove(items[i]);
                i--;

                result = true;
            }
        }

        return result;
    }

    // Превращение списка в фиксированный массив
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a == null) {
            throw new NullPointerException("The specified array is null");
        }

        if (a.length < size)
            //noinspection unchecked
            return (T1[]) Arrays.copyOf(items, size);

        //noinspection unchecked
        System.arraycopy(items, 0, (T[]) a, 0, size);

        if (a.length > size)
            a[size] = null;

        return a;
    }

    public boolean isIndexOutOfBounds(int index) {
        return index < 0 || index > size;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}