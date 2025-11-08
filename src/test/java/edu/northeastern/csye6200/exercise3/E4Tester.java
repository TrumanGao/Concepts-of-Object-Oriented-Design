package edu.northeastern.csye6200.exercise3;

//@Test
//@BeforeClass
//@AfterClass
//@Before
//@After

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;


/**
 * Tests all implementations of the DataStore interface
 */
public class E4Tester {
    private LIFODataStore lifoStore;
    private FIFODataStore fifoStore;

    /**
     * Method with @Before annotation runs before each @Test method
     * Used to initialize test environment (Setup)
     */
    @Before
    public void setUp() {
        lifoStore = new LIFODataStore(5);  // Capacity of 5
        fifoStore = new FIFODataStore(5);  // Capacity of 5
    }

    /**
     * Method with @After annotation runs after each @Test method
     * Used to clean up test environment (Cleanup)
     */
    @After
    public void tearDown() {
        lifoStore = null;
        fifoStore = null;
    }

    // ========================================
    // LIFO DataStore Tests
    // ========================================

    /**
     * Test LIFO constructor - default capacity
     */
    @Test
    public void testLIFODefaultConstructor() {
        LIFODataStore defaultStore = new LIFODataStore();
        assertEquals("Default capacity should be 50", 50, defaultStore.getMaxCapacity());
        assertTrue("Newly created store should be empty", defaultStore.isEmpty());
    }

    /**
     * Test LIFO constructor - custom capacity
     */
    @Test
    public void testLIFOCustomCapacity() {
        LIFODataStore customStore = new LIFODataStore(10);
        assertEquals("Custom capacity should be 10", 10, customStore.getMaxCapacity());
    }

    /**
     * Test LIFO add method - normal addition
     */
    @Test
    public void testLIFOAddNormal() {
        // Arrange - prepare data
        // Act - perform operation
        boolean result = lifoStore.add("First");

        // Assert - verify result
        assertTrue("Add should succeed", result);
        assertFalse("Should not be empty after adding", lifoStore.isEmpty());
        assertEquals("toString should show content", "[First]", lifoStore.toString());
    }

    /**
     * Test LIFO add method - add multiple elements
     */
    @Test
    public void testLIFOAddMultiple() {
        lifoStore.add("First");
        lifoStore.add("Second");
        lifoStore.add("Third");

        assertEquals("Should have correct string representation",
                "[First, Second, Third]",
                lifoStore.toString());
    }

    /**
     * Test LIFO add method - add to full capacity
     */
    @Test
    public void testLIFOAddToFull() {
        // Add 5 elements (capacity is 5)
        for (int i = 1; i <= 5; i++) {
            assertTrue("Element " + i + " should be added successfully",
                    lifoStore.add("Element" + i));
        }

        assertTrue("Should be full", lifoStore.isFull());
        assertFalse("Should return false when full", lifoStore.add("Overflow"));
    }

    /**
     * Test LIFO remove method - LIFO order (Last-In-First-Out)
     */
    @Test
    public void testLIFORemoveOrder() {
        // Arrange - add elements
        lifoStore.add("First");
        lifoStore.add("Second");
        lifoStore.add("Third");

        // Act & Assert - verify LIFO order
        assertEquals("Should remove Third first (last added)", "Third", lifoStore.remove());
        assertEquals("Then remove Second", "Second", lifoStore.remove());
        assertEquals("Finally remove First (first added)", "First", lifoStore.remove());
        assertTrue("Should be empty after removing all", lifoStore.isEmpty());
    }

    /**
     * Test LIFO remove method - remove from empty store
     */
    @Test
    public void testLIFORemoveFromEmpty() {
        assertNull("Removing from empty store should return null", lifoStore.remove());
    }

    /**
     * Test LIFO getLast method
     */
    @Test
    public void testLIFOGetLast() {
        assertNull("getLast on empty store should return null", lifoStore.getLast());

        lifoStore.add("First");
        lifoStore.add("Second");

        assertEquals("getLast should return last added element", "Second", lifoStore.getLast());
        assertEquals("getLast should not remove element", "[First, Second]", lifoStore.toString());
    }

