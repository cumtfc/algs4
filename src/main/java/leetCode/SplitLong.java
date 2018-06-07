package leetCode;

import java.util.Scanner;

public class SplitLong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long nextLong = in.nextLong();
            if (nextLong % 2 != 0) {
                System.out.println("No");
                continue;
            }
            long l = nextLong / 2 + 1;
            long Y = 2;
            while (Y <= l) {
                long X = nextLong / Y;
                if (nextLong % Y == 0 && X % 2 != 0) {
                    System.out.print(X + " ");
                    System.out.println(Y);
                    break;
                }
                Y += 2;
            }
            if (Y > l) {
                System.out.println("No");
            }
        }
    }
}
