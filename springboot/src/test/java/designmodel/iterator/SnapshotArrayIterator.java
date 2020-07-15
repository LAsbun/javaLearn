package designmodel.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SnapshotArrayIterator<E> implements Iterator<E> {

    private int cursor;

    private ArrayList<E> snapshot;


    public SnapshotArrayIterator(ArrayList<E> arrayList) {
        this.cursor = 0;
        this.snapshot = new ArrayList<>();
        this.snapshot.addAll(arrayList);
    }


    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return cursor < this.snapshot.size();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public E next() {

        if (this.cursor >= this.snapshot.size()) {
            throw new NoSuchElementException("");
        }

        E e = this.snapshot.get(cursor);
        this.cursor++;
        return e;
    }
}
