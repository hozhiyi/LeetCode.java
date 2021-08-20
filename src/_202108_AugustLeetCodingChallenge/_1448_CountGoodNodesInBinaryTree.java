package _202108_AugustLeetCodingChallenge;

public class _1448_CountGoodNodesInBinaryTree {

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

    class Solution {
        private int res = 0;

        public int goodNodes(TreeNode root) {
            helper(root, Integer.MIN_VALUE);
            return res;
        }

        public void helper(TreeNode node, int max) {
            if (node == null) {
                return;
            }
            if (node.val >= max) {
                res++;
                max = node.val;
            }
            helper(node.left, max);
            helper(node.right, max);
        }
    }
}
