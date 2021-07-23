package hellozepp.dp;


/*
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *
 * 方向只能 down或 right
 *
 * 解法：如果是左上角为初始值，第一行先看同行（只能是左边过来的），第一列先看同列（第一列只能是上面过来的），非首行首列看上面和左面的值取最小
 *  dp[i][j]=min(dp[i-1][j], dp[i][j-1])+grid[i][j]
 *
 * 难度2星
 *
 * FIXME
 *
 */
public class Solution64 {

    /**
     * f(xy)= min(f(x-1,y),f(x,y-1))+a(x,y)
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int m = grid.length;// row
        int n = grid[0].length; // column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    grid[i][j] = grid[i][j];
                } else if (i == 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else {
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
                }

            }
        }

        return grid[m - 1][n - 1];


    }
}