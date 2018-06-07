package leetCode;

import java.util.Scanner;

public class CrystalNecklace {
    static int type;
    static int Amount;
    static int[] lo;
    static int[] hi;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        type = in.nextInt();
        lo = new int[type];
        hi = new int[type];
        Amount = in.nextInt();
        for (int i = 0; i < type; i++) {
            lo[i] = in.nextInt();
            hi[i] = in.nextInt();
        }
        System.out.println(mix(0, 0, 0));
    }

    public static int mix(int index, int amount, int planNum) {
        if (index < type - 1) {
            for (int i = lo[index]; i <= hi[index]; i++) {
                planNum = mix(index + 1, amount + i, planNum);
            }
        } else if (Amount - amount <= hi[index] && Amount - amount >= lo[index]) {
            planNum++;
        }
        return planNum;
    }
}
