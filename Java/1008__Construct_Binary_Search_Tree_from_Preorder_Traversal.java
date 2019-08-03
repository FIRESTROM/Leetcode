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

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++)
            root = helper(root, preorder[i]);
        return root;
    }

    private TreeNode helper(TreeNode root, int key) {
        if (key < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(key);
                return root;
            } else
                helper(root.left, key);
        } else {
            if (root.right == null) {
                root.right = new TreeNode(key);
                return root;
            } else
                helper(root.right, key);
        }
        return root;
    }
}
