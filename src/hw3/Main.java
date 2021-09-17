package hw3;

public class Main {
    public static void main(String[] args) {
        String test = "This is string under test!";
        System.out.println(test);
        System.out.println(revertString(test));

    }

    private static String revertString(String string) {
        Deque<Character> deque = new Deque<>(string.length());
        for (char c : string.toCharArray()) {
            deque.addLast(c);
        }
        StringBuilder sb = new StringBuilder(string.length());
        while (!deque.isEmpty()) {
            sb.append(deque.removeLast());
        }
        return sb.toString();
    }
    
}
