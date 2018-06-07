package leetCode;

import java.util.Scanner;

public class Toy {
    static int M;
    static int N;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();//游戏人数
        M = in.nextInt();//玩偶数
        int K = in.nextInt();//位置K
        if (K <= 0 || M == 0 || N == 0 || K > N) {
            System.out.println(0);
            return;
        }
        int[] toyCount = new int[N];

        while (getToy(toyCount, K)) {
            getToy(toyCount, K);
        }
        System.out.println(toyCount[K - 1]);
    }

    private static boolean getToy(int[] toyCount, int K) {
        if (M <= 0) {
            return false;
        }
        toyCount[K - 1]++;
        M--;
        if (K < N && toyCount[K - 1] - toyCount[K] > 1) {
            if (!getToy(toyCount, K+1)) {
                toyCount[K - 1]--;
                M++;
                return false;
            }
        }
        if (K > 1 && toyCount[K - 1] - toyCount[K-2] > 1) {
            if (!getToy(toyCount, K - 1)) {
                toyCount[K - 1]--;
                M++;
                return false;
            }
        }
        return true;
    }
}
