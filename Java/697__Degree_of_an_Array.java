class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> map  = new HashMap<>();
        HashMap<Integer, Integer> left  = new HashMap<>();
        HashMap<Integer, Integer> right  = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            map.put(val, map.getOrDefault(val, 0) + 1);
            if (left.get(val) == null) {
                left.put(val, i);
            }
            right.put(val, i);
        }

        int degree = Collections.max(map.values());
        int result = nums.length;
        for (int val: map.keySet()) {
            if (map.get(val) == degree) {
                result = Math.min(result, right.get(val) - left.get(val) + 1);
            }
        }
        return result;
    }
}
