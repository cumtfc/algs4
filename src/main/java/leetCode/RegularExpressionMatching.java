package leetCode;


public class RegularExpressionMatching {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
//        System.out.println(solution.isMatch("aa", "a"));
//        System.out.println(solution.isMatch("aa", "a*"));
//        System.out.println(solution.isMatch("ab", ".*"));
        System.out.println(solution.isMatch("aaaaxz", "a*axz"));
//        System.out.println(solution.isMatch("mississippi", "mis*is*p*."));
//        System.out.println(solution.isMatch("aaba", "aaba"));

    }

    static class Solution {
        public boolean isMatch(String text, String pattern) {
            if (pattern.isEmpty()) return text.isEmpty();
            boolean first_match = (!text.isEmpty() &&
                    (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

            if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
                return (isMatch(text, pattern.substring(2)) ||
                        (first_match && isMatch(text.substring(1), pattern)));
            } else {
                return first_match && isMatch(text.substring(1), pattern.substring(1));
            }
        }
    }

    enum Result {
        TRUE, FALSE
    }

    static class Solution2 {
        Result[][] memo;

        public boolean isMatch(String text, String pattern) {
            memo = new Result[text.length() + 1][pattern.length() + 1];
            return dp(0, 0, text, pattern);
        }

        public boolean dp(int i, int j, String text, String pattern) {
            if (memo[i][j] != null) {
                return memo[i][j] == Result.TRUE;
            }
            boolean ans;
            if (j == pattern.length()) {
                ans = i == text.length();
            } else {
                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));

                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    ans = (dp(i, j + 2, text, pattern) ||
                            first_match && dp(i + 1, j, text, pattern));
                    //前一种是重复0次或者*后一个匹配，后一种是重复非0次
                } else {
                    ans = first_match && dp(i + 1, j + 1, text, pattern);
                }
            }
            memo[i][j] = ans ? Result.TRUE : Result.FALSE;
            return ans;
        }
    }
}
