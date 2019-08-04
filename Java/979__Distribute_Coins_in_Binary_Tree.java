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

    int result;

    public int distributeCoins(TreeNode root) {
        result = 0;
        dfs(root);
        return result;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int L = dfs(node.left);
        int R = dfs(node.right);
        result += Math.abs(L) + Math.abs(R);
        return node.val + L + R - 1;
    }
}
