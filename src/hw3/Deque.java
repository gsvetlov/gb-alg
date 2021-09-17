package hw3;

import java.util.Arrays;
import java.util.function.IntSupplier;

public class Deque<T extends Comparable<T>> {
    private T[] array;
    private int size;
    private int start;
    private int end;

    public Deque(int capacity) {
        array = (T[]) new Comparable[capacity];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Deque { ");
        sb.append(Arrays.toString(array)).append(";\n").append("start: ").append(start).append("; ")
                .append("end: ").append(end).append("; ").append("size: ").append(size).append(";")
                .append("}");
        return sb.toString();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    public void addFirst(T item) {
        addItem(item, this::decrementStart);
    }
    
    public void addLast(T item) {
        addItem(item, this::incrementEnd);
    }

    private void addItem(T item, IntSupplier action) {
        increaseCapacityIfFull();
        array[action.getAsInt()] = item;
        size++;
    }

    public T removeFirst() {
        return removeItem(start, this::incrementStart);
    }

    public T removeLast() {
        return removeItem(end, this::decrementEnd);
    }

    private T removeItem(int elementIndex, IntSupplier action) {
        throwIfEmpty();
        T item = array[elementIndex];
        array[elementIndex] = null;
        size--;
        if (!isEmpty()) {
            action.getAsInt();
        }
        return item;
    }

    private void throwIfEmpty() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
    }

    private void increaseCapacityIfFull() {
        if (isFull()) {
            increaseCapacity();
        }
    }

    private void increaseCapacity() {
        int newCapacity = getIncreasedCapacity();
        DequeStruct struct = getInternalArrayStruct();
        T[] newArray = (T[]) new Comparable[newCapacity];
        System.arraycopy(array, struct.firstPos, newArray, 0, struct.firstLength);
        if (struct.isPartitioned) {
            System.arraycopy(array, struct.secondPos, newArray, struct.firstLength,
                    struct.secondLength);
        }
        array = newArray;
        setIndices(0, size - 1);
    }

    private int getIncreasedCapacity() {
        int newCapacity = array.length + array.length / 2 + 1;
        if (newCapacity < array.length) {
            throw new RuntimeException("Capacity can't be increased!");
        }
        return newCapacity;
    }

    private int incrementStart() {
        if (!isEmpty()) {
            start = cyclicIncrementIndex(start);
        }
        return start;
    }

    private int incrementEnd() {
        if (!isEmpty()) {
            end = cyclicIncrementIndex(end);
        }
        return end;
    }

    private int decrementStart() {
        if (!isEmpty()) {
            start = cyclicDecrementIndex(start);
        }
        return start;
    }

    private int decrementEnd() {
        if (!isEmpty()) {
            end = cyclicDecrementIndex(end);
        }
        return end;
    }

    private int cyclicIncrementIndex(int i) {
        return ++i % array.length;
    }

    private int cyclicDecrementIndex(int i) {
        return --i < 0 ? i + array.length : i % array.length;
    }

    private DequeStruct getInternalArrayStruct() {
        if (start >= end) {
            return new DequeStruct(start, array.length - start, 0, end + 1);
        }
        return new DequeStruct(start, end - start);
    }

    private void setIndices(int start, int end) {
        this.start = start;
        this.end = end;
    }

    private class DequeStruct {
        private int firstPos;
        private int firstLength;
        private int secondPos;
        private int secondLength;
        private boolean isPartitioned;

        private DequeStruct(int firstPos, int firstLength) {
            this.firstPos = firstPos;
            this.firstLength = firstLength;
        }

        private DequeStruct(int firstPos, int firstLength, int secondPos, int secondLength) {
            this(firstPos, firstLength);
            this.secondLength = secondLength;
            this.secondPos = secondPos;
            isPartitioned = true;
        }
    }
}
