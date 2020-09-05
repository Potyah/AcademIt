import java.util.*;
import java.util.function.UnaryOperator;


public class ArrayList<T> implements List<T> {
    private T[] items;
    private int size;

    public ArrayList() {
        this.items = (T[]) new Object[10];
    }

    public ArrayList(int size, T[] items) {
        this.size = size;
        this.items = Arrays.copyOf(items, size);
    }

    public ArrayList(T[] items) {
        this.items = items;
        this.size = items.length;
    }

    public ArrayList(int size) {
        this.size = size;
        this.items = (T[]) new Object[size];
    }


    public void trimToSize() {
        if (size < items.length) {
            items = Arrays.copyOf(items, size);
        }
    }


    // Добавляет новый элемент в конец списка. Возвращает boolean-значение (true — успех, false — не добавлено)
    @Override
    public boolean add(T t) {
        if (size >= items.length) {
            increaseCapacity();
        }

        items[size] = t;
        ++size;
        trimToSize();

        return true;
    }

    //Добавляет элемент element в позицию index. При добавлении происходит сдвиг всех элементов справа от указанного индекса на 1 позицию вправо
    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (size + 1 >= items.length) {
            increaseCapacity();
        }

        System.arraycopy(items, index, items, index + 1, size - index + 1);

        items[index] = element;
        ++size;
        trimToSize();
    }


    //Добавление всех элементов коллекции collection в список в порядке их расположения в collection
    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T element : c) {
            add(element);
            ++size;
        }

        trimToSize();

        return true;
    }


    //Добавление всех элементов collection в список начиная с индекса index. При этом все элементы сдвинутся вправо на количество элементов в списке collection
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {

        if (size + c.size() + 1 >= items.length) {
            increaseCapacity();
        }

        System.arraycopy(items, index, items, index + c.size(), size - index + 1 + c.size());

        for (T element : c) {
            items[index] = element;
            ++index;
        }

        size += c.size();
        trimToSize();

        return true;
    }


    //Удаление всех элементов из списка.
    @Override
    public void clear() {
        items = (T[]) new Object[10];
        size = 0;
    }

    //Проверка наличие объекта в списке, возвращает boolean-значение.
    @Override
    public boolean contains(Object o) {
        for (T e : items) {
            if (o.equals(e)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            for (T e : items) {
                if (o.equals(e)) {
                    break;
                }
            }
        }

        return true;
    }


    // Увеличивает размер внутреннего массива, чтобы в него поместилось количество элементов, переданных в minCapacity.
    private void increaseCapacity() {
        items = Arrays.copyOf(items, items.length * 2);
    }


    // Возвращает элемент, который расположен в указанной позиции списка.
    @Override
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс " + index + " выходит за границы коллекции");
        }

        return items[index];
    }


    // Метод возвращает индекс первого вхождения элемента в списке. Если элемента не существует в списке, метод вернет -1.
    @Override
    public int indexOf(Object o) {
        int i = 0;

        for (T e : items) {
            if (o.equals(e)) {
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
        return "ArrayList{" +
                "items=" + Arrays.toString(items) +
                '}' + "Длинна - " + size;
    }


    // Возвращает итератор для списка для последующего использования в цикле или при любой другой обработке.
    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<T> {
        private int currentIndex = -1;

        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        public T next() {
            if (currentIndex == size - 1) {
                throw new NoSuchElementException("Коллекция кончилась");
            }

            //   if (currentIndex) {
            //        throw new ConcurrentModificationException ("Коллекция кончилась");
            //      }

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
            if (o.equals(e)) {
                lastIndex = i;
            }

            i++;
        }

        return lastIndex;
    }

    //Удаление элемента в указанной позиции индекса. После удаления сдвигает все элементы влево для заполнения освободившегося пространства.
    @Override
    public T remove(int index) {

        T removedElement = items[index];

        if (index < size - 1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
        }

        items[size - 1] = null;
        --size;
        trimToSize();

        return removedElement;
    }

    //Метод удаляет из списка переданный элемент o. Если элемент присутствует в списке, он удаляется, а все элементы смещаются влево.
// Если элемент существует в списке и успешно удален, метод возвращает true, в обратном случае — false.
    @Override
    public boolean remove(Object o) {
        int i = 0;

        for (T e : items) {
            if (o.equals(e)) {
                remove(i);
                return true;
            }

            ++i;
        }

        return false;
    }

    // Метод принимает коллекцию элементов, которая будет удалена из списка.
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean isRemoved = false;
        int i;

        for (Object o : c) {
            i = 0;

            for (T e : items) {
                if (o.equals(e)) {
                    remove(i);
                    isRemoved = true;
                }

                i++;
            }
        }

        return isRemoved;
    }

    // Замена элемента в указанной позиции index на переданный element.
// Индекс также должен быть больше нуля и меньше индекса последнего элемента, иначе будет выброшено исключение IndexOutOfBoundsException.
    @Override
    public T set(int index, T element) {
        items[index] = element;
        return element;
    }

    //узнать размер массива.
    @Override
    public int size() {
        return size;
    }

    //Превращает список в фиксированный массив. Обратите внимание, что метод возвращает массив объектов (Object[]).
    // Если необходимо привести список в массив объектов определенного типа,
    // в качестве параметра в метод можно передать массив, куда будут перемещены элементы списков.
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {

        if (size > a.length) {
            return (T1[]) Arrays.copyOf(items, size);
        } else {

            return (T1[]) Arrays.copyOf(items, a.length);
        }
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isRetain = true;

        for (Object o : c) {
            for (T e : items) {
                if (o.equals(e)) {
                    isRetain = false;
                    continue;
                }

                remove(e);
            }
        }

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