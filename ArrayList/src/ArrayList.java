import java.util.*;
import java.util.function.UnaryOperator;


public class ArrayList<T> implements List<T> {
    private T[] items;
    private int length;

    public ArrayList() {
        this.items = (T[]) new Object[10];
    }

    public ArrayList(int length, T[] items) {
        this.length = length;
        this.items = Arrays.copyOf(items, length);
    }

    public ArrayList(T[] items) {
        this.items = items;
        this.length = items.length;
    }

    public ArrayList(int length) {
        this.length = length;
        this.items = (T[]) new Object[length];
    }


    // Добавляет новый элемент в конец списка. Возвращает boolean-значение (true — успех, false — не добавлено)
    @Override
    public boolean add(T t) {
        if (length >= items.length) {
            increaseCapacity();
        }

        items[length] = t;
        ++length;

        return true;
    }

    //Добавляет элемент element в позицию index. При добавлении происходит сдвиг всех элементов справа от указанного индекса на 1 позицию вправо
    @Override
    public void add(int index, T element) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        }

        if (length + 1 >= items.length) {
            increaseCapacity();
        }

        System.arraycopy(items, index, items, index + 1, length - index + 1);

        items[index] = element;
        ++length;
    }


    //Добавление всех элементов коллекции collection в список в порядке их расположения в collection
    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T element : c) {
            add(element);
            ++length;
        }

        return true;
    }


    //Добавление всех элементов collection в список начиная с индекса index. При этом все элементы сдвинутся вправо на количество элементов в списке collection
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {

        if (length + c.size() + 1 >= items.length) {
            increaseCapacity();
        }

        System.arraycopy(items, index, items, index + c.size(), length - index + 1 + c.size());

        for (T element : c) {
            items[index] = element;
            ++index;
        }

        length += c.size();

        return true;
    }


    //Удаление всех элементов из списка.
    @Override
    public void clear() {
        items = (T[]) new Object[10];
        length = 0;
    }

    //Проверка наличие объекта в списке, возвращает boolean-значение.
    @Override
    public boolean contains(Object o) {
        try {
            for (T element : items) {
                if (element.equals(o)) {
                    return true;
                }
            }
        } catch (NullPointerException e) {
            return false;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        try {
            for (Object o : c) {
                for (T e : items) {
                    if (e.equals(o)) {
                        break;
                    }
                }
            }
        } catch (NullPointerException e) {
            return false;
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
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Индекс " + index + " выходит за границы коллекции");
        }

        return items[index];
    }


    // Метод возвращает индекс первого вхождения элемента в списке. Если элемента не существует в списке, метод вернет -1.
    @Override
    public int indexOf(Object o) {
        try {
            for (T e : items) {
                if (e.equals(o)) {
                    return 1;
                }
            }
        } catch (NullPointerException e) {
            return -1;
        }

        return -1;
    }


    // Метод возвращает true, если список пустой, false в обратном случае.
    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "items=" + Arrays.toString(items) +
                '}' + "Длинна - " + length;
    }


    // Возвращает итератор для списка для последующего использования в цикле или при любой другой обработке.
    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<T> {
        private int currentIndex = -1;

        public boolean hasNext() {
            return currentIndex + 1 < length;
        }

        public T next() {
            if (currentIndex == length - 1) {
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
        try {
            int lastIndex = -1;
            int i = 0;

            for (T e : items) {
                if (e.equals(o)) {
                    lastIndex = i;
                }

                i++;
            }
        } catch (NullPointerException e) {
            return lastIndex;
        }

        return -1;
    }

    //Удаление элемента в указанной позиции индекса. После удаления сдвигает все элементы влево для заполнения освободившегося пространства.
    @Override
    public T remove(int index) {

        T removedElement = items[index];

        if (index < length - 1) {
            System.arraycopy(items, index + 1, items, index, length - index - 1);
        }

        items[length - 1] = null;
        --length;

        return removedElement;
    }

    //Метод удаляет из списка переданный элемент o. Если элемент присутствует в списке, он удаляется, а все элементы смещаются влево.
// Если элемент существует в списке и успешно удален, метод возвращает true, в обратном случае — false.
    @Override
    public boolean remove(Object o) {
        return false;
    }

    // Метод принимает коллекцию элементов, которая будет удалена из списка.
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
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
        return length;
    }

    //Превращает список в фиксированный массив. Обратите внимание, что метод возвращает массив объектов (Object[]).
    // Если необходимо привести список в массив объектов определенного типа,
    // в качестве параметра в метод можно передать массив, куда будут перемещены элементы списков.
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }






    @Override
    public ListIterator<T> listIterator() {
        return null;
    }





    
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {

    }

    @Override
    public void sort(Comparator<? super T> c) {

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




































    /*
    //Получить значение.
    public T get(int index) {
        if (index > size()) {
            throw new IllegalArgumentException("Индекс " + index + " больше длинны списка");
        }

        return items[index];
    }

    public void set(int index, T element) {
        if (index > size()) {
            throw new IllegalArgumentException("Индекс " + index + " больше длинны списка");
        }

        items[index] = element;
    }

    public void add(T element) {
        if (length >= items.length) {
            increaseCapacity();
        }

        items[length] = element;
        ++length;
    }

    public void increaseCapacity() throws RuntimeException {
        items = Arrays.copyOf(items, size() * 2);
    }

    public class MyArray {
        public void remove(int index) {
            if (index > size()) {
                throw new IllegalArgumentException("Индекс " + index + " больше длинны списка");
            }

            if (index < length - 1) {
                System.arraycopy(items, index + 1,
                        items, index, length - index - 1);
            }

            items[length - 1] = null;
            --length;
        }
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    } */


}