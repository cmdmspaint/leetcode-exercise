package hellozepp.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 同no.46
 * 不同之处在与 数组数字可能相同
 *
 * 47全排列II
 * 题目简述：给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 输入：[1, 1, 2]
 *
 * 输出：[ [1,1,2], [1,2,1], [2,1,1]]
 *
 * 思路：DFS + 回溯 + 剪枝
 *
 * 在一定会产生重复结果集的地方剪枝。
 * 难度 2.5星
 *
 * @REVIEW
 */
public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // 去重第一步
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(list, new ArrayList(), nums, visited);

        return list;
    }


    private void dfs(List list, ArrayList subList, int[] nums, boolean[] visits) {

        if (subList.size() == nums.length) {
            System.out.println("add a subList:" + subList);
            list.add(new ArrayList<>(subList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //去重第二步
            if (visits[i]) {
                continue;
            }
            //去重第三步
            if (i > 0 && !visits[i - 1] && nums[i] == nums[i - 1]) {//visits[i - 1] 当前发现重复则不会再次进入dfs,因为i-1为刚删除的，且没有跳过
                System.out.println("visits[i - 1]:" + visits[i - 1] + ",i - 1:" + (i - 1) + ",nums[i - 1]:" + nums[i - 1] + ",nums[i]:" + nums[i]);
                continue; //关键一句 判断 i-1的是否相同 过滤掉重复的排序
            }

            visits[i] = true;
            subList.add(nums[i]);
            dfs(list, subList, nums, visits);
            System.out.println("i:" + i + ",remove:" + subList.get(subList.size() - 1));
            subList.remove(subList.size() - 1);
            visits[i] = false;
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution47().permuteUnique(new int[]{1, 2, 1}).toString());
//       [[1, 1, 2], [1, 2, 1], [2, 1, 1]]
    }
}