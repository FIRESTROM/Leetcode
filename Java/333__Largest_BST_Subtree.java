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
    public int largestBSTSubtree(TreeNode root) {
        return helper(root)[3];
    }

    /*
     * Emit [min, max, isBST, size]
     *
     * min: min value in current BST
     * max: max value in current BST
     * isBST: 1 -> current subtree is a BST
     *        0 -> current subtree is not a BST
     * size: largest BST size
     */
    private int[] helper(TreeNode n) {
        int[] result = {Integer.MAX_VALUE, Integer.MIN_VALUE, 1, 0};
        if (n == null) return result;
        int[] left = helper(n.left);
        int[] right = helper(n.right);
        // current tree is a BST iff root value is larger than max value in left subtree and
        // smaller than min value in right subtree, and both left/right subtrees are BST
        if (n.val > left[1] && n.val < right[0] && left[2] == 1 && right[2] == 1) {
            result[0] = Math.min(left[0], n.val); // update min value
            result[1] = Math.max(right[1], n.val); // update max value
            result[3] = 1 + left[3] + right[3]; // update largest BST size: left BST + right BST + current root
        } else {
            result[2] = 0; // current tree is not a BST
            result[3] = Math.max(left[3], right[3]); // just bypass largest BST size from subtrees
        }
        return result;
    }
}
