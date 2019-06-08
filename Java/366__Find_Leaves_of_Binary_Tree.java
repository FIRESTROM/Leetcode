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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int depth = dfs(root, map);
        for (int i = 0; i <= depth; i++)
            list.add(map.get(i));
        return list;
    }

    private int dfs(TreeNode node, Map<Integer, List<Integer>> result) {
        if (node == null) return -1;
        if (node.left == null && node.right == null) {
            if (!result.containsKey(0)) {
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                result.put(0, list);
            } else
                result.get(0).add(node.val);
            return 0;
        }
        int depth = Math.max(dfs(node.left, result), dfs(node.right, result)) + 1;
        if (!result.containsKey(depth)) {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            result.put(depth, list);
        } else
            result.get(depth).add(node.val);
        return depth;
    }

}
