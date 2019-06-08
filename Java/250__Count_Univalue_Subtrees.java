public class Solution {
    int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return count;
    }

    private boolean helper(TreeNode node) {
        if (node.left == null && node.right == null) {
            count++;
            return true;
        }
        boolean check = true;
        if (node.left != null)
            check = helper(node.left) && check && node.left.val == node.val;
        if (node.right != null)
            check = helper(node.right) && check && node.right.val == node.val;
        if (!check)
            return false;
        count++;
        return true;
    }
}
