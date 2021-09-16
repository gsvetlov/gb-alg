package hw3;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> d = new Deque<>(10);
        d.addFirst(1);
        System.out.println(d);
        d.addFirst(2);
        System.out.println(d);
        d.addLast(3);
        System.out.println(d);
        d.addLast(4);
        System.out.println(d);
        d.addFirst(5);
        System.out.println(d);
    }
    
}
