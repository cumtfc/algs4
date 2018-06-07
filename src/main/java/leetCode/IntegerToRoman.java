package leetCode;

public class IntegerToRoman {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.intToRoman(58));
        System.out.println(solution.romanToInt("MMM"));
    }

    static class Solution {
        String[][] map = {{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                          {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                          {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                          {"", "M", "MM", "MMM"}};
        int[] base = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        public String intToRoman(int num) {
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                int n = num % 10;
                ans.insert(0, map[i][n]);
//                ans.append(map[i][n]);
                num = num / 10;

            }
            return ans.toString();
        }

        public int romanToInt(String s) {
            int res = 0;
            for (int i = 0; i < symbol.length; i++) {
                while (s.startsWith(symbol[i])){
                    s = s.substring(symbol[i].length());
                    res += base[i];
                }
            }
            return res;
        }

    }
}
