package hw4;

import lesson4.MyLinkedList;

public class LinkedQueue<T> {
    private final MyLinkedList<T> list = new MyLinkedList<>();

    public void enqueue(T item) {
        list.insertFirst(item);
    }

    public T dequeue() {
        return list.removeLast();
    }

    public T peek() {
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }

}
