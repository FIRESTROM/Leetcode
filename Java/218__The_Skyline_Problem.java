class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> heights = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int last_height = 0;
        for (int[] building : buildings) {
            heights.add(Arrays.asList(building[0], -building[2]));
            heights.add(Arrays.asList(building[1], building[2]));
        }
        Collections.sort(heights, (a, b) -> (a.get(0).intValue() != b.get(0).intValue() ? a.get(0) - b.get(0) : a.get(1) - b.get(1)));
        map.put(0, 1);
        for (List<Integer> cur_height : heights) {
            int val = cur_height.get(1);
            if (val < 0)
                map.put(-val, map.getOrDefault(-val, 0) + 1);
            else if (map.getOrDefault(val, 0) > 1)
                map.put(val, map.get(val) - 1);
            else
                map.remove(val);
            if (map.lastKey() != last_height) {
                last_height = map.lastKey();
                result.add(Arrays.asList(cur_height.get(0), last_height));
            }
        }
        return result;
    }
}
