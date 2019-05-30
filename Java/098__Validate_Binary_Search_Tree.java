/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return check(root, null, null);
    }

    private boolean check(TreeNode root, Integer lowerbound, Integer upperbound) {
        if (root == null) return true;
        if (lowerbound != null && lowerbound >= root.val) return false;
        if (upperbound != null && upperbound <= root.val) return false;
        if (!check(root.left, lowerbound, root.val)) return false;
        if (!check(root.right, root.val, upperbound)) return false;
        return true;
    }
}
