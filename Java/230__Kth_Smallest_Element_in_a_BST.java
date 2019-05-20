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

    List<Integer> result;

    public int kthSmallest(TreeNode root, int k) {
        result = new ArrayList<>();
        helper(root);
        return result.get(k - 1);
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        result.add(root.val);
        helper(root.right);
    }
}
