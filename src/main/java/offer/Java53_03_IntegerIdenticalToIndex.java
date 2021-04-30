/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题53（三）：数组中数值和下标相等的元素
 * // 题目：假设一个单调递增的数组里的每个元素都是整数并且是唯一的。请编程实
 * // 现一个函数找出数组中任意一个数值等于其下标的元素。例如，在数组{-3, -1,
 * // 1, 3, 5}中，数字3和它的下标相等。
 */
package offer;

public class Java53_03_IntegerIdenticalToIndex {
	public int GetNumbersSameAsIndex(int[] array) {
		if (array == null || array.length <= 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int middle = left + ((right - left) / 2);
			if (array[middle] == middle) {
				return middle;
			}
			if (array[middle] > middle) {
				right = middle - 1;
			}
			else {
				left = middle + 1;
			}
		}
		return -1;
	}
}
