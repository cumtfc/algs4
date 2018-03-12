package sort;

import edu.princeton.cs.algs4.StdRandom;

//少于2NlgN+2N次比较以及一半次数的交换，2N是构造，2NlgN是每次下沉最多需要2lgN次比较
public class PQSort extends Example {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }
        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    private static void sink(Comparable[] a, int k, int n) {
        if (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(a, j, j + 1)) j++;
            if (!less(a, k, j)) return;
            exch(a, k, j);
            sink(a, j, n);
        }
    }


    public static boolean less(Comparable[] a, int i, int j) {
        return a[i - 1].compareTo(a[j - 1]) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = t;
    }


    public static void main(String[] args) {
        Integer[] a = new Integer[20];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(100);
        }
        sort(a);
        show(a);
    }
}
