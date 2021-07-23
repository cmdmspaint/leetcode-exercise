package suanfa.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * {1, 2, 3}
 * 全排列
 * [1, 2, 3]
 * [1, 3, 2]
 * [2, 1, 3]
 * [2, 3, 1]
 * [3, 1, 2]
 * [3, 2, 1]
 */
public class a46 {


    List<List<Integer>> res;
    private boolean[] isUsed;

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = (new a46()).permute(nums);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }

    /**
     * dfs 方式最优解
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int... nums) {

        List<List<Integer>> list = new ArrayList<>();
        dfs(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void dfs(List<List<Integer>> list, List<Integer> subList, int[] nums, int start) {

        if (start == nums.length) {
            list.add(new ArrayList<>(subList));
            System.out.println("sub list add to list:" + subList.toString());
            return;
        }
        for (int i = 0; i <= start; i++) {
            subList.add(i, nums[start]); //相当于队列
            System.out.println("add to subList[" + i + "]:" + nums[start] + ",start:" + start + ",current subList:" + subList);
            dfs(list, subList, nums, start + 1);
            subList.remove(i);
        }

    }

    //----------------------------------------
    private List<List<Integer>> solution(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        isUsed = new boolean[nums.length];
        LinkedList<Integer> p = new LinkedList<>();
        permutation(nums, 0, p);
        return res;

    }

    private void permutation(int[] nums, int k, LinkedList<Integer> p) {//全排列
        if (k == nums.length) {
            res.add((List<Integer>) p.clone());
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                p.add(nums[i]);
                permutation(nums, k + 1, p);
                isUsed[i] = false;
                p.removeLast();
            }
        }
    }


}
