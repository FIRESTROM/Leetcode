class Solution {
    Integer[] memo;

    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < 0) return 0;
        memo = new Integer[target + 1];
        return backtrack(nums, target);
    }

    private int backtrack(int[] nums, int target) {
        if (target < 0) return 0;
        if (target == 0) return 1;
        if (memo[target] != null) return memo[target];
        int total = 0;
        //different sequences are counted as different combinations.
        for (int i = 0; i < nums.length; i++)
            total += backtrack(nums, target - nums[i]);
        memo[target] = total;
        return total;
    }
}
