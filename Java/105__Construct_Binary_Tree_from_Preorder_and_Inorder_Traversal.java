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
    int preorder_index = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(0, preorder.length);
    }

    private TreeNode helper(int left, int right) {
        if (left == right) {
            return null;
        }
        int root_val = preorder[preorder_index];
        TreeNode root = new TreeNode(root_val);
        preorder_index++;
        int index = map.get(root_val);
        root.left = helper(left, index);
        root.right = helper(index + 1, right);
        return root;
    }
}
