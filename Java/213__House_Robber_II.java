class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        int result = dp[len - 1];
        dp = new int[len];
        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        result = Math.max(result, dp[len - 1]);
        return result;

    }
}
