package ACM;

import java.util.*;

public class BathSinger {
    static Set<Integer> bathInuse = null;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();//浴室数
        int n = in.nextInt();//在用的数量
        bathInuse = new HashSet<>(n+1);
        for (int i = 0; i <n ; i++) {
            bathInuse.add(in.nextInt());
        }
        Integer minIndex = null;
        Integer minDistance = null;
        for (int i = 0; i < m+1; i++) {
            if (!bathInuse.contains(i)) {
                int dis = getDistance(i);
                if (minDistance == null || minDistance > dis) {
                    minDistance = dis;
                    minIndex = i;
                } else if (dis > minDistance) {
                    break;
                }
            }
        }
        System.out.println(minIndex);
    }
    private  static int getDistance(int j){
        int distance = 0;
        for (Integer i : bathInuse) {
            distance+=Math.abs(i-j);
        }
        return distance;
    }
}
