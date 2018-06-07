package leetCode;

import java.util.Scanner;

public class HRNoOut {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] ints = in.nextLine().split(",");
            int a = Integer.parseInt(ints[0]);
            int b = Integer.valueOf(ints[1]);
            int c = Integer.parseInt(ints[2]);
            if ((a^b^c)==0) {
                System.out.println(1);
            }
            if ((a^b)<c) {
                System.out.println("C,"+(c-(a^b)));
            }
            if ((a^c)<b) {
                System.out.println("B,"+(b-(a^c)));
            }
            if ((b^c)<a) {
                System.out.println("A,"+(a-(b^c)));
            }
        }
    }
}
