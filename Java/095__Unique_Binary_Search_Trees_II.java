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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)  return new LinkedList<TreeNode>();
        return helper(1, n);

    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> all_trees = new ArrayList<>();
        if (start > end) {
            all_trees.add(null);
            return all_trees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left_trees = helper(start, i - 1);
            List<TreeNode> right_trees = helper(i + 1, end);
            for (TreeNode left : left_trees) {
                for (TreeNode right : right_trees) {
                  TreeNode current_tree = new TreeNode(i);
                  current_tree.left = left;
                  current_tree.right = right;
                  all_trees.add(current_tree);
                }
            }
        }
        return all_trees;
    }
}
