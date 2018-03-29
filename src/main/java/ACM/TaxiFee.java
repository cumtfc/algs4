package ACM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TaxiFee {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int fee = in.nextInt();
        int[] coins = new int[N];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = in.nextInt();
        }
        Arrays.sort(coins);
        List<Integer> give = new ArrayList<>(N);
        for (int i = 0; i < coins.length; i++) {
            fee -= coins[i];
            give.add(coins[i]);
            if (fee <= 0) {
                break;
            }
        }
        for (int i = give.size() - 1; i >= 0; i--) {
            if (fee + give.get(i) <= 0) {
                fee += give.get(i);
                give.remove(i);
            } else if (fee > 0 && fee - give.get(i) >= 0) {
                fee -= give.get(i);
                give.remove(i);
            }
        }
        System.out.println(give.size());
    }
}
