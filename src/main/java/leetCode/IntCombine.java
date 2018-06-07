package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntCombine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars = in.nextLine().toCharArray();
        List<Integer> list = new ArrayList<>(chars.length);
        for (int i = 0; i < chars.length; i++) {
            list.add(chars[i] - 48);
        }
        int num = 1;
        while (true) {
            if (num < 10 && !list.contains(num)) {
                break;
            } else if (num % 10 == 0 && !list.contains(0)) {
                break;
            } else{
                List<Integer> list1 = new ArrayList<>(list);
                boolean flag = false;
                for (char c : String.valueOf(num).toCharArray()) {
                    if (!list1.contains(c - 48)) {
                        flag = true;
                        break;
                    }else {
                        list1.remove(new Integer(c - 48));
                    }
                }
                if (flag) {
                    break;
                }
            }
            num++;
        }
        System.out.println(num);
    }
}
