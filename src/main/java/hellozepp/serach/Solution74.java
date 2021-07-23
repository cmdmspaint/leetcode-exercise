package hellozepp.serach;

/**
 * 杨氏矩阵
 * 给定二维 m * n 矩阵 matrix，满足一定特性: 1. 每行从左到右递增 2. 每列从上到下 递增 给定目标元素 num，判断 num 是否在矩阵中存在
 * 注意：满足上面两个条件则平铺展开是整体有序的，可以使用二维矩阵的二分查找
 * <p>
 * 矩阵数字 从小到大排序
 * <p>
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true
 * [1,   3,  5,  7],[10, 11, 16, 20],[23, 30, 34, 50]
 * 二维矩阵跟一维矩阵的关系：[mid/n][mid%n]  11/2=5  5/4|5%4 = 1|1(11这个位置)
 * 难度2星
 */
public class Solution74 {

    /**
     * 矩阵二分搜索
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int l = 0, r = matrix.length * matrix[0].length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int i = 0, j = matrix[0].length - 1;
        while (i <= j) {//暴力解
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(new Solution74().searchMatrix1(mat, 3));
    }
}