package hellozepp.dp;


/**
 * 数组为  价格变化
 *
 * 求在何时买入 卖出时 收益最大
 * 题意：给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。最多只允许完成一笔交易（即买入和卖出一支股票），
 * 设计一个算法来计算你所能获取的最大利润。注意不能在买入股票前卖出股票。
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * 难度2星
 *
 */
public class Solution121 {

    /**
     * 这道题目可以从后往前做也可以从前往后做。
     * ● 从前往后做的时候，就记录当前碰到过的最小值，把当前值与最小值相减看是 否得到更大的收益，可以则更新，直到最后输出;
     * ● 从后往前做的时候就是不断记录最大值，然后把最大值与当前值相减看是否得 到更大的收益，可以则更新，知道最后输出。
     * 动态规划解法；
     * dp[i]=max(max, prices[i] - buyPrice)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0; //可以不买
        int buyPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buyPrice) {
                max = Math.max(max, prices[i] - buyPrice);
            } else {
                buyPrice = prices[i];
            }
        }
        return max;
    }

    public int maxProfit1(int[] prices) {
        //解法一：蛮力法，找到每一天后续的最大值，比较确定最大利润
        //时间复杂度：O(n^2),空间复杂度：O(1)
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) { //如果第i天买入，依次判断它之后的每一天卖出的情况
                if (prices[j] - prices[i] > maxprofit) {
                    maxprofit = prices[j] - prices[i];
                }
            }
        }
        return maxprofit;
    }

}