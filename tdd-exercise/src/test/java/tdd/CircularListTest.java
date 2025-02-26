package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private static final int QUEUE_INITIAL_SIZE = 0;
    private CircularQueue queue;

    @BeforeEach
    public void beforeEach(){

    }

    @Test
    public void isInitiallyEmpty() {
        assertTrue(this.queue.isEmpty());
    }

    public void isSizeInitiallyZero(){assertEquals(QUEUE_INITIAL_SIZE, this.queue.size());}
}
