package ru.academit.potyanikhin.arraylist;

import java.util.*;
import java.util.function.UnaryOperator;


public class ArrayList<T> implements List<T> {
    private T[] items;
    private int size;
    int modCount;

    public ArrayList() {
        this.items = (T[]) new Object[10];
    }

    public ArrayList(Collection<? extends T> c) {
        if (c == null) {
            throw new NullPointerException("The specified collection is null");
        }

        items = Arrays.copyOf((T[]) c.toArray(), c.size());
        size = c.size();
    }

    public ArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("The specified initial capacity is negative");
        }

        this.items = (T[]) new Object[initialCapacity];
    }

    public void trimToSize() {
        if (size < items.length) {
            items = Arrays.copyOf(items, size);
        }
    }

    // Увеличивает размер внутреннего массива, чтобы в него поместилось количество элементов, переданных в minCapacity;
    private void ensureCapacity(int minCapacity) {
        items = Arrays.copyOf(items, minCapacity * 2);
    }

    // Добавляет новый элемент в конец списка. Возвращает boolean-значение;
    @Override
    public boolean add(T t) {
        if (size >= items.length) {
            ensureCapacity(items.length);
        }

        items[size] = t;
        ++size;

        ++modCount;

        return true;
    }

    //Добавляет элемент element в позицию index. При добавлении происходит сдвиг всех элементов справа от указанного индекса на 1 позицию вправо;
    @Override
    public void add(int index, T element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range");
        }

        if (size + 1 >= items.length) {
            ensureCapacity(items.length);
        }

        System.arraycopy(items, index, items, index + 1, size - index + 1);
        items[index] = element;

        ++size;
        ++modCount;
    }

    //Добавление всех элементов коллекции collection в список в порядке их расположения в collection
    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c == null) {
            throw new NullPointerException("The specified collection is null");
        }

        if (size + c.size() + 1 >= items.length) {
            ensureCapacity(items.length + c.size());
        }

        for (T element : c) {
            add(element);
            ++size;
        }

        ++modCount;

        return true;
    }

    //Добавление всех элементов collection в список начиная с индекса index. При этом все элементы сдвинутся вправо на количество элементов в списке collection
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (c == null) {
            throw new NullPointerException("The specified collection is null");
        }

        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range");
        }

        if (size + c.size() + 1 >= items.length) {
            ensureCapacity(items.length + c.size());
        }

        System.arraycopy(items, index, items, index + c.size(), size - index + 1 + c.size());

        for (T element : c) {
            items[index] = element;

            ++index;
        }

        size += c.size();

        ++modCount;

        return true;
    }

    //Удаление всех элементов из списка.
    @Override
    public void clear() {
        items = null;
        items = (T[]) new Object[10];
        size = 0;

        ++modCount;
    }

    //Проверка наличие объекта в списке, возвращает boolean-значение.
    @Override
    public boolean contains(Object o) {
        for (T e : items) {
            if (Objects.equals(o, e)) {
                return true;
            }
        }

        return false;
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

    // Возвращает элемент, который расположен в указанной позиции списка.
    @Override
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index " + index + " is out of range");
        }

        return items[index];
    }

    // Метод возвращает индекс первого вхождения элемента в списке. Если элемента не существует в списке, метод вернет -1.
    @Override
    public int indexOf(Object o) {
        int i = 0;

        for (T e : items) {
            if (Objects.equals(o, e)) {
                return i;
            }

            i++;
        }

        return -1;
    }

    // Метод возвращает true, если список пустой, false в обратном случае.
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "{" + Arrays.toString(items) +
                '}' + " Длинна - " + size;
    }

    // Возвращает итератор для списка для последующего использования в цикле или при любой другой обработке.
    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<T> {
        private int currentIndex = -1;
        private final int iteratorModCount = ArrayList.this.modCount;

        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        public T next() {
            if (iteratorModCount != ArrayList.this.modCount) {
                throw new ConcurrentModificationException("The collection element is changed");
            }

            if (currentIndex == size - 1) {
                throw new NoSuchElementException("The collection element is ended");
            }

            ++currentIndex;

            return items[currentIndex];
        }
    }

    //возвращается индекс последнего элемента в списке. Если элемент не найден, также возвращает -1.
    @Override
    public int lastIndexOf(Object o) {
        int lastIndex = -1;
        int i = 0;

        for (T e : items) {
            if (Objects.equals(o, e)) {
                lastIndex = i;
            }

            i++;
        }

        return lastIndex;
    }

    //Удаление элемента в указанной позиции индекса. После удаления сдвигает все элементы влево для заполнения освободившегося пространства.
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range");
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

    //Метод удаляет из списка переданный элемент o. Если элемент присутствует в списке, он удаляется, а все элементы смещаются влево.
// Если элемент существует в списке и успешно удален, метод возвращает true, в обратном случае — false.
    @Override
    public boolean remove(Object o) {
        int i = 0;

        for (T e : items) {
            if (Objects.equals(o, e)) {
                remove(i);

                ++modCount;

                return true;
            }

            ++i;
        }

        return false;
    }

    // Метод принимает коллекцию элементов, которая будет удалена из списка.
    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("The specified collection is null");
        }

        boolean isRemoved = false;

        for (Object o : c) {
            remove(o);

            if (remove(o)) {
                isRemoved = true;
            }
        }

        ++modCount;

        return isRemoved;
    }

    // Замена элемента в указанной позиции index на переданный element.
// Индекс также должен быть больше нуля и меньше индекса последнего элемента, иначе будет выброшено исключение IndexOutOfBoundsException.
    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index " + index + " is out of range");
        }

        items[index] = element;
        return element;
    }

    //узнать размер массива.
    @Override
    public int size() {
        return size;
    }

    //Превращает список в фиксированный массив. Обратите внимание, что метод возвращает массив объектов
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a == null) {
            throw new NullPointerException("The specified array is null");
        }

        if (size > a.length) {
            return (T1[]) Arrays.copyOf(items, size);
        } else {

            return (T1[]) Arrays.copyOf(items, a.length);
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("The specified collection is null");
        }

        ArrayList<T> temp = new ArrayList<>();

        for (T e : items) {
            for (Object o : c) {
                if (Objects.equals(o, e))
                    temp.add(e);
            }
        }

        items = (T[]) temp.toArray();
        size = temp.size();

        return true;
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
    }

    @Override
    public void sort(Comparator<? super T> c) {
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

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}