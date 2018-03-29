package string;

import edu.princeton.cs.algs4.KMP;

public class StringSearch {
    public static void main(String[] args) {
//        search("ap", "ab");
        KMP kmp = new KMP("ABABC");
        kmp.search("ABACBAAACBACAGBACBABABC");
    }

    public static int search(String pat,String txt) {
        int j, M = pat.length();
        int i, N = txt.length();
        for (j = 0,i=0; j <M && i<N ; i++) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
            } else {
                i -= j;
                j = 0;
            }
        }
        if (j == M) {
            return i - M;
        }
        return N;
    }
}
