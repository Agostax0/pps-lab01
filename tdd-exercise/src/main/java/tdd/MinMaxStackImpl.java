package tdd;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class MinMaxStackImpl implements MinMaxStack {

    private boolean empty = true;

    List<Integer> stack = new ArrayList<>();

    @Override
    public void push(int value) {
        this.stack.add(value);
        this.stack.sort(Comparator.naturalOrder());
    }

    private void checkEmptyStack() {
        if(this.isEmpty()) throw new IllegalStateException();
    }

    @Override
    public int pop() {
        checkEmptyStack();

        var value = this.stack.get(this.stack.size() - 1);
        this.stack.remove(this.stack.size()-1);

        return value;
    }

    @Override
    public int peek() {
        checkEmptyStack();

        return this.stack.get(this.stack.size() - 1);
    }

    @Override
    public int getMin() {
        checkEmptyStack();

        return 0;
    }

    @Override
    public int getMax() {
        checkEmptyStack();

        return 0;
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
