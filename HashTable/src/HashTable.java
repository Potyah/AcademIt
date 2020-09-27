import java.util.*;

public class HashTable<T> implements Collection<T> {
    private final int size;
    private final ArrayList<T>[] array;

    public HashTable() {
        array = new ArrayList[10];
        size = 10;
    }

    public HashTable(int size) {
        array = new ArrayList[size];
        this.size = size;
    }

    public ArrayList<T> getHashList(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index " + index + " is out of range. Length is " + size);
        }

        return array[index];
    }

    public int getIndex(Object o) {
        return Math.abs(hashCode(o) % array.length);
    }

    public int hashCode(Object o) {
        final int prime = 37;
        return prime + Objects.hashCode(o);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < size; i++) {
            if (array[i] != null) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean contains(Object o) {
        int index = getIndex(o);

        return getHashList(index).contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<T> {
        private int arrayIndex = 0;
        private int collectionIndex = -1;

        public boolean hasNext() {
            return arrayIndex + 1 < size;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("The collection element is ended");
            }

            while ((getHashList(arrayIndex) == null) || (getHashList(arrayIndex).size() <= collectionIndex + 1)) {
                ++arrayIndex;
                collectionIndex = -1;

                if (arrayIndex > size) {
                    return null;
                }
            }

            ++collectionIndex;

            return getHashList(arrayIndex).get(collectionIndex);
        }
    }

    @Override
    public Object[] toArray() {
        //    Object newArray = new Object[];


        return Arrays.copyOf(array, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }


    @Override
    public boolean add(T t) {
        int index = getIndex(t);

        if (array[index] == null) {
            array[index] = new ArrayList<>();
        }

        getHashList(index).add(t);

        return true;

    }

    @Override
    public boolean remove(Object o) {
        int index = getIndex(o);

        return getHashList(index).remove(o);
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
    public boolean removeAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("The specified collection is null");
        }

        boolean result = true;

        for (Object o : c) {
            if (!contains(o)) {
                result = false;
                break;
            }

            remove(o);
        }

        return result;
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("The specified collection is null");
        }

        boolean result = false;

        for (T t : this) {
            if (!c.contains(t)) {
                remove(t);
                result = true;
            }
        }

        return result;
    }

    @Override
    public void clear() {
        for (ArrayList<T> e : array) {
            if (e != null) {
                e = null;
            }
        }
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "size=" + size +
                ", array=" + Arrays.toString(array) + '}';
    }
}