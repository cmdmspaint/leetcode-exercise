package hellozepp.dp;


/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 难度2星
 */
public class Solution53 {
    class Solution {
        public int maxSubArray(int[] nums) {
            //首先求出以i为结尾的最大字段和，然后用后面的数据判断前面的数是否大于0，是就将其加上
            int length = nums.length;
            if (length == 1) {
                return nums[0];
            }
            int[] dp = new int[length];
            dp[0] = nums[0];
            int max = dp[0];
            for (int i = 1; i < length; i++) {
                if (dp[i - 1] < 0) {
                    dp[i] = nums[i];
                } else {
                    dp[i] = dp[i - 1] + nums[i];
                }
                max = Math.max(max, dp[i]);

            }
            return max;
        }
    }

    /**
     * 动态规划求解
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            if (sum < 0) { //前面子串累加小于0则忽略
                sum = num;
            } else {
                sum += num;
            }
            max = Math.max(sum, max); //维护一个全局最大，同时可以求全是负数的情况
        }

        return max;
    }
}