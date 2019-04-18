class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }
}
// Another smarter solution

class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int steps = 0;
        int limit = 0; // current steps limit
        int next = 0; // steps + 1 jump's maximum place

        for (int i = 0; i < nums.length; i++) {
            next = Math.max(next, i + nums[i]);
            if (i == limit) {
                steps++;
                limit = next;
                if (limit >= nums.length - 1) {
                    return steps;
                }
            }
        }
        return steps;
    }
}
