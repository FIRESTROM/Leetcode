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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode, Integer> level_map = new HashMap<>();
        queue.add(root);
        level_map.put(root, 0);
        int min = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int level = level_map.get(node);
            if (!map.containsKey(level)) {
                map.put(level, new ArrayList<>());
            }
            map.get(level).add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                level_map.put(node.left, level - 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                level_map.put(node.right, level + 1);
            }
            min = Math.min(min, level);
        }
        while (map.containsKey(min)) {
            result.add(map.get(min++));
        }
        return result;
    }

}
