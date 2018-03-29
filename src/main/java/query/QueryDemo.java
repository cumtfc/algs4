package query;

import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.BinarySearchST;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.Transaction;

public class QueryDemo {
    public static void main(String[] args) {
        ST<String, Integer> st = new ST<>();
        BinarySearchST<String, Integer> searchST = new BinarySearchST<>();
        Integer[] a = new Integer[20];
        Integer k = 0;
        for (int i = 0; i < a.length; i++) {
            k = k + 10;
            a[i] = k;
        }


    }

    public static int query(Integer[] a, Integer key) {
        int lo = 0, li = a.length - 1;
        while (lo <= li) {
            int mid = (lo + li) / 2;
            int cmp = key - a[mid];
            if (cmp < 0) {
                li = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

}