    /**
     * Test LIFO isEmpty method
     */
    @Test
    public void testLIFOIsEmpty() {
        assertTrue("Newly created store should be empty", lifoStore.isEmpty());

        lifoStore.add("Item");
        assertFalse("Should not be empty after adding", lifoStore.isEmpty());

        lifoStore.remove();
        assertTrue("Should be empty after removing all", lifoStore.isEmpty());
    }

    /**
     * Test LIFO isFull method
     */
    @Test
    public void testLIFOIsFull() {
        assertFalse("Newly created store should not be full", lifoStore.isFull());

        // Add 5 elements (capacity is 5)
        for (int i = 0; i < 5; i++) {
            lifoStore.add("Item" + i);
        }

        assertTrue("Should be full when at capacity", lifoStore.isFull());
    }

    /**
     * Test LIFO clear method
     */
    @Test
    public void testLIFOClear() {
        // Clear on empty store should return false
        assertFalse("Clearing empty store should return false", lifoStore.clear());

        // Add elements then clear
        lifoStore.add("Item1");
        lifoStore.add("Item2");
        assertTrue("Clearing non-empty store should return true", lifoStore.clear());
        assertTrue("Should be empty after clear", lifoStore.isEmpty());
        assertEquals("toString should show empty array", "[]", lifoStore.toString());
    }

    // ========================================
    // FIFO DataStore Tests
    // ========================================

    /**
     * Test FIFO constructors
     */
    @Test
    public void testFIFOConstructors() {
        FIFODataStore defaultStore = new FIFODataStore();
        assertEquals("Default capacity should be 50", 50, defaultStore.getMaxCapacity());

        FIFODataStore customStore = new FIFODataStore(15);
        assertEquals("Custom capacity should be 15", 15, customStore.getMaxCapacity());
    }

    /**
     * Test FIFO add method
     */
    @Test
    public void testFIFOAdd() {
        assertTrue("Add should succeed", fifoStore.add("First"));
        fifoStore.add("Second");
        fifoStore.add("Third");

        assertEquals("Should have correct content",
                "[First, Second, Third]",
                fifoStore.toString());
    }

    /**
     * Test FIFO remove method - FIFO order (First-In-First-Out)
     */
    @Test
    public void testFIFORemoveOrder() {
        // Arrange
        fifoStore.add("First");
        fifoStore.add("Second");
        fifoStore.add("Third");

        // Act & Assert - verify FIFO order
        assertEquals("Should remove First first (first added)", "First", fifoStore.remove());
        assertEquals("Then remove Second", "Second", fifoStore.remove());
        assertEquals("Finally remove Third (last added)", "Third", fifoStore.remove());
        assertTrue("Should be empty after removing all", fifoStore.isEmpty());
    }

    /**
     * Test FIFO remove method - remove from empty store
     */
    @Test
    public void testFIFORemoveFromEmpty() {
        assertNull("Removing from empty store should return null", fifoStore.remove());
    }

    /**
     * Test FIFO getFirst and getLast methods
     */
    @Test
    public void testFIFOGetFirstAndLast() {
        // Empty store test
        assertNull("getFirst on empty store should return null", fifoStore.getFirst());
        assertNull("getLast on empty store should return null", fifoStore.getLast());

        // Add elements
        fifoStore.add("First");
        fifoStore.add("Second");
        fifoStore.add("Third");

        // Verify
        assertEquals("getFirst should return First", "First", fifoStore.getFirst());
        assertEquals("getLast should return Third", "Third", fifoStore.getLast());

        // Verify no removal
        assertEquals("getFirst/getLast should not remove elements",
                "[First, Second, Third]",
                fifoStore.toString());
    }

