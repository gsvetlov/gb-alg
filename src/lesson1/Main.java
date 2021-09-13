package lesson1;

public class Main {

    public static void main(String[] args) {
//        int a = 5;
//        int b = 5;

        Person p1 = new Person("Ivan");
        updateName(p1);
        System.out.println(p1);

//        int a = 5;
//        inc(a);
//        System.out.println(a);


    }

    public static void updateName(Person p) {
        p.setName("Super" + p.getName());
    }

    public static int inc(int a) {
        return ++a;
    }

    // O(1)
    public static int test1(int[] arr, int n) {
        return arr[n];
    }

    // O(n)
    public static int test2(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    // n * m   // O(n * m)
    public static int test3(int[][] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == x) {
                    return i * arr.length + j;
                }
            }
        }
        return -1;
    }

    // O(sqrt(n))
    public static boolean test4(int n) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
// O(log n)
    public static int test5(int n) {
        int i = 1;
        while (i <= n) {
            i *= 2;
        }
        return i;
    }

    //O(n*sqrt(n))
    public static int test6(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < Math.sqrt(n); j++) {
                sum += i * j;
            }
        }
        return sum;
    }

}
