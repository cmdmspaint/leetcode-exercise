package hellozepp.array;


import java.util.HashMap;
import java.util.Map;

/**
 * 从数组中找到 a+b = target
 * <p>
 * 难度 1.5星
 */

public class Solution1 {
    /**
     * 空间最优解，考察快排 nlogn
     * @param nums
     * @param target
     * @return
     */
    boolean pairInSortedArray(int nums[], int target) {
        int length = nums.length;
        QuickSort.sort(nums, 0, length - 1);
        if (nums[0] >= target) {
            return false;
        }
        int l = 0;
        int r = length - 1;
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                return true;
            } else if (nums[l] + nums[r] <= target) {
                ++l;
            } else {
                --r;
            }
        }
        return false;
    }

    static class QuickSort {


        public static int partition(int array[], int low, int high) {
            int tmp = array[low];
            while (low < high) {
                while (low < high && array[high] >= tmp) {
                    --high;
                }
                if (low < high) {
                    array[low++] = array[high];
                }

                while (low < high && array[low] <= tmp) {
                    ++low;
                }
                if (low < high) {
                    array[high--] = array[low];
                }
            }
            array[low] = tmp;
            return low;
        }

        public static void sort(int[] array, int low, int high) {
            if (low < high) {
                int pivot = partition(array, low, high);
                sort(array, low, pivot - 1);
                sort(array, pivot + 1, high);
            }
        }
    }

    /**
     * 哈希表解法，时间最优解
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] rst = new int[2];

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {
                rst[1] = i;
                rst[0] = map.get(target - nums[i]);
                return rst;
            }
            map.put(nums[i], i);
        }

        return rst;
    }

    /**
     * 暴力解法
     * @param arr
     * @param length
     * @param target
     * @return
     */
    private boolean pairInArray(int[] arr, int length, int target) {
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }
        return false;

    }
}