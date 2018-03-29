package ACM;

import java.util.Scanner;

public class APlusBCompareC {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        if (in.hasNextInt()) {
            count = in.nextInt();
        }
        int i = 0;
        while (count > 0) {
            double a = in.nextDouble();
            double b = in.nextDouble();
            double c = in.nextDouble();
            System.out.println("Case #" + ++i + ": " + String.valueOf((a + b) > c));
            count--;
        }
    }
}
