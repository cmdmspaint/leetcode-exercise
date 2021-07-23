package hellozepp.array;

import suanfa.leetcode.a78subset;

import java.util.ArrayList;
import java.util.List;


/**
 * start在n上是全排列的问题,在i上是组合的问题 (排列是元素排列情况（站队，顺序可变）：123，132，组合是元素所有顺序的无序组合情况：1，12)
 * 求数组 中 所有数可能的结果集  （数组的值 不重复）组合
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
 * @REVIEW
 * 难度2星
 */
public class Solution78 {
    public List<List<Integer>> solution(int[] arr) {
        if (arr == null) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), arr, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] arr, int start) {
        // 首次会添加空集
        res.add(new ArrayList<>(list));
        for (int i = start; i < arr.length; i++) {
            list.add(arr[i]);
            helper(res, list, arr, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new a78subset().solution(new int[]{1, 2, 3}));
    }

}