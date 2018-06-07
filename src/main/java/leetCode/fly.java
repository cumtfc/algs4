package leetCode;

import java.util.Scanner;

public class fly {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] needs = new int[n];
        for (int i = 0; i < n; i++) {
            needs[i] = in.nextInt();
        }
        System.out.println(solve(needs, m,n));

    }

    //    private static String solve(int[] needs, int m) {
//        for (int i = 0; i < needs.length; i++) {
//            int cnt=0;
//            for (int j = i; j < needs.length; j++) {
//                if (needs[j] == m) {
//                    return "perfect";
//                }
//                cnt += needs[j];
//                if (cnt == m) {
//                    return "perfect";
//                }
//                if (cnt > m) {
//                    cnt -= needs[j];
//                }
//            }
//        }
//        return "good";
//    }
    public static String solve(int[] needs, int m,int n) {
        int[][] f = new int[n + 1][m + 1];

        for (int i = 0; i < f.length; i++) {
            f[i][0] = 0;
        }
        for (int i = 0; i < f[0].length; i++) {
            f[0][i] = 0;
        }
        for (int i = 1; i < f.length; i++) {
            for (int j = 1; j < f[0].length; j++) {
                if (needs[i - 1] > j) {
                    f[i][j] = f[i - 1][j];
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - needs[i - 1]] + needs[i - 1]);
                }
            }
        }
        return f[n][m]==m?"perfect":"good";
    }
}
