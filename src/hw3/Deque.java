package hw3;

import java.util.Arrays;

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
        sb.append(Arrays.toString(array)).append(";\n")
        .append("start: ").append(start).append("; ")
        .append("end: ").append(end).append("; ")
        .append("size: ").append(size).append(";")
        .append("}");
        return sb.toString();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T item) {
        checkSize();
        size++;
        array[start] = item;
        start = decrementIndex(start);
    }
    
    public void addLast(T item) {
        checkSize();
        size++;
        array[end] = item;
        end = incrementIndex(end);
    }

    public T removeFirst() {
        checkSize();
        size--;
        T result = array[start];
        array[start] = null;
        start = decrementIndex(start);
        return result;
    }


    private void checkSize() {
        if (size == array.length) {
            increaseCapacity();
        }
        if (size < 0) {
            throw new RuntimeException("Deque is empty");
        }
    }

    private int incrementIndex(int index) {
        return (index + 1) % array.length;
    }

    private int decrementIndex(int index) {
        index = index - 1 % array.length;
        if (index < 0) return array.length - index;
        return index;
    }

    private void increaseCapacity() {
        int newCapacity = getNewCapacity();
        
    }

    private int getNewCapacity() {
        int newCapacity = array.length * 2 + 1;
        if (newCapacity < array.length) {
            throw new RuntimeException("Capacity can't be increased!");
        }
        return newCapacity;
    }





}
