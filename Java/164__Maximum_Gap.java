class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        if (min == max) return 0;
        int gap = (max - min) / nums.length + 1;
        int [][] buckets = new int[nums.length][];
        for (int i = 0; i < nums.length; i++) {
            int idx = (nums[i] - min) / gap;
            if (buckets[idx] == null)
                buckets[idx] = new int[]{nums[i], nums[i]};
            else {
                buckets[idx][0] = Math.min(buckets[idx][0], nums[i]);
                buckets[idx][1] = Math.max(buckets[idx][1], nums[i]);
            }
        }
        int result = Integer.MIN_VALUE, previous = min;
        for (int i = 0; i < nums.length; i++) {
            if (buckets[i] == null) continue;
            result = Math.max(result, Math.max(buckets[i][0] - previous, buckets[i][1] - buckets[i][0]));
            previous = buckets[i][1];
        }
        return result;
    }
}
