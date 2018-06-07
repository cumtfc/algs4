package leetCode;

import java.util.EmptyStackException;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("(([)])"));
    }

    static class Solution {
        public boolean isValid(String s) {
            if (s.length()%2!=0) return false;
            Stack<Character> left = new Stack<>();//(

            for (int i = 0; i <s.length() ; i++) {
                try {
                    switch (s.charAt(i)) {
                        case '(':
                            left.push('(');
                            break;
                        case ')':
                            if (left.pop()!='(') {
                                return false;
                            }
                            break;
                        case '[':
                            left.push('[');
                            break;
                        case ']':
                            if (left.pop()!='[') {
                                return false;
                            }
                            break;
                        case '{':
                            left.push('{');
                            break;
                        case '}':
                            if (left.pop()!='}') {
                                return false;
                            }
                            break;
                    }
                } catch (EmptyStackException e) {
                    return false;
                }
            }
            return left.empty();
        }
    }
}
