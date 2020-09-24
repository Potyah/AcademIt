import java.util.*;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class HashTable<T> implements Collection<T> {
    private int index;
    private int[] array;


    public HashTable() {
        array = new int[100];
    }

    public HashTable(int size) {
        array = new int[size];
    }


    public int getIndex(Object o) {
        return Math.abs(hashCode() % array.length);
    }


    public int hashCode() {

        final int prime = 37;
        int hash = 1;

        hash = prime * hash;
        hash = prime * hash + Arrays.hashCode(array);


        return hash;
    }

    public int hashCode(Collection<? extends T> c) {
        int hash = 0;

        for (Object o : c) {
            hash += o.hashCode();
        }

        return hash;
    }


    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override

    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return null;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public <T1> T1[] toArray(IntFunction<T1[]> generator) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    @Override
    public Stream<T> stream() {
        return null;
    }

    @Override
    public Stream<T> parallelStream() {
        return null;
    }


}
