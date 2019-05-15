class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        if (k != 0) {
            Set<Integer> num_set = new HashSet<>();
            for (int val : nums) num_set.add(val);
            int result = 0;
            for (int val : num_set) {
                if (num_set.contains(val + k)) result++;
                if (num_set.contains(val - k)) result++;
            }
            return result / 2;
        } else {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int val : nums) map.put(val, map.getOrDefault(val, 0) + 1);
            int result = 0;
            for (int val : map.keySet()) {
                if (map.get(val) > 1) result++;
            }
            return result;
        }
    }
