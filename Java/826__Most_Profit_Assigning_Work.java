class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < difficulty.length; i++) {
            map.put(difficulty[i], Math.max(profit[i], map.getOrDefault(difficulty[i], 0)));
        }

        int max_val = 0, result = 0;
        for (Integer key : map.keySet()) {
            max_val = Math.max(map.get(key), max_val);
            map.put(key, max_val);
        }

        Map.Entry<Integer, Integer> entry = null;
        for (int i = 0; i < worker.length; i++) {
            if (map.containsKey(worker[i])) {
                result += map.get(worker[i]);
            } else {
                entry = map.floorEntry(worker[i]);
                if (entry != null) {
                    result += entry.getValue();
                }
            }
        }
        return result;
    }
}
