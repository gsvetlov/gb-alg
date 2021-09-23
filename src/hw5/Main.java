package hw5;

public class Main {
    public static void main(String[] args) {

        Sack sack = new Sack(4);
        sack.addItem(Item.of("guitar", 1, 1500));
        sack.addItem(Item.of("stereo", 4, 3000));
        sack.addItem(Item.of("notebook", 3, 2000));

        int maxValue = sack.getBestValueForVolumeItems();
        System.out.println("best value: " + maxValue);

    }

    /*
     * Cокращаем число итераций используя свойства X^(m*n) = (X^m)^n и X^(m+n) = X^m * X^n и приводя
     * выражение к виду: X^m = (X^(m/2))^2 для четных m X^m = X * X^(m-1) для нечетных m
     */

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
