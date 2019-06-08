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
    TreeNode target;
    int K;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        result = new LinkedList<>();
        this.target = target;
        this.K = K;
        dfs(root);
        return result;
    }

    private int dfs(TreeNode node) {
        if (node == null) return -1;
        else if (node == target) {
            subtree_add(node, 0);
            return 1;
        } else {
            int dist_l = dfs(node.left), dist_r = dfs(node.right);
            if (dist_l != -1) {
                if (dist_l == K)
                    result.add(node.val);
                subtree_add(node.right, dist_l + 1);
                return dist_l + 1;
            } else if (dist_r != -1) {
                if (dist_r == K)
                    result.add(node.val);
                subtree_add(node.left, dist_r + 1);
                return dist_r + 1;
            } else {
                return -1;
            }
        }
    }

    private void subtree_add(TreeNode node, int dist) {
        if (node == null) return;
        if (dist == K)
            result.add(node.val);
        else {
            subtree_add(node.left, dist + 1);
            subtree_add(node.right, dist + 1);
        }
    }
}
