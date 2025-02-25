package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    private MinMaxStack stack;
    private static int INITIAL_SIZE = 0;

    @BeforeEach
    public void beforeEach(){
        this.stack = new MinMaxStackImpl();
    }

    @Test
    public void isInitiallyEmpty() {
        assertTrue(this.stack.isEmpty());
    }

    @Test
    public void isSizeInitiallyZero(){
        assertEquals(INITIAL_SIZE, this.stack.size());
    }

    @Test
    public void initialPopThrowsException(){
        assertThrows(IllegalStateException.class, () -> this.stack.pop());
    }

    @Test
    public void initialPeekThrowsException(){
        assertThrows(IllegalStateException.class, () -> this.stack.peek());
    }
}