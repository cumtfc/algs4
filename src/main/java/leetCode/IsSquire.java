package leetCode;

import java.util.Arrays;
import java.util.Scanner;

public class IsSquire {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int group = in.nextInt();
        Stone[] stones = new Stone[4];
        while (group > 0) {
            for (int i = 0; i < stones.length; i++) {
                stones[i] = new Stone(in.nextInt());
            }
            for (int i = 0; i < stones.length; i++) {
                stones[i].y = in.nextInt();
            }
            Arrays.sort(stones);
            System.out.println(isSquire(stones));
            group--;
        }
    }

    private static Double distance(Stone stone1, Stone stone2) {
        return Math.sqrt(Math.pow(Math.abs(stone1.x - stone2.x), 2) + Math.pow(Math.abs(stone1.y - stone2.y), 2));
    }

    private static String isSquire(Stone[] stones) {
        boolean b1 = distance(stones[0], stones[1]).equals(distance(stones[0], stones[2]));
        boolean b2 = distance(stones[3], stones[1]).equals(distance(stones[3], stones[2]));
        boolean b3 = distance(stones[3], stones[2]).equals(distance(stones[0], stones[2]));
        boolean b4 = distance(stones[3], stones[0]).equals(distance(stones[1], stones[2]));
        if (b1 && b2 && b3 && b4) {
            return "Yes";
        }
        return "No";
    }

}

class Stone implements Comparable<Stone> {
    public Integer x;
    public Integer y;

    Stone(Integer x) {
        this.x = x;
    }

    @Override
    public int compareTo(Stone o) {
        return this.x.compareTo(o.x);
    }
}