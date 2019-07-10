class Solution {
    Integer [][] dp = null;

    public int maxCoins(int[] nums) {
        int len = nums.length;
        dp = new Integer[len][len];
        return helper(nums, 0, len - 1);
    }

    private int helper(int[] nums, int i, int j) {
		if (i > j)
			return 0;
		if (dp[i][j] != null)
			return dp[i][j];
		dp[i][j] = 0;
		for (int k = i; k <= j; k++) {
			int prod = nums[k];
			if (i - 1 >= 0)
				prod *= nums[i - 1];
			if (j + 1 < nums.length)
				prod *= nums[j + 1];
			dp[i][j] = Math.max(dp[i][j], helper(nums, i, k - 1) + prod + helper(nums, k + 1, j));
		}
		return dp[i][j];
	}
}
