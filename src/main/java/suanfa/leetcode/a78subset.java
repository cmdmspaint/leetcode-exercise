package suanfa.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * start在n上是全排列的问题, 在i上是组合的问题 (排列是元素排列情况：123，132，组合是元素所有顺序的无序组合情况：1，12)
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * **说明：**解集不能包含重复的子集。
 * <p>
 * For example,
 * If nums = [1,2,3]
 * output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 * 难度2星
 */
public class a78subset {
    public List<List<Integer>> solution(int[] arr) {
        if (arr == null) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), arr, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] arr, int start) {
        res.add(new ArrayList<>(list));
        System.out.println("list 加入到结果集" + JSON.toJSONString(list));
        for (int i = start; i < arr.length; i++) {
            list.add(arr[i]);
            System.out.println("list 添加一个元素" + arr[i] + ",list:" + JSON.toJSONString(list) + ",start:" + start + ",i:" + i);
            helper(res, list, arr, i + 1);
            // 回溯删除
            Integer remove = list.remove(list.size() - 1);
            System.out.println("回溯删除:" + remove + ",start:" + start + ",i:" + i);
        }
    }

    public static void main(String[] args) {
        System.out.println(new a78subset().solution(new int[]{1, 2, 3}));
    }

}
