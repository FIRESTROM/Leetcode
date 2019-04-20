class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int total_max = nums[0];
        // Need previous values for computations
        int prev_max = nums[0], prev_min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min_so_far = Math.min(Math.min(nums[i] * prev_max, nums[i] * prev_min), nums[i]);
            max_so_far = Math.max(Math.max(nums[i] * prev_max, nums[i] * prev_min), nums[i]);
            total_max = Math.max(Math.max(min_so_far, max_so_far), total_max);
            prev_min = min_so_far;
            prev_max = max_so_far;
        }
        return total_max;
    }
}
