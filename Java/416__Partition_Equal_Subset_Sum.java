class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int val : nums)
            sum += val;
        if (sum % 2 == 1)
            return false;

        return helper(nums, sum / 2);
    }

    private boolean helper(int[] nums, int sum) {
        int len = nums.length;

        boolean[][] dp = new boolean[len + 1][sum + 1];
        for (int i = 0; i <= len; i++)
            dp[i][0] = true;
        for (int j = 1; j <= sum; j++)
            dp[0][j] = false;

        for (int i = 1; i <= len; i++)
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
            }
        return dp[len][sum];
    }
}
