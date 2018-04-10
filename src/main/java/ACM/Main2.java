package ACM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Solution solution = new Solution();
        solution.generateParenthesis(n);
    }

    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList();
            if (n == 0) {
                ans.add("");
            } else {
                for (int c = 0; c < n; ++c)
                    for (String left : generateParenthesis(c))
                        for (String right : generateParenthesis(n - 1 - c))
                            ans.add("(" + left + ")" + right);
            }
            return ans;
        }
    }
}

