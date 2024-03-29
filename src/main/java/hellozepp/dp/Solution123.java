package hellozepp.dp;

/**
 * @Author: zhanglin
 * @Date: 2021/5/19
 * @Time: 3:54 PM
 *
 * 买卖股票的最佳时机 III
 * 同：121 122
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2：
 *
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3：
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
 * 示例 4：
 *
 * 输入：prices = [1]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 105
 *
 */
public class Solution123 {

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int[] profitList = new int[len];
        profitList[0] = 0;
        int maxProfit = 0, buyPrice = prices[0];
        for (int i = 1; i < len; ++i) {
            if (prices[i] >= buyPrice) {
                maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
            } else {
                buyPrice = prices[i];
            }
            profitList[i] = maxProfit;
        }
        maxProfit = 0;
        int sellPrice = Integer.MIN_VALUE, res = 0;
        for (int i = len - 1; i >= 0; --i) {
            if (prices[i] <= sellPrice) {
                maxProfit = Math.max(maxProfit, sellPrice - prices[i]);
            } else {
                sellPrice = prices[i];
            }
            res = Math.max(res, profitList[i] + maxProfit);
        }
        return res;
    }

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int max1 = 0;
        int max2 = 0;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            int min = prices[0];
            for (int j = 0; j < i; j++) {
                max1 = Math.max(prices[j] - min, max1);
                min = Math.min(prices[j], min);
            }
            min = prices[i];
            for (int j = i; j < prices.length; j++) {
                max2 = Math.max(prices[j] - min, max2);
                min = Math.min(prices[j], min);
            }
            if (max1 + max2 > max) {
                max = max1 + max2;
            }
            max1 = max2 = 0;
        }
        return max;
    }

    /**
     * 大神解法
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        /**
         对于任意一天考虑四个变量:
         fstBuy: 在该天第一次买入股票可获得的最大收益
         fstSell: 在该天第一次卖出股票可获得的最大收益
         secBuy: 在该天第二次买入股票可获得的最大收益
         secSell: 在该天第二次卖出股票可获得的最大收益
         分别对四个变量进行相应的更新, 最后secSell就是最大
         收益值(secSell >= fstSell)
         **/
        int fstBuy = Integer.MIN_VALUE, fstSell = 0;
        int secBuy = Integer.MIN_VALUE, secSell = 0;
        for (int p : prices) {
            fstBuy = Math.max(fstBuy, -p);
            fstSell = Math.max(fstSell, fstBuy + p);
            secBuy = Math.max(secBuy, fstSell - p);
            secSell = Math.max(secSell, secBuy + p);
        }
        return secSell;
    }
}
