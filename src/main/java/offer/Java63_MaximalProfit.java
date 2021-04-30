/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题63：股票的最大利润
 * // 题目：假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖交易该股
 * // 票可能获得的利润是多少？例如一只股票在某些时间节点的价格为{9, 11, 8, 5,
 * // 7, 12, 16, 14}。如果我们能在价格为5的时候买入并在价格为16时卖出，则能
 * // 收获最大的利润11。
 */
package offer;

public class Java63_MaximalProfit {
	public int maxProfit(int[] array) {
		if (array == null || array.length < 2) {
			return 0;
		}
		int min = array[0];
		int maxDiff = array[1] - min;
		for (int i = 2; i < array.length; i++) {
			if (array[i - 1] < min) {
				min = array[i - 1];
			}
			int currentDiff = array[i] - min;
			if (currentDiff > maxDiff) {
				maxDiff = currentDiff;
			}
		}
		return maxDiff;
	}
}
