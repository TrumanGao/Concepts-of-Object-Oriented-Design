package edu.northeastern.csye6200.exercise3;

/**
 * Test class to demonstrate the functionality of LIFODataStore and FIFODataStore
 */
public class DataStoreTester {

    public static void main(String[] args) {
        System.out.println("=== Testing LIFODataStore (Stack) ===");
        testLIFO();

        System.out.println("\n=== Testing FIFODataStore (Queue) ===");
        testFIFO();
    }

    public static void testLIFO() {
        LIFODataStore lifoStore = new LIFODataStore(5);

        System.out.println("Adding: John, Quincy, Adams");
        lifoStore.add("John");
        lifoStore.add("Quincy");
        lifoStore.add("Adams");

        System.out.println("Contents: " + lifoStore.toString());
        System.out.println("Max capacity: " + lifoStore.getMaxCapacity());
        System.out.println("Last element: " + lifoStore.getLast());

        System.out.println("\nRemoving in LIFO order:");
        System.out.println("Removed: " + lifoStore.remove());
        System.out.println("Removed: " + lifoStore.remove());
        System.out.println("Removed: " + lifoStore.remove());
        System.out.println("Is empty? " + lifoStore.isEmpty());
    }

    public static void testFIFO() {
        FIFODataStore fifoStore = new FIFODataStore(5);

        System.out.println("Adding: John, Quincy, Adams");
        fifoStore.add("John");
        fifoStore.add("Quincy");
        fifoStore.add("Adams");

        System.out.println("Contents: " + fifoStore.toString());
        System.out.println("First element: " + fifoStore.getFirst());
        System.out.println("Last element: " + fifoStore.getLast());

        System.out.println("\nRemoving in FIFO order:");
        System.out.println("Removed: " + fifoStore.remove());
        System.out.println("Removed: " + fifoStore.remove());
        System.out.println("Removed: " + fifoStore.remove());
        System.out.println("Is empty? " + fifoStore.isEmpty());
    }
}