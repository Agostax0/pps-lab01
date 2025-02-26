package tdd;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinMaxStackImpl implements MinMaxStack {

    List<Integer> stack = new ArrayList<>();
    private static final int MIN_VALUE_INDEX = 0;
    private static int MAX_VALUE_INDEX = 0;

    private void updateMaxValueIndex(){
        MAX_VALUE_INDEX = this.stack.size()-1;
    }

    @Override
    public void push(int value) {
        this.stack.add(value);
        this.stack.sort(Comparator.naturalOrder());
        this.updateMaxValueIndex();
    }

    private void checkEmptyStack() {
        if(this.isEmpty()) throw new IllegalStateException();
    }

    @Override
    public int pop() {
        checkEmptyStack();

        var value = this.stack.get(MAX_VALUE_INDEX);
        this.stack.remove(MAX_VALUE_INDEX);
        this.updateMaxValueIndex();

        return value;
    }

    @Override
    public int peek() {
        checkEmptyStack();
        return this.stack.get(MAX_VALUE_INDEX);
    }

    @Override
    public int getMin() {
        checkEmptyStack();

        return this.stack.get(MIN_VALUE_INDEX);
    }

    @Override
    public int getMax() {
        checkEmptyStack();

        return this.stack.get(MAX_VALUE_INDEX);
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public int size() {
        return this.stack.size();
    }
}
