package com.appfolio;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-21
 **/
public class Singleton {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * 1. Make constructor as private.
     * 2. Write a static method that has return type object of this singleton class.
     *
     *
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    private static Singleton singleton; // if new here, call eagerly initiation.

    private Singleton() {
        // initial logic here
    }

    public static Singleton getInstance() {
        if (singleton == null) { // lazy initiation
            singleton = new Singleton();
        }
        return singleton;
    }

}

// Lazily Initialized Double-Checked Locking Singleton
class LazyDoubleCheckSingleton {
    private static LazyDoubleCheckSingleton singleton = null;

    private LazyDoubleCheckSingleton() {

    }

    /**
     * https://en.wikipedia.org/wiki/Double-checked_locking#Usage_in_Java
     * we can put the synchronized on the method level. however,the overhead of acquiring and releasing a lock every time
     * this method is called seems unnecessary: once the initialization has been completed, acquiring and releasing the locks would
     * appear unnecessary.
     * so improve: lock the initialization, so firstly check if null, if not, return directly. otherwise,
     * in the lock block, Double-check whether the variable has already been initialized: if another thread acquired the lock first,
     * it may have already done the initialization. If so, return the initialized variable.
     */
    public static LazyDoubleCheckSingleton getInstance() {
        if (singleton == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (singleton == null) { // double check
                    singleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }

}
