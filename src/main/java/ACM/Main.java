package ACM;

/**
 * @author 冯楚
 * created on 2018/7/22-17:23
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    static int calculate(String[] locations) {
        List<Point> list = new ArrayList<>(locations.length);
        for (int i = 0; i < locations.length; i++) {
            String[] split = locations[i].split(",");
            list.add(new Point(split[0], split[1]));
        }

        return 0;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine().trim());
        int index = 0;
        String[] locations = new String[num];
        while (num-- > 0) {
            locations[index++] = scanner.nextLine();
        }

        System.out.println(calculate(locations));
    }
}

class Point {
    int px;
    int py;
    boolean visited;

    public Point(String px, String py) {
        this.px = Integer.valueOf(px);
        this.py = Integer.valueOf(py);
        this.visited = false;
    }

    public int getLength(Point p) {
        return Math.abs(px - p.px) + Math.abs(py - p.py);
    }
}
