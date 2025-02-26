package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private static final int QUEUE_INITIAL_SIZE = 0;
    private static final List<Integer> EXAMPLE_ELEMENTS = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    private static final Random RANDOM = new Random();
    private CircularQueue queue;

    @BeforeEach
    public void beforeEach() {
        queue = new CircularQueueImpl();
    }

    @Test
    public void isInitiallyEmpty() {
        assertTrue(this.queue.isEmpty());
    }

    @Test
    public void isSizeInitiallyZero() {
        assertEquals(QUEUE_INITIAL_SIZE, this.queue.size());
    }

    private void fillQueue() {
        EXAMPLE_ELEMENTS.forEach(exampleElement -> this.queue.add(exampleElement));
    }

    @Test
    public void sizeIncreasesWhenAddingElements() {
        fillQueue();
        assertEquals(EXAMPLE_ELEMENTS.size(), queue.size());
    }

    @Test
    public void sizeDoesNotExceedFixedCapacity() {
        int elementsAdded = 0;
        while (elementsAdded <= CircularQueueImpl.MAX_CAPACITY + 1) {
            final var randomExampleElement = EXAMPLE_ELEMENTS.get(RANDOM.nextInt(EXAMPLE_ELEMENTS.size()));
            this.queue.add(randomExampleElement);
            elementsAdded++;
        }
        assertEquals(CircularQueueImpl.MAX_CAPACITY, this.queue.size());
    }

    @Test
    public void cannotRemoveWhenQueueIsEmpty(){
        assertThrows(IllegalStateException.class, () -> this.queue.remove());
    }

    @Test
    public void sizeDecreasesWhenRemovingElements(){
        fillQueue();
        this.queue.remove();
        final int expectedSize = EXAMPLE_ELEMENTS.size() - 1;
        assertEquals(expectedSize, queue.size());
    }
}