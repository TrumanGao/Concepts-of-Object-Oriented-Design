package edu.northeastern.csye6200.exercise3;

import java.util.ArrayList;

/**
 * GeneralDataStore provides partial implementation of the DataStore interface.
 * It has a fixed capacity and uses ArrayList for storage.
 */
public abstract class GeneralDataStore implements DataStore {
    protected int numberOfElements;      // Tracks number of elements in data store
    protected int maxCapacity;           // Maximum capacity of data store
    protected ArrayList<Object> storage; // ArrayList to store elements

    /**
     * Constructor to initialize the data store with given capacity
     *
     * @param capacity the maximum capacity of the data store
     */
    public GeneralDataStore(int capacity) {
        this.maxCapacity = capacity;
        this.numberOfElements = 0;
        this.storage = new ArrayList<Object>();
    }

    /**
     * Gets the maximum capacity of the data store
     *
     * @return the maximum capacity
     */
    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    /**
     * Checks if the data store is empty
     *
     * @return true if empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return this.numberOfElements == 0;
    }

    /**
     * Checks if the data store is full
     *
     * @return true if full, false otherwise
     */
    @Override
    public boolean isFull() {
        return this.numberOfElements >= this.maxCapacity;
    }

    /**
     * Clears all elements from the data store
     *
     * @return true if successful, false if already empty
     */
    @Override
    public boolean clear() {
        if (isEmpty()) {
            return false;
        }
        this.storage.clear();
        this.numberOfElements = 0;
        return true;
    }

    /**
     * Returns a string representation of the data store contents
     *
     * @return String representation in format [element1, element2, ...]
     */
    @Override
    public String toString() {
        return this.storage.toString();
    }

    // Abstract methods - must be implemented by subclasses
    public abstract boolean add(Object element);

    public abstract Object remove();
}