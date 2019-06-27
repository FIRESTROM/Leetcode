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

    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        helper(list, root, sum);
        return result;
    }

    private void helper(List<Integer> list, TreeNode root, int sum) {
        if (root == null) return;
        sum = sum - root.val;
        list.add(root.val);
        if (root.left == null && root.right == null && sum == 0)
            result.add(new ArrayList<Integer>(list));
        if (root.left != null) {
            helper(list, root.left, sum);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            helper(list, root.right, sum);
            list.remove(list.size() - 1);
        }
    }
}
