package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    private MinMaxStack stack;
    private static int INITIAL_SIZE = 0;
    private static final List<Integer> EXAMPLE_VALUES = new ArrayList<>(
            List.of(
            3, 1, 1, 6, 2, 5, 8, 7, 10, 9
            )
    );
    private final static int MAX_EXAMPLE_VALUE = Collections.max(EXAMPLE_VALUES);
    private static int MIN_EXAMPLE_VALUE = Collections.min(EXAMPLE_VALUES);

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

    @Test
    public void initialGetMinThrowsException(){
        assertThrows(IllegalStateException.class, () -> this.stack.getMin());
    }

    @Test
    public void initialGetMaxThrowsException(){
        assertThrows(IllegalStateException.class, () -> this.stack.getMax());
    }

    private void fillStackWithExampleValues() {
        EXAMPLE_VALUES.forEach( exampleValue -> this.stack.push(exampleValue));
    }

    @Test
    public void pushingValuesIncreasesSize(){
        fillStackWithExampleValues();
        assertEquals(EXAMPLE_VALUES.size(), this.stack.size());
    }

    @Test
    public void pushingValuesMeansNoLongerEmpty(){
        fillStackWithExampleValues();
        assertFalse(this.stack.isEmpty());
    }

    @Test
    public void popValueIsMax(){
        fillStackWithExampleValues();
        assertEquals(MAX_EXAMPLE_VALUE, this.stack.pop());
    }

    @Test
    public void poppingValuesDecreasesSize(){
        fillStackWithExampleValues();
        int expectedSize = EXAMPLE_VALUES.size();

        while(expectedSize > 0){
            assertEquals(expectedSize, this.stack.size());
            expectedSize--;
            this.stack.pop();
        }
    }

    @Test
    public void peekValueIsMax(){
        fillStackWithExampleValues();
        assertEquals(MAX_EXAMPLE_VALUE, this.stack.peek());
    }

    @Test
    public void peekingValueDoesNotDecreaseSize(){
        fillStackWithExampleValues();
        this.stack.peek();
        assertEquals(EXAMPLE_VALUES.size(), this.stack.size());
    }

    @Test
    public void getMax(){
        fillStackWithExampleValues();
        assertEquals(MAX_EXAMPLE_VALUE, this.stack.getMax());
    }

    @Test
    public void getMin(){
        fillStackWithExampleValues();
        assertEquals(MIN_EXAMPLE_VALUE, this.stack.getMin());
    }
}