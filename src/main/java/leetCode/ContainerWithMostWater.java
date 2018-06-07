package leetCode;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {0,2};
        System.out.println(solution.maxArea(ints));
    }

    static class Solution {
        int hl = 0;
        int hr = 0;
        public int maxArea(int[] height) {
            int maxArea = 0;
            int i = 0;
            int j = height.length - 1;
            while (j > i) {
                if (height[i] >= hl || height[j] >= hr) {
                    int area = Math.min(height[i], height[j]) * (j - i);
                    maxArea = Math.max(area, maxArea);
                    hl = height[i];
                    hr = height[j];
                }
                if (height[i] <=height[j]) {
                    i++;
                } else {
                    j--;
                }

            }
            return maxArea;
        }
    }

    static class Solution2 {
        public int maxArea(int[] height) {
            int[][] dp = new int[height.length + 1][height.length + 1];
            for (int i = 1; i < height.length; i++) {
                for (int j = 2; j < height.length; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + Math.min(height[j - 1], height[i - 1]));
                }
            }
            return dp[height.length][height.length];
        }
    }
}
