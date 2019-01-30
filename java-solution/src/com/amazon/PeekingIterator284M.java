package com.amazon;

import java.util.Iterator;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/15/18
 * Talk is Cheap,Show me the Code.
 **/
public class PeekingIterator284M implements Iterator<Integer> {
    /**
     * KEYPOINTS:
     * <p>
     * Q: if null is permitted as a element in this Iterator.
     * If yes, we cannot use null for hasNext judge. Need to add a boolean i.e,done.
     * KeyPoint: because peek not move pointer,so we can use a object cache to cache the next for peek.
     * <p>
     **/
    Iterator it;
    Integer cache;

    public PeekingIterator284M(Iterator<Integer> iterator) {
        // initialize any member here.
        this.it = iterator;
        cache = (Integer) it.next();

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return cache;

    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer ans = cache;
        cache = it.hasNext() ? (Integer) it.next() : null;
        return ans;
    }

    @Override
    public boolean hasNext() {
        return cache != null; // if null is permitted with the iterator. Cannot do it like this
    }
}