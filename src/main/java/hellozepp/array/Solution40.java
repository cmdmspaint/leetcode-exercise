package hellozepp.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 题目跟 mo.39 一样 不同条件是
 * 数组有重复元素，且数组里的是数字只能使用一次
 * 难度2.5星
 *
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 */
public class Solution40 {
    public List<List<Integer>> combinationSum21(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // 去重的第一步
        Arrays.sort(candidates);
        dsf(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void dsf(int[] candidates, int target, List<List<Integer>> res, List<Integer> subList, int start) {
        if (target > 0) {
            for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
                // 去重的第二步
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                subList.add(candidates[i]);
                dsf(candidates, target - candidates[i], res, subList, i + 1); //不同点 因为只能用一次所以 ++i
                subList.remove(subList.size() - 1);
            }
        } else if (target == 0) {
            res.add(new ArrayList<>(subList));
        }
    }
//————————————————

    /**
     * 算法跟 no.39 基本一样
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(list, new ArrayList(), target, candidates, 0);

        return list;

    }

    private void dfs(List list, ArrayList subList, int target, int[] candidates, int start) {

        if (target > 0) {

            for (int i = start; i < candidates.length; ) {

                subList.add(candidates[i]);
                dfs(list, subList, target - candidates[i], candidates, ++i); //不同点 因为只能用一次所以 ++i
                subList.remove(subList.size() - 1);
            }


        }
        if (target == 0) {
            if (!list.contains(subList)) {  //不同点
                list.add(new ArrayList<>(subList));
                return;
            }
            System.out.println("find target repeat sublist:" + subList);
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution40().combinationSum21(new int[]{2, 3, 6, 7, 7}, 7));
        System.out.println(new Solution40().combinationSum21(new int[]{2, 5, 2, 1, 2}, 5));
    }
}