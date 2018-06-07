package ACM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generateParenthesis(3);
    }

    static class Solution {
        private List<String> list;

        public List<String> generateParenthesis(int n) {
            list = new ArrayList<>();
            generateParenthesis(n, "", "");
            return list;
        }

        public void generateParenthesis(int n, String left, String right) {
            String str = "(" + left + ")" + right;
            if (--n == 0) {
                list.add(str);
            } else {
                generateParenthesis(n, str, "");
                generateParenthesis(n, "", str);
            }
        }
    }
}
