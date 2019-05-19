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
    public int countNodes(TreeNode root) {
        int result = 0;
        while (root != null) {
            int left_h = height(root.left), right_h = height(root.right);
            if (left_h == right_h) {
                result += Math.pow(2, left_h);
                root = root.right;
            } else {
                result += Math.pow(2, right_h);
                root = root.left;
            }
        }
        return result;
    }

    private int height(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }
}
