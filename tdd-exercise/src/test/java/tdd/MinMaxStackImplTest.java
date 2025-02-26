package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
        final Random random = new Random();
        final int numberOfRandomValues = 10;
        final int upperBoundOfRandomValues = 10;

        final ArrayList<Integer> exampleValuesList = new ArrayList<>();
        for(int count = 0; count < numberOfRandomValues; count++){
            exampleValuesList.add(random.nextInt(upperBoundOfRandomValues));
        }
        return exampleValuesList;
    }

    @Test
    public void pushingValuesChangesSize(){
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
}