package hellozepp.array;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和 III
 * 题目：
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * Input: k = 3, n = 9
 * Output:
 * [[1,2,6], [1,3,5], [2,3,4]]
 * 思路解析：
 *
 * 回溯的解法在于递归，递归要有出口条件if (sum == 0 &&  k == subList.size())，当满足条件则把集合添加到结果列表中。
 * 回溯的就像人生选择，要么选择做这件事情list.add(i); 要么选择不做这件事情list.remove(list.size() - 1);。
 * 记得要有行动，否则就是空谈，执行递归dfs(list, subList, k, sum - i, start + 1);
 * 难度 2星
 */
public class Solution216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(list, new ArrayList<>(), k, n, 1);
        return list;

    }

    private void dfs(List<List<Integer>> list, List<Integer> subList, int k, int sum, int start) {
        if (sum == 0 && k == subList.size()) {
            list.add(new ArrayList<>(subList));
            return;
        }
        if (sum < 0 || subList.size() >= k) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            subList.add(i);
            dfs(list, subList, k, sum - i, i + 1);
            subList.remove(subList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new Solution216().combinationSum3(3, 9)));
        System.out.println(JSON.toJSONString(new Solution216().combinationSum3(3, 100)));
    }

}