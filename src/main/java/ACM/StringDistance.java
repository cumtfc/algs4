package ACM;

import java.util.Arrays;
import java.util.Scanner;

public class StringDistance {
    static int count = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] charsA = in.nextLine().toCharArray();
        char[] charsB = in.nextLine().toCharArray();
        if (charsA.length < charsB.length) {
            //保证charsA是较大的
            char[] temp = charsA;
            charsA = charsB;
            charsB = temp;
        }
        int length = charsB.length;
        for (int i = 0; i+length -1< charsA.length; i++) {
            count(Arrays.copyOfRange(charsA, i, i + length), charsB);
        }
        System.out.println(count);
    }
    private static void count(char[] charsA,char[] charsB){
        for (int i = 0; i < charsA.length; i++) {
            if (charsA[i] != charsB[i]) {
                count++;
            }
        }
    }
}
