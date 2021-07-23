package suanfa.leetcode;

/**
 * 88. 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 示例:
 *
 * 输入: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class a88 {
    public static int[] solition(int[] a, int[] b) {
        if (a == null || b == null) {
            return null;
        }
        int index = 0;
        int index1 = 0;
        int index2 = 0;
        int[] arr = new int[a.length + b.length];
        while (index1 < a.length && index2 < b.length) {
            if (a[index1] == b[index2]) {
                arr[index++] = a[index1++];
            } else if (a[index1] < b[index2]) {
                arr[index++] = a[index1++];
            } else {
                arr[index++] = b[index2++];
            }
        }
        while (index1 != a.length) {
            arr[index++] = a[index1++];
        }
        while (index2 != b.length) {
            arr[index++] = b[index2++];
        }
        return arr;
    }

    public static void main(String[] args) {

    }
}
