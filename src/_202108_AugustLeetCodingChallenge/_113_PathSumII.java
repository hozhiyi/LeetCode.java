package _202108_AugustLeetCodingChallenge;

import java.util.ArrayList;
import java.util.List;

public class _113_PathSumII {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), result);
        return result;
    }

    public static void dfs(TreeNode root, int sum, List<Integer> list,
                           List<List<Integer>> result) {

        if (root == null)
            return;

        list.add(new Integer(root.val));

        if (root.left == null && root.right == null) {
            if (sum == root.val)
                result.add(new ArrayList(list));

            list.remove(list.size() - 1);
            return;
        }

        dfs(root.left, sum - root.val, list, result);
        dfs(root.right, sum - root.val, list, result);

        list.remove(list.size() - 1);
    }
}
// https://leetcode-cn.com/problems/path-sum-ii/solution/3chong-fang-shi-jie-jue-2chong-ji-bai-liao-100de-2/
