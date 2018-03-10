package sort;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Example {
    private static int count = 0;
    //选择排序,核心思想是每次外部循环都把当前指针及以后的最小元素放到当前指针位置
    //N^2次比较，N次交换
//    public static void sort(Comparable[] a) {
//        for (int i = 0; i < a.length; i++) {
//            int min = i;
//            for (int j = i+1; j < a.length; j++) {
//                if (less(a[j],a[min])) {
//                    min = j;
//                }
//            }
//            exch(a,i,min);
//        }
//    }

    //插入排序,核心思想是往前查找把后面的值往前面插入
    //最好情况N-1次比较，0次交换
    //最坏情况N^2/2次比较，N^2/2次交换
//    public static void sort(Comparable[] a) {
//        for (int i = 0; i < a.length; i++) {
//            for (int j = i; j >0 && less(a[j],a[j-1]); j--) {
//                exch(a, j-1, j);
//            }
//        }
//    }
    //希尔排序，插入排序的高级版，核心思想是保证相隔H的元素有序，最后h=1时插入排序，适用于大数组
//    public static void sort(Comparable[] a) {
//        int N = a.length;
//        int h = 1;
//        while (N / 3 > h) {
//            h = h * 3 + 1;
//        }
//        while (h >= 1) {
//            for (int i = h; i < N; i++) {
//                for (int j = i; j >= h && less(a[j], a[j - h]); j = j - h) {
//                    exch(a,j,j-h);
//                }
//            }
//            h = h / 3;
//        }
//    }

//    //归并排序(循环版,自底向上)，核心思想是分治，大数组对半分分别排序子数组再归并
//    public static void sort(Comparable[] a) {
//        int n = a.length;
//        for (int sz = 1; sz < n; sz=sz+sz) {
//            for (int i = 0; i < n-sz; i = i + (sz + sz)) {
//                merge(a,i+sz,i,Math.min(i+sz+sz-1,n-1));
//            }
//        }
//        show(a,String.valueOf(count++));
//    }

    //归并排序，核心思想是分治，大数组对半分分别排序子数组再归并
    //比较次数1/2NlgN至NlgN
    public static void sort(Comparable[] a) {
        int n = a.length;
        sort(a, 0, n - 1);
        show(a, String.valueOf(count++));
    }


    public static void sort(Comparable[] a, int start, int end) {
        int mid = (start + end) / 2 + 1;
        if (end <= start) return;
        sort(a, start, mid - 1);
        sort(a, mid, end);
        merge(a, mid, start, end);
        show(a, String.valueOf(count++));
    }

    private static void merge(Comparable[] a, int mid, int start, int end) {
        Comparable[] comparable = a.clone();
        int right = mid;
        int left = start;
        for (int i = start; i <= end; i++) {
            if (left == mid) {
                a[i] = comparable[right];
                right++;
            } else if (right > end) {
                a[i] = comparable[left];
                left++;
            } else if (less(comparable[left], comparable[right])) {
                a[i] = comparable[left];
                left++;
            } else {
                a[i] = comparable[right];
                right++;
            }
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void show(Comparable[] a, String msg) {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.01);
        for (int i = 0; i < a.length; i++) {
            StdDraw.line(i * 0.01, 0, i * 0.01, Double.valueOf((Integer) a[i] * 0.008));
        }
        StdDraw.save("src/main/resources/sort-" + msg + ".png");
//        try {
//            Thread.sleep(0);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        if (!msg.isEmpty()) {
            StdDraw.clear();
        }
    }

    public static void main(String[] args) {
        StdDraw.setCanvasSize(1400, 1000);
        Integer[] a = new Integer[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(100);
        }
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
