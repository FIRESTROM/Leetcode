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

    Map<Integer, Map<Integer, List<Integer>>> map;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        helper(root, 0, 0);
        for (int row : map.keySet()) {
            Map<Integer, List<Integer>> innerMap = map.get(row);
            List<Integer> innerList = new ArrayList<>();
            for (int col : innerMap.keySet()) {
                List<Integer> list = innerMap.get(col);
                Collections.sort(list);
                innerList.addAll(list);
            }
            result.add(innerList);
        }
        return result;
    }

    private void helper(TreeNode root, int x, int y) {
        if (root == null) return;
        Map<Integer, List<Integer>> inner = map.get(x);
        if (inner == null) inner = new TreeMap<>(Collections.reverseOrder());
        List<Integer> innerList = inner.getOrDefault(y, new ArrayList<>());
        innerList.add(root.val);
        inner.put(y, innerList);
        map.put(x, inner);
        helper(root.left, x - 1, y - 1);
        helper(root.right, x + 1, y - 1);
    }
}
