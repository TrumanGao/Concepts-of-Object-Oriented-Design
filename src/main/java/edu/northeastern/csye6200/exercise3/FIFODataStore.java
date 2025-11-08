package edu.northeastern.csye6200.exercise3;

/**
 * First-In-First-Out (Queue) data store
 * The first element added is the first element to be removed.
 */
public class FIFODataStore extends GeneralDataStore {

    /**
     * Constructor with specified capacity
     *
     * @param capacity the maximum capacity of the data store
     */
    public FIFODataStore(int capacity) {
        super(capacity);
    }

    /**
     * Default constructor with capacity of 50
     */
    public FIFODataStore() {
        this(50);
    }

    /**
     * Adds an element to the data store at the end
     *
     * @param element the element to add
     * @return true or false if data store is full
     */
    @Override
    public boolean add(Object element) {
        if (isFull()) {
            return false;
        }
        this.storage.add(element);
        this.numberOfElements++;
        return true;
    }

    /**
     * Removes the first element added
     *
     * @return the removed element, or null if data store is empty
     */
    @Override
    public Object remove() {
        if (isEmpty()) {
            return null;
        }
        Object removed = this.storage.remove(0);
        this.numberOfElements--;
        return removed;
    }

    /**
     * Returns the first element without removing it
     *
     * @return the first element, or null if data store is empty
     */
    public Object getFirst() {
        if (isEmpty()) {
            return null;
        }
        return this.storage.get(0);
    }

    /**
     * Returns the last element without removing it
     *
     * @return the last element, or null if data store is empty
     */
    public Object getLast() {
        if (isEmpty()) {
            return null;
        }
        return this.storage.get(this.numberOfElements - 1);
    }
}