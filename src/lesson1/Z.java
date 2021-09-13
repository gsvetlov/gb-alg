package lesson1;

import java.io.*;
import java.util.*;

public class Z {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int max = Math.max(Math.max(a, b), c);

        if (!checkWeight(a) || !checkWeight(b) || !checkWeight(c)) {
            out.println("Error");
        } else {
            out.println(max);
        }
        out.flush();
    }

    static boolean checkWeight(int m) {
        return m >= 94 && m <= 727;
    }
}