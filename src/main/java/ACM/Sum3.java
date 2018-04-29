package ACM;

import java.util.*;

public class Sum3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            Set<List<Integer>> lists = new HashSet<>();

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    int search = Arrays.binarySearch(nums, j + 1, nums.length, 0 - nums[i] - nums[j]);
                    if (search > -1) {
                        List<Integer> list = new ArrayList<>(3);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[search]);
                        lists.add(list);
                    }
                }
            }
            return new ArrayList<>(lists);
        }
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        int low, high;
        for (int i = 0; i < nums.length - 1; i++) {
            low = i + 1;
            high = nums.length - 1;
            while (low < high) {
                if (nums[low] + nums[high] == target - nums[i]) return target;
                else if (nums[low] + nums[high] > target - nums[i]) {
                    while (low < high && nums[low] + nums[high] > target - nums[i]) high--;
                    if (Math.abs(nums[i] + nums[low] + nums[high + 1] - target) < Math.abs(closest - target))
                        closest = nums[i] + nums[low] + nums[high + 1];
                } else {
                    while (low < high && nums[low] + nums[high] < target - nums[i]) low++;
                    if (Math.abs(nums[i] + nums[low - 1] + nums[high] - target) < Math.abs(closest - target))
                        closest = nums[i] + nums[low - 1] + nums[high];
                }
            }
        }
        return closest;
    }
}
