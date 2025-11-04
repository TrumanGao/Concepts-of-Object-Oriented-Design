package edu.northeastern.csye6200.exercise3;

public interface DataStore {

    /**
     * Adds an element to the data store
     *
     * @param element the element to add (of type Object)
     * @return true if addition is successful, false otherwise (e.g., if data store is full)
     */
    boolean add(Object element);

    /**
     * Removes an element from the data store
     *
     * @return the removed element if successful, null if operation fails (e.g., if data store is empty)
     */
    Object remove();

    /**
     * Removes all elements in the data store
     *
     * @return true if operation is successful, false otherwise (e.g., if data store is already empty)
     */
    boolean clear();

    /**
     * Checks if the data store is empty
     *
     * @return true if data store is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Checks if the data store is full
     *
     * @return true if data store is full, false otherwise
     */
    boolean isFull();
}