package hellozepp.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 跟 No.78 一样
 * <p>
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 区别是 包含重复的值
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.The solution set must not contain duplicate subsets.For example,If S = [1,2,2], a solution is:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * 组合问题,不能插入重复值,做法排序后当前数和前面的数相等则跳过前面递归,start在i上,remove最后
 */
public class Solution90 {


    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List list = new ArrayList<>();

        Arrays.sort(nums);

        dfs(list, new ArrayList(), nums, 0);

        return list;
    }

    private void dfs(List list, ArrayList subList, int[] nums, int start) {

        list.add(new ArrayList<>(subList));


        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            subList.add(nums[i]);
            dfs(list, subList, nums, i + 1);
            subList.remove(subList.size() - 1);

        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution90().subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println(new Solution90().subsetsWithDup(new int[]{2, 1, 2}));
//        [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
    }
}
