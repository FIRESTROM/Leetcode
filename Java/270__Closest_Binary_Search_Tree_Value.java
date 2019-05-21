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
    public int closestValue(TreeNode root, double target) {
        int min_val = root.val, max_val = root.val;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val < target) {
                min_val = curr.val;
                curr = curr.right;
            }
            else {
                max_val = curr.val;
                curr = curr.left;
            }
        }
        return Math.abs(target - min_val) < Math.abs(max_val - target) ? min_val : max_val;

    }
}
