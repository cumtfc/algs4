package leetCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * <p>
 * 过年啦！小B高兴的不行了，她收到了很多红包，可以实现好多的愿望呢。小B可是对商店货架上心仪的货物红眼好久了，只因囊中羞涩作罢，这次她可是要大大的shopping一番。小B想去购物时，总是习惯性的把要买的东西列在一个购买清单上，每个物品单独列一行（即便要买多个某种物品），这次也不例外。
 * <p>
 * 小B早早的来到了商店，由于她太激动，以至于她到达商店的时候，服务员还没有把各个商品的价签排好，所有的价签还都在柜台上。因此还需要一段时间，等服务器把价签放到对应的商品处，小B才能弄清她的购买清单所需的费用。
 * <p>
 * 小B都有些迫不及待了，她希望你能够根据购买清单，帮她算算最好和最坏的情况下所需的费用，你能帮她吗？
 * 输入
 * 输入中有多组测试数据。每组测试数据的第一行为两个整数n和m（1=＜n, m=＜1000），分别表示价签的数量以及小B的购买清单中所列的物品数。第二行为空格分隔的n个正整数，表示货架上各类物品的价格，每个数的大小不超过100000。随后的m行为购买清单中物品的名称，所有物品名称为非空的不超过32个拉丁字母构成的字符串，保证清单中不同的物品种类数不超过n，且商店有小B想要购买的所有物品。
 * 样例输出
 * 5 3
 * 4 2 1 10 5
 * apple
 * orange
 * mango
 * 6 5
 * 3 5 1 6 8 1
 * peach
 * grapefruit
 * banana
 * orange
 * orange
 * 输出
 * 对每组测试数据，在单独的行中输出两个数a和b，表示购买清单上所有的物品可能需要的最小和最大费用。
 * 样例输出
 * 7 19
 * 11 30
 */

public class ShoppingList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int count;
            int pick;
            count = in.nextInt();
            pick = in.nextInt();
            int[] list = new int[count];
            for (int i = 0; i < count; i++) {
                int nextInt = in.nextInt();
                list[i] = nextInt;
            }
            Arrays.sort(list);
            String[] strings = new String[pick];
            for (int i = 0; i < pick; i++) {
                String key = in.nextLine();
                if (!key.isEmpty()) {
                    strings[i] = key;
                } else {
                    i--;
                }
            }
            Arrays.sort(strings);
            int min = 0;
            int max = 0;
            String oldVal = "";
            int[] kind = new int[pick];
            int strIndex = -1;
            for (int i = 0; i < strings.length; i++) {
                if (strings[i].equals(oldVal)) {
                    kind[strIndex] = kind[strIndex] + 1;
                } else {
                    strIndex++;
                    kind[strIndex] = kind[strIndex] + 1;
                }
                oldVal = strings[i];
            }
            Arrays.sort(kind);
            for (int i = 0; i < kind.length; i++) {
                if (i < count) {
                    min += list[i] * kind[kind.length - i - 1];
                    max += list[list.length - 1 - i] * kind[kind.length - i - 1];
                } else {
                    min += list[count - 1] * kind[kind.length - i - 1];
                    max += list[0] * kind[kind.length - i - 1];
                }

            }
            System.out.println(min + " " + max);
        }
    }
}