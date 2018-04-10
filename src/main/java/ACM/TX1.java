package ACM;

import java.util.Scanner;

public class TX1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] muns = new int[n];
        int param = -1;
        long sum = 0;
        for (int i = 0; i < muns.length; i++) {
            muns[i] = param * (i + 1);
            sum += param * (i + 1);
            if (i + 1 >= m && (i + 1) % m == 0) {
                param = param * -1;
            }
        }
        System.out.println(sum);
    }
}
