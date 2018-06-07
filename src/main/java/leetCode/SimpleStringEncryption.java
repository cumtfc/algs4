package leetCode;

import java.util.Scanner;

public class SimpleStringEncryption {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 'z'||chars[i]<'A') {
                continue;
            }
            if (chars[i] == 'z'||chars[i]=='Z') {
                chars[i] -= 25;
            }else {
                chars[i] += 1;
            }

        }
        System.out.println(new String(chars));
    }

    public static String get(Object s) {
        return "z!";
    }
}
