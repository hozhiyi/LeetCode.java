package _202107_JulyLeetCodingChallenge;

public class _814_BinaryTreePruning {

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

    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    public boolean containsOne(TreeNode node) {
        if (node == null) return false;
        boolean left = containsOne(node.left);
        boolean right = containsOne(node.right);
        if (!left) node.left = null;
        if (!right) node.right = null;
        return node.val == 1 || right || left;
    }
}
