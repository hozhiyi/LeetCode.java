package _202108_AugustLeetCodingChallenge;

public class _1339_MaximumProductofSplittedBinaryTree {
    double ans = Double.MIN_VALUE;
    double allSum;
    double nodeSum;

    public int maxProduct(TreeNode root) {
        allSum = sum(root);
        dfs(root);
        return (int) (ans % (int) (1e9 + 7));
    }

    public double sum(TreeNode node) {
        if (node == null) return 0;
        return node.val + sum(node.left) + sum(node.right);
    }

    public double dfs(TreeNode node) {
        if (node == null) return 0;
        nodeSum = node.val + dfs(node.left) + dfs(node.right);
        ans = Math.max(ans, (allSum - nodeSum) * nodeSum);
        return nodeSum;
    }

    public class TreeNode {
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

}
