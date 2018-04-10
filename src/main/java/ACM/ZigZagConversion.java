package ACM;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("", 1));
    }
    static class Solution {
        public String convert(String s, int numRows) {
            if (s.equals("") || numRows == 1) {
                return s;
            }
            List<List<Character>> listList = new ArrayList<>(numRows);
            int t = numRows * 2 - 2;
            for (int i = 0; i < numRows; i++) {
                listList.add(new ArrayList<>(s.length() / t * (numRows - 1) + 1));
            }
            char[] chars = s.toCharArray();
            listList.get(0).add(chars[0]);
            for (int i = 1; i < chars.length; i++) {
                int j = (i + 1) % t;
                if (j == 0) {
                    listList.get(1).add(chars[i]);
                } else if (j<=numRows) {
                    listList.get(j-1).add(chars[i]);
                }else {
                    listList.get(numRows*2-j-1).add(chars[i]);
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (List<Character> characters : listList) {
                for (Character character : characters) {
                    stringBuffer.append(character);
                }
            }
            return stringBuffer.toString();
//            PAYPALISHIRING,PAHNAPLSIIGYIR;
        }
    }
}
