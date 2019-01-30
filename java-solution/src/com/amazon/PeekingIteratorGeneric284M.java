package com.amazon;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/15/18
 * Talk is Cheap,Show me the Code.
 **/
public class PeekingIteratorGeneric284M<T> implements Iterator<T> {
    /**
     * KEYPOINTS:
     * <p>
     * Q: if null is permitted as a element in this Iterator.
     * If yes, we cannot use null for hasNext judge. Need to add a boolean i.e,done.
     * KeyPoint: because peek not move pointer,so we can use a object cache to cache the next for peek.
     * <p>
     **/
    Iterator it;
    T cache;
    boolean done;

    public PeekingIteratorGeneric284M(Iterator<T> iterator) {
        // initialize any member here.
        this.it = iterator;
        advanceIter();

    }

    public void advanceIter() {
        if (it.hasNext()) {
            cache = (T) it.next();
        } else {
            done = true;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public T peek() {
        return cache;

    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public T next() {
        if (done) {
            throw new NoSuchElementException();
        }
        T res = cache;
        advanceIter();
        return res;
    }

    @Override
    public boolean hasNext() {
        return !done;
    }


}