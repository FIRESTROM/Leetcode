class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int level = triangle.size() - 2; level >= 0; level--) {
            List<Integer> cur_level = triangle.get(level);
            List<Integer> prev_level = triangle.get(level + 1);
            for (int i = 0; i < cur_level.size(); i++) {
                int new_val = cur_level.get(i) + Math.min(prev_level.get(i), prev_level.get(i + 1));
                cur_level.set(i, new_val);
            }
        }
        return triangle.get(0).get(0);
    }
}
