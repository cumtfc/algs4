package leetCode;

public class JDBrackets {
    public static void main(String[] args) {
        System.out.println(solve("))(("));
    }

    public static String solve(String string) {
        int ls = string.length();
        int ans = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < ls; i++) {
            if (string.charAt(i) == '(')
                left += 1;
            if (string.charAt(i) == ')')
                right += 1;
            ans = Math.max(ans, right - left);
        }
        if (string == ")(")
            return "Yes";
        if (left == right && ans <= 2 && left >= 2)
            return "Yes";
        return "No";
    }


}
