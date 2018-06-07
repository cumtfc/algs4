package leetCode;

import java.util.*;

public class WordTransform {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = {"si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"};
        List<String> wordList = Arrays.asList(strings);
        System.out.println(solution.ladderLength("qa", "sq", wordList));

    }


}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Node root = new Node(beginWord);
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        setNexts(wordList, queue);
        int count = 0;
        Integer pathCount = findPath(root, endWord, count);
        if (pathCount == 0) {
            return 0;
        }
        return pathCount + 1;
    }

    private static Integer findPath(Node node, String resoult, int count) {
        if (node.next.size() == 0) {
            return count;
        }
        count++;
        Integer tempCount = null;
        for (Node child : node.next) {
            if (!Objects.equals(child.str, resoult)) {
                int b = findPath(child, resoult, count);
                if (b > count && (tempCount == null || tempCount > b)) {
                    tempCount = b;
                }
            } else {
                return count;
            }
        }
        if (tempCount != null && count < tempCount) {
            return tempCount;
        }

        return --count;

    }

    private static void setNexts(List<String> strs, Queue<Node> queue) {
        while (queue.iterator().hasNext()) {
            Node node = queue.poll();
            for (int i = 0; i < strs.size(); i++) {
                if (isNear(strs.get(i), node.str)) {
                    Node child = new Node(strs.get(i));
                    node.next.add(child);
                    strs.set(i, "");
                }
            }
            node.next.forEach(queue::offer);
        }




    }

    private static boolean isNear(String a, String b) {
        if (a.length() != b.length() ) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }
        return true;
    }
}

class Node {
    public String str;
    public List<Node> next;

    public Node(String str) {
        this.str = str;
        this.next = new ArrayList<>();
    }
}