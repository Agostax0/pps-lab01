package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private static final int QUEUE_INITIAL_SIZE = 0;
    private static final List<Integer> EXAMPLE_ELEMENTS = List.of(1,2,3,4,5,6,7,8,9,10);
    private CircularQueue queue;

    @BeforeEach
    public void beforeEach(){
        queue = new CircularQueueImpl();
    }

    @Test
    public void isInitiallyEmpty() {
        assertTrue(this.queue.isEmpty());
    }

    @Test
    public void isSizeInitiallyZero(){assertEquals(QUEUE_INITIAL_SIZE, this.queue.size());}

    @Test
    public void sizeIncreasesWhenAddingElements(){
        EXAMPLE_ELEMENTS.forEach(exampleElement -> queue.add(exampleElement));
        assertEquals(EXAMPLE_ELEMENTS.size(), queue.size());
    }
}
