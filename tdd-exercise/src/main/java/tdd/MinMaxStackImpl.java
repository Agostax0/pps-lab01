package tdd;

public class MinMaxStackImpl implements MinMaxStack {

    private boolean empty = true;

    @Override
    public void push(int value) {

    }

    @Override
    public int pop() {
        if(this.empty) throw new IllegalStateException();

        return 0;
    }

    @Override
    public int peek() {
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
