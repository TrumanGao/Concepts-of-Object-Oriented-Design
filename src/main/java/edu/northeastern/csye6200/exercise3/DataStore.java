package edu.northeastern.csye6200.exercise3;

public interface DataStore {

    /**
     * Adds an element to the data store
     *
     * @param element the element to add
     * @return true or false, if addition is successful
     */
    boolean add(Object element);

    /**
     * Removes an element from the data store
     *
     * @return the removed element if successful
     */
    Object remove();

    /**
     * Removes all elements in the data store
     *
     * @return true or false, if operation is successful
     */
    boolean clear();

    /**
     * Checks if the data store is empty
     *
     * @return true or false, if data store is empty
     */
    boolean isEmpty();

    /**
     * Checks if the data store is full
     *
     * @return true or false, if data store is full
     */
    boolean isFull();
}