package leetCode;

import java.util.Scanner;

public class Integers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
//        int x = 0;
        int count = 0;
//        while (x <= n) {
//            int y = 1;
//            while (y <= n) {
//                if (x % y >= k) {
//                    count++;
//                }
//                y++;
//            }
//            x++;
//        }
        for (int y = n; y <= n && y >= k; y--) {
            int x = 0;
            while (x < n) {
                int e = Math.min(n + 1, x + y) - (x + k);
                if (e > 0) {
                    count += e;
                }
                x += y;
            }
        }
        System.out.println(count);
    }

}
