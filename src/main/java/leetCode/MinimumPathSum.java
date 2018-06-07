package leetCode;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] g = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        Solution solution = new Solution();
        System.out.println(solution.minPathSum(g));
    }
    static class Solution {
        public int minPathSum(int[][] grid) {
            //循环后每个位置的数字变为到当前位置累计的最低距离
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (i == 0 && j == 0) continue;//起点位置
                    if (i == 0) {
                        //i==0，也就是第一列，只能往右走，也就是当前位置的最短距离为左边一列的位置加当前位置的数字
                        grid[i][j] += grid[i][j - 1];
                        continue;
                    }
                    if (j == 0) {
                        //j==0，只能往下走
                        grid[i][j] += grid[i - 1][j];
                        continue;
                    }
                    //到当前位置的累计距离最短为当前位置的数字加上min{i方向上一个最短的，j方向上一个最短的}
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
            return grid[grid.length - 1][grid[0].length - 1];
        }
    }
}

