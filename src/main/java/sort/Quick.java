package sort;

import edu.princeton.cs.algs4.StdRandom;

public class Quick extends Example {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    //有大量和切分元素等值元素时，左右扫描时和切分元素相等时停下可以避免扫描时间变成平方级
    public static void sort(Comparable[] a, int start, int end) {
        if (end <= start) {
            return;
        }
        int j = partition(a, start, end);
        sort(a, start, j - 1);
        sort(a, j + 1, end);
    }

    public static int partition(Comparable[] a, int start, int end) {
        int i = start;
        int j = end + 1;
        Comparable v = a[start];
        while (true) {
            while (less(v, a[--j])) {
                if (j == start) {
                    break;
                }
            }
            while (less(a[++i], v)) {
                if (i == end) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, start, j);
        return j;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[20];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(100);
        }
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
