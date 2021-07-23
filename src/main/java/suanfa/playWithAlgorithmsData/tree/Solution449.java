package suanfa.playWithAlgorithmsData.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zhanglin
 * @Date: 2021/7/20
 * @Time: 1:24 AM
 *
 * 序列化和反序列化二叉搜索树
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 *
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 *
 * 编码的字符串应尽可能紧凑。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [2,1,3]
 * 输出：[2,1,3]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 */
public class Solution449 {
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder ans = new StringBuilder("");
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                ans.append("N ");
                continue;
            } else {
                ans.append(cur.val).append(" ");
            }
            queue.add(cur.left);
            queue.add(cur.right);
        }
        return ans.toString().trim();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] ss = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        int val = Integer.parseInt(ss[0]);
        TreeNode root = new TreeNode(val);
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (ss[i].equals("N")) {
                i++;
            } else {
                TreeNode left = new TreeNode(Integer.parseInt(ss[i]));
                i++;
                node.left = left;
                queue.add(left);
            }
            if (ss[i].equals("N")) {
                i++;
            } else {
                TreeNode right = new TreeNode(Integer.parseInt(ss[i]));
                i++;
                node.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}