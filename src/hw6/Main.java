package hw6;

import java.util.Random;
import lesson6.MyTreeMap;

public class Main {
    private static Random random = new Random();
    private static final int ITERATIONS = 1_000_000;
    private static int UPPER_BOUND = 100;
    private static int LOWER_BOUND = -100;

    private static int balancedCount = 0;
    private static int unbalancedCount = 0;

    public static void main(String[] args) {
        MyTreeMap<Integer, String> tree = new MyTreeMap<>();
        initBalancedTree(tree);

        for (int iter = 0; iter < ITERATIONS; iter++) {
            tree = new MyTreeMap<>();
            int key = 0;
            while (tree.height() < 4) {
                key = random.nextInt(UPPER_BOUND - LOWER_BOUND) + LOWER_BOUND;
                tree.put(key, "");
            }
            tree.remove(key);

            if (tree.isBalanced()) {
                balancedCount++;
            } else {
                unbalancedCount++;
            }
        }

        System.out.println("Results: ");
        System.out.println("balanced BST: " + balancedCount);
        System.out.println("unbalanced BST: " + unbalancedCount);
        // наилучший результат для высоты 6 = 2/999_998, т.е 0,0002%
        // для меньшей высоты сбалансированных деревьев строится значительно больше:
        // 0,04% для высоты 5, 1,8% для 4, 16% для 3
    }

    private static void displayTreeStatistics(MyTreeMap tree) {
        System.out.println("tree size: " + tree.size());
        System.out.println("tree height: " + tree.height());
        System.out.println("tree balance: " + tree.isBalanced());
    }

    private static void initBalancedTree(MyTreeMap tree) {
        // balanced tree
        tree.put(10, "10");
        tree.put(12, "12");
        tree.put(8, "8");
        tree.put(15, "15");
        tree.put(14, "14");
        tree.put(3, "3");
        tree.put(11, "11");
        displayTreeStatistics(tree);
    }

}
