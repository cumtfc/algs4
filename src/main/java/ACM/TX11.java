package ACM;

import java.util.Scanner;

public class TX11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long ans = (long) (n / (2 * m) * Math.pow(m, 2));
        System.out.println(ans);
    }
}
