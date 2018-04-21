package ACM;

public class atoi {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("+-2"));
    }

    static class Solution {
        public int myAtoi(String str) {
            str = str.trim();
            if (str.isEmpty()) {
                return 0;
            }
            char c = str.charAt(0);
            boolean flag = false;
            if (c == '-') {
                str = str.substring(1);
                flag = true;
            }else if(c == '+'){
                str = str.substring(1);
            }
            int i = 0;
            for (; i < str.length(); i++) {
                char c1 = str.charAt(i);
                if (c1 < '0' || c1 > '9') {
                    break;
                }
            }
            if (i == 0) {
                return 0;
            }
            int anInt = 0;
            if (flag) {
                try {
                    anInt = Integer.parseInt("-" + str.substring(0, i));
                } catch (Exception e) {
                    anInt = Integer.MIN_VALUE;
                }finally {
                    return anInt;
                }
            }else {
                try {
                    anInt = Integer.parseInt(str.substring(0, i));
                } catch (Exception e) {
                    anInt = Integer.MAX_VALUE;
                }finally {
                    return anInt;
                }
            }
        }
    }
}
