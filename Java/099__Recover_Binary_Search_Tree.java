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

    TreeNode val1 = null, val2 = null;
    TreeNode min = null;

    public void recoverTree(TreeNode root) {
        walk(root);
        int tmp = val1.val;
        val1.val = val2.val;
        val2.val = tmp;
    }

    private void walk(TreeNode curr){
        if (curr == null) return;
        walk(curr.left);
        if (min != null && curr.val < min.val) {
            if (val1 == null) {
                val1 = min;
                val2 = curr;
            } else
                val2 = curr; //override previous val2 since there are only two misplaced elems
        }
        min = curr;
        walk(curr.right);
    }
}
