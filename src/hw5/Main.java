package hw5;

import java.time.LocalTime;
import java.util.Random;
public class Main {
    public static void main(String[] args) {

        Sack sack = initSack();
        assertEquals(4000, sack.getBestValueRecursive());

        sack = initRandomSack(5000);

        long start = System.nanoTime();
        int maxValue = sack.getBestValueForVolume();
        long end = System.nanoTime() - start;

        displayResult(maxValue, end, "//// straight ////");

        start = System.nanoTime();
        maxValue = sack.getBestValueRecursive();
        end = System.nanoTime() - start;

        displayResult(maxValue, end, "//// recursive ////");

    }

    private static void displayResult(int maxValue, long end, String title) {
        System.out.println(title);
        System.out.println("best value: " + maxValue);
        System.out.println("time elapsed: " + LocalTime.ofNanoOfDay(end));
    }

    private static Sack initSack() {
        Sack sack = new Sack(4);
        sack.addItem(Item.of(1, 1500));
        sack.addItem(Item.of(4, 3000));
        sack.addItem(Item.of(3, 2000));
        sack.addItem(Item.of(1, 2000));
        return sack;
    }

    private static Sack initRandomSack(int capacity) {
        Sack sack = new Sack(capacity);
        Random random = new Random();
        for (int i = 0; i < capacity; i++) {
            sack.addItem(Item.of(random.nextInt(capacity) + 1, random.nextInt(9000) + 1000));
        }
        return sack;
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual)
            throw new RuntimeException(
                    "Аргументы не совпадают. Ожидаем: " + expected + "; Получено: " + actual);
    }


    // Рекурсивное возведение в степень.
    // Cокращаем число итераций используя свойства X^(m*n) = (X^m)^n и X^(m+n) = X^m * X^n
    // и приводя выражение к виду:
    // X^m = (X^(m/2))^2 для четных m
    // X^m = X * X^(m-1) для нечетных m
    public static double PowQuick(double a, double b) {
        if (b < 3) {
            if (b == 2) {
                return a * a;
            } else if (b == 1) {
                return a;
            } else if (b == 0) {
                return a == 0 ? 0 : 1; // принимаем 0^0 = 0, x^0 = 1;
            } else {
                throw new RuntimeException("Negative power: " + b);
            }
        } else if (b % 2 == 0) {
            return PowQuick(PowQuick(a, b / 2), 2);
        } else {
            return a * PowQuick(a, --b);
        }
    }

}
