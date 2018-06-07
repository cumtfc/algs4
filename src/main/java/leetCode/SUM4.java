package leetCode;

import java.util.*;

public class SUM4 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println();
    }

    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            Set<List<Integer>> listSet = new HashSet<>();
            for (int i = 0; i < nums.length - 3; i++) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    for (int k = j + 1, l = nums.length - 1; k < l; ) {
                        int sum = nums[i] + nums[j] + nums[k] + nums[l];

                        if (sum == target) {
                            listSet.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                            k++;
                            l--;
                        } else if (sum > target) {
                            l--;
                        } else {
                            k++;
                        }
                    }
                }
            }
            return new ArrayList<>(listSet);
        }
    }
}

