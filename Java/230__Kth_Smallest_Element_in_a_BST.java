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

// Another Solution
class Solution {
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        kthSmallest(root, k, 0);
        return result;
    }

    private int kthSmallest(TreeNode root, int k, int count){
        if (root == null)
            return count;

        int left_cnt = kthSmallest(root.left, k, count);
        if (left_cnt + 1 == k)
            result = root.val;
        return kthSmallest(root.right, k, left_cnt + 1); 
    }
}
