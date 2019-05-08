class Solution {
    public int totalFruit(int[] tree) {
        int result = 0;
        int left = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < tree.length; right++) {
            map.put(tree[right], map.getOrDefault(tree[right], 0) + 1);
            while (map.size() > 2) {
                map.put(tree[left], map.get(tree[left]) - 1);
                if (map.get(tree[left]) == 0) {
                    map.remove(tree[left]);
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;

    }
}
