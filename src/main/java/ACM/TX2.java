package ACM;

import java.util.Scanner;

public class TX2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int aim = in.nextInt();
        int A = in.nextInt();
        int X = in.nextInt();
        int B = in.nextInt();
        int Y = in.nextInt();
        int cnt = 0;
        long ans = 0;
        for (int i = 0; i < X; i++) {
            cnt += A;
            if (cnt == aim) {
                ans += combine(X, i + 1);
                break;
            }
            if (cnt > aim) {
                break;
            }
            int cnt2 = cnt;
            for (int j = 0; j < Y; j++) {
                cnt2 += B;
                if (cnt2 == aim) {
                    ans += ans += combine(X, i + 1) * combine(Y, j + 1);
                    break;
                }
                if (cnt2 > aim) {
                    break;
                }
            }
        }
        System.out.println(ans % 1000000007);
    }
    //算法有问题，未AC
    private static long combine(int m, int n) {
        int vn = n;
        double ans = 1;
        for (int i = 0; i <vn ; i++) {
            ans =ans* m--/n--;
        }
        return (long) ans;
    }
}
