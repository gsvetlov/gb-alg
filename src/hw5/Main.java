package hw5;

public class Main {
    /***
     * public static decimal QuickRecursivePow(decimal a, decimal b)        
        {
            if (b == 0) return a == 0 ? 0 : 1;
            count++;            
            if (b == 1) return a;
            if (b == 2) return a * a;
            if (b % 2 == 0) return QuickRecursivePow(QuickRecursivePow(a, b / 2), 2);
            else return a * QuickRecursivePow(a, --b);            
        }
     */
    public static void main(String[] args) {

    }

    /* сокращаем число итераций используя свойство a^(m*n) = (a^m)^n  
    */

    public static double PowQuick(double a, double b) {
        if (b == 0) {
            return a == 0 ? 0 : 1;
        }
        else if (b == 1) {
            return a;
        }
        else if (b == 2) {
            return a * a;
        }
        else if (b % 2 == 0) {
            return PowQuick(PowQuick(a, b / 2), 2);
        }
        else { 
            return a * PowQuick(a, --b);
        }
    }
}
