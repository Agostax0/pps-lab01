package tdd;

import java.util.ArrayList;
import java.util.List;

public class CircularQueueImpl implements CircularQueue {

    public static final int MAX_CAPACITY = 20;
    private static final int OLDEST_ELEMENT_INDEX = 0;
    private final List<Integer> queue = new ArrayList<>();

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public int size() {
        return this.queue.size();
    }

    @Override
    public void add(int value) {
        if(this.queue.size() == MAX_CAPACITY) this.queue.remove(OLDEST_ELEMENT_INDEX);
        this.queue.add(value);
    }
}
