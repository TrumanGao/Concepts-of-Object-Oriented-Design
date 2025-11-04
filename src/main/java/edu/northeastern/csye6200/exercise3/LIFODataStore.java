package edu.northeastern.csye6200.exercise3;

/**
 * LIFODataStore implements a Last-In-First-Out (Stack) data store.
 * The last element added is the first element to be removed.
 */
public class LIFODataStore extends GeneralDataStore {

    /**
     * Constructor with specified capacity
     *
     * @param capacity the maximum capacity of the data store
     */
    public LIFODataStore(int capacity) {
        super(capacity);
    }

    /**
     * Default constructor with capacity of 50
     */
    public LIFODataStore() {
        this(50);
    }

    /**
     * Adds an element to the data store at the end
     *
     * @param element the element to add
     * @return true if successful, false if data store is full
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
     * Removes the last element added (LIFO behavior)
     *
     * @return the removed element, or null if data store is empty
     */
    @Override
    public Object remove() {
        if (isEmpty()) {
            return null;
        }
        Object removed = this.storage.remove(this.numberOfElements - 1);
        this.numberOfElements--;
        return removed;
    }

    /**
     * Returns the last element added without removing it
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