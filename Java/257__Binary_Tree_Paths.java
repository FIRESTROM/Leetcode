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

    List<String> result;

    public List<String> binaryTreePaths(TreeNode root) {
        result = new ArrayList<>();
        helper("", root);
        return result;
    }

    private void helper(String cur_str, TreeNode root) {
        if (root != null) {
            cur_str += Integer.toString(root.val);
            if (root.left == null && root.right == null)
                result.add(cur_str);
            else {
                cur_str += "->";
                helper(cur_str, root.left);
                helper(cur_str, root.right);
            }
        }
    }
}