    /**
     * Test FIFO add to full capacity
     */
    @Test
    public void testFIFOAddToFull() {
        for (int i = 1; i <= 5; i++) {
            assertTrue("Adding element " + i + " should succeed",
                    fifoStore.add("Item" + i));
        }

        assertTrue("Should be full", fifoStore.isFull());
        assertFalse("Should return false when exceeding capacity", fifoStore.add("Overflow"));
    }

    /**
     * Test FIFO isEmpty and isFull
     */
    @Test
    public void testFIFOEmptyAndFull() {
        assertTrue("New store should be empty", fifoStore.isEmpty());
        assertFalse("New store should not be full", fifoStore.isFull());

        for (int i = 0; i < 5; i++) {
            fifoStore.add("Item" + i);
        }

        assertFalse("Should not be empty after adding", fifoStore.isEmpty());
        assertTrue("Should be full at capacity", fifoStore.isFull());
    }

    /**
     * Test FIFO clear method
     */
    @Test
    public void testFIFOClear() {
        assertFalse("Clearing empty store should return false", fifoStore.clear());

        fifoStore.add("Item1");
        fifoStore.add("Item2");
        assertTrue("Clearing non-empty store should return true", fifoStore.clear());
        assertTrue("Should be empty after clear", fifoStore.isEmpty());
    }

    // ========================================
    // Integration and Boundary Tests
    // ========================================

    /**
     * Test adding different types of objects
     */
    @Test
    public void testAddDifferentTypes() {
        lifoStore.add("String");
        lifoStore.add(123);
        lifoStore.add(45.67);
        lifoStore.add(true);

        // Verify LIFO order
        assertEquals("Should return Boolean", true, lifoStore.remove());
        assertEquals("Should return Double", 45.67, lifoStore.remove());
        assertEquals("Should return Integer", 123, lifoStore.remove());
        assertEquals("Should return String", "String", lifoStore.remove());
    }

    /**
     * Test adding null values
     */
    @Test
    public void testAddNull() {
        assertTrue("Should be able to add null", lifoStore.add(null));
        assertNull("Remove should return null", lifoStore.remove());
    }

    /**
     * Test difference between LIFO and FIFO
     */
    @Test
    public void testLIFOvsFIFO() {
        // Add same elements to both
        lifoStore.add("A");
        lifoStore.add("B");
        lifoStore.add("C");

        fifoStore.add("A");
        fifoStore.add("B");
        fifoStore.add("C");

        // LIFO should return C (last added)
        assertEquals("LIFO should return C first", "C", lifoStore.remove());

        // FIFO should return A (first added)
        assertEquals("FIFO should return A first", "A", fifoStore.remove());
    }

    /**
     * Test boundary case with capacity of 1
     */
    @Test
    public void testCapacityOne() {
        LIFODataStore tinyStore = new LIFODataStore(1);

        assertTrue("First add should succeed", tinyStore.add("Only"));
        assertTrue("Should be full", tinyStore.isFull());
        assertFalse("Second add should fail", tinyStore.add("Second"));

        assertEquals("Remove should return only element", "Only", tinyStore.remove());
        assertTrue("Should be empty after remove", tinyStore.isEmpty());
    }

    /**
     * Test repeated add and remove operations
     */
    @Test
    public void testRepeatedOperations() {
        for (int i = 0; i < 3; i++) {
            lifoStore.add("Item");
            assertEquals("Should remove just added element", "Item", lifoStore.remove());
            assertTrue("Should be empty after each cycle", lifoStore.isEmpty());
        }
    }

    /**
     * Performance test - large number of operations (optional)
     */
    @Test
    public void testLargeCapacity() {
        LIFODataStore largeStore = new LIFODataStore(1000);

        // Add 1000 elements
        for (int i = 0; i < 1000; i++) {
            assertTrue("Should be able to add all 1000 elements", largeStore.add(i));
        }

        assertTrue("Should be full", largeStore.isFull());

        // Remove all elements
        for (int i = 999; i >= 0; i--) {
            assertEquals("Should return in LIFO order", i, largeStore.remove());
        }

        assertTrue("Should be empty", largeStore.isEmpty());
    }
}