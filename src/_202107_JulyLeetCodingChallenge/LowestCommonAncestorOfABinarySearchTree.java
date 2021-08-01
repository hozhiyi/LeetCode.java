package _202107_JulyLeetCodingChallenge;

/*
LeetCode

Lowest Common Ancestor of a Binary Search Tree

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two
given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is
defined between two nodes p and q as the lowest node in T that has both p and q
as descendants (where we allow a node to be a descendant of itself).”

Example 1:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of
itself according to the LCA definition.

Example 3:
Input: root = [2,1], p = 2, q = 1
Output: 2

Constraints:
1. The number of nodes in the tree is in the range [2, 105].
2. -109 <= Node.val <= 109
3. All Node.val are unique.
4. p != q
5. p and q will exist in the BST.

 */
public class LowestCommonAncestorOfABinarySearchTree {

    /*
    Key point of solution: LCA is the node <= p && >= q
    If current root is > q, recursively call the function with root.right
    If current root is < p, recursively call the function with root.left
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Ensure that p < q
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }

        // Looking for LCA
        if (root.val >= p.val && root.val <= q.val) {
            return root;
        } else if (root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

