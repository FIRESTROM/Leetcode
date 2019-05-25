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
    public int minCameraCover(TreeNode root) {
        if(root == null ) return 0;
        int val = helper(root);
        // Handle the root NOT being made visible by a camera
        // in which case we have to manually do that.
        return val + (root.val == 0 ? 1 : 0);
    }

    public int helper(TreeNode root){
        if (root == null)
            return 0;

        int leftCameras = helper(root.left);
        int rightCameras = helper(root.right);

		// if at least one child is NOT null and NOT visible(2) then we must mark this node as camera.
        if ((root.left != null && root.left.val == 0) || (root.right != null && root.right.val == 0))
            root.val = 1;
		// Check if one of the children are cameras in order to mark the current node as visible(2)
		else if ((root.left != null && root.left.val == 1) || (root.right != null && root.right.val == 1))
            root.val = 2;

        return leftCameras + rightCameras + (root.val == 1 ? 1 : 0);
    }
}
