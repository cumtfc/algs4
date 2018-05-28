package ACM;

import edu.princeton.cs.algs4.Stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.letterCombinations2("23");
    }

    static class Solution {
        char[][] strings = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
                {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        Queue<LetterNode> queueG = new LinkedList<>();

        public List<String> letterCombinations2(String digits) {
            LinkedList<String> ans = new LinkedList<String>();
            if(digits.isEmpty()) return ans;
            String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            ans.add("");
            while(ans.peek().length()!=digits.length()){
                String remove = ans.remove();
                String map = mapping[digits.charAt(remove.length())-'0'];
                for(char c: map.toCharArray()){
                    ans.addLast(remove+c);
                }
            }
            return ans;
        }




        public List<String> letterCombinations(String digits) {
            Queue<LetterNode> queue = new LinkedList<>();
            LetterNode root = new LetterNode(' ');
            queue.offer(root);
            int i = 0;
            while (!queue.isEmpty() && i < digits.length()) {
                addNext(queue.poll(), strings[digits.charAt(i) - 50]);
                if (queue.isEmpty()) {
                    queue = queueG;
                    queueG = new LinkedList<>();
                    i++;
                }
            }
            return root.getSTRS();
        }

        private void addNext(LetterNode node, char[] next) {
            for (char c : next) {
                LetterNode letterNode = new LetterNode(c);
                node.addNext(letterNode);
                queueG.offer(letterNode);
            }
        }
    }

    static class LetterNode {
        public char aChar;
        public List<LetterNode> next = new ArrayList<>();

        LetterNode(char aChar) {
            this.aChar = aChar;
        }

        public void addNext(LetterNode node) {
            next.add(node);
        }

        List<String> STRS = new LinkedList<>();

        List<String> getSTRS() {
            df(new Stack<>(), this);
            return STRS;
        }

        void df(Stack<Character> characters, LetterNode letternode) {
            characters.push(letternode.aChar);
            if (letternode.next.isEmpty()) {
                char[] chars = new char[characters.size()];
                int i = 0;
                for (Character character : characters) {
                    chars[i++] = character;
                }
                String s = new StringBuilder(new String(chars)).reverse().toString().trim();
                if (!s.isEmpty()) {
                    STRS.add(s);
                }
            }
            for (LetterNode c : letternode.next) {
                df(characters, c);
            }
            characters.pop();
        }
    }
}
