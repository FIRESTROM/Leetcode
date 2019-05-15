class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0, l = 0;;
        int result = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            if (sum < s) continue;
            while (sum >= s) {
                sum -= nums[l];
                l++;
            }
            result = Math.min(result, r - l + 2);
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
