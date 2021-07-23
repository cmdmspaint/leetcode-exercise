package hellozepp.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 从数组中找到 相加结果为 target的数
 * 数组的数可以使用多次
 * <p>
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * [
 * [7],
 * [2, 2, 3]
 * ]
 * 2367
 * /     \             \           \
 * 2      3（可用367）   6 （可用67） 7
 * /   \
 * 22   23（可用367，2前面用过了）
 * /  \
 * 222 223(ok)
 * /
 * 2222(X return)
 * <p>
 * 难度2.5星
 */
public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start) {
        if (target > 0) {
            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                cur.add(candidates[i]);
                dfs(result, cur, candidates, target - candidates[i], i);
                cur.remove(cur.size() - 1);
            }//for
        } else if (target == 0) {
            result.add(new ArrayList<>(cur));
        }//else if
    }

    public static void main(String[] args) {
        System.out.println(new Solution39().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

}