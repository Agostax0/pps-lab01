package tdd;

public class MinMaxStackImpl implements MinMaxStack {

    private boolean empty = true;

    @Override
    public void push(int value) {

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
        return 0;
    }

    @Override
    public int getMax() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return this.empty;
    }

    @Override
    public int size() {
        return 0;
    }
}
