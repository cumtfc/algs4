package ACM;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Substring {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String sub = null;
        for (int i = 1; i < str.length(); i++) {
            String substring = str.substring(0, i);
            String s = "("+substring+")" + "*";
            Pattern pattern = Pattern.compile(s);
            if (pattern.matcher(str).matches()&& !str.isEmpty()) {
                sub = substring;
            }
        }
        if (sub!=null) {
            System.out.println(sub);
        } else{
            System.out.println(false);
        }
    }
}
