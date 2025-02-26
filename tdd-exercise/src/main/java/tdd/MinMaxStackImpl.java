package tdd;

import java.util.Stack;

public class MinMaxStackImpl implements MinMaxStack {

    private boolean empty = true;

    Stack<Integer> stack = new Stack<>();

    @Override
    public void push(int value) {
        this.stack.push(value);
    }

    private void checkEmptyStack() {
        if(this.empty) throw new IllegalStateException();
    }

    @Override
    public int pop() {
        checkEmptyStack();

        return 0;
    }

    @Override
    public int peek() {
        checkEmptyStack();

        return 0;
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
