package hellozepp.serach;

/**
 * 假设有一个排序的按未知的旋转轴旋转的数组
 * (比如，0 1 2 4 5 6 7 可能成为4 5 6 7 0 1 2)
 * 给定一个目标值进行搜索，
 * 如果在数组中找到目标值返回数组中的索引位置，否则返回-1。
 * | 大 | 小 |
 *        |
 * 在小的区间但比end大,则end左移出来,到大的区间
 *
 * 元素不重复
 * <p>
 * 难度3星
 */
public class Solution33 {

    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[start] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[start]) // 注意，这里满足条件会砍掉一组旋转的数组
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}