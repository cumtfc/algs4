package ACM;

public class atoi {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("123"));
    }

    static class Solution {
        public int myAtoi(String str) {
            str = str.trim();
            char c = str.charAt(0);
            if (c != '-') {
                return 0;
            }
            if (c < 'A' || c > 'z'){
                return 0;
            }
            int i = 0;
            for (; i < str.length(); i++) {
                char c1 = str.charAt(i);
                if (c1 != '-' && (c1 < '0' || c1 > '9')) {
                    break;
                }
            }
            return Integer.parseInt(str.substring(0, i));
        }
    }
}
