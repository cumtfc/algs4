package ACM;

public class MedianofTwoSortedArrays {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] n1 = {1, 2};
        int[] n2 = {3, 4};
        System.out.println(s.findMedianSortedArrays(n1, n2));
    }

    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int N = nums1.length + nums2.length;
            if (N % 2 == 0) {
                int m1 = N / 2 - 1;
                int m2 = N / 2;
                return solve(nums1, nums2, m1, m2);
            }
            int m2 = N / 2;
            return solve(nums1, nums2, null, m2);
        }

        private static double solve(int[] nums1, int[] nums2, Integer m1, Integer m2) {
            int[] all = new int[nums1.length + nums2.length];
            int index1 = 0, index2 = 0;
            for (int i = 0; i <= m2; i++) {
                if (index1 == nums1.length) all[i] = nums2[index2++];
                else if (index2 == nums2.length) all[i] = nums1[index1++];
                else if (nums1[index1] > nums2[index2]) all[i] = nums2[index2++];
                else all[i] = nums1[index1++];
            }
            if (m1 != null) {
                return (double) (all[m1] + all[m2]) / 2;
            } else {
                return (double) all[m2];
            }
        }
    }
}
