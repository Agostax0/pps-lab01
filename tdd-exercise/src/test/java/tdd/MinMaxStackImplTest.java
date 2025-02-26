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

    private ArrayList<Integer> generateExampleValues(){
        return new ArrayList<>(
                List.of(
                        3, 1, 1, 6, 2, 5, 8, 7, 10, 9
                )
        );
    }

    @Test
    public void pushingValuesIncreasesSize(){
        final var exampleValues = generateExampleValues();

        exampleValues.forEach( exampleValue -> this.stack.push(exampleValue));

        assertEquals(exampleValues.size(), this.stack.size());
    }

    @Test
    public void pushingValuesMeansNoLongerEmpty(){
        final var exampleValues = generateExampleValues();
        exampleValues.forEach( exampleValue -> this.stack.push(exampleValue));

        assertFalse(this.stack.isEmpty());
    }

    @Test
    public void popValueIsMax(){
        final var exampleValues = generateExampleValues();
        final int maxValueAdded = Collections.max(exampleValues);

        exampleValues.forEach( exampleValue -> this.stack.push(exampleValue));

        assertEquals(maxValueAdded, this.stack.pop());
    }

    @Test
    public void poppingValuesDecreasesSize(){
        final var exampleValues = generateExampleValues();
        exampleValues.forEach( exampleValue -> this.stack.push(exampleValue));

        int expectedSize = exampleValues.size();

        while(expectedSize > 0){
            assertEquals(expectedSize, this.stack.size());
            expectedSize--;
            this.stack.pop();
        }
    }

    @Test
    public void peekValueIsMax(){
        final var exampleValues = generateExampleValues();
        final int maxValueAdded = Collections.max(exampleValues);

        exampleValues.forEach( exampleValue -> this.stack.push(exampleValue));

        assertEquals(maxValueAdded, this.stack.peek());
    }
}