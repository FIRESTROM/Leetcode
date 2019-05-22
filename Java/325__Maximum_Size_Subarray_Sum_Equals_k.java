class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int cur_sum = 0, result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            cur_sum += nums[i];
            if (!map.containsKey(cur_sum)) {
                map.put(cur_sum, i);
            }
            int previousSum = cur_sum - k;
            if (map.containsKey(previousSum)) {
                int length = i - map.get(previousSum);
                result = Math.max(length, result);
            }
        }

        return result;
    }
}
