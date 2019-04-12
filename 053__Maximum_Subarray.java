class Solution {
    public int maxSubArray(int[] nums) {
        int temp = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp = Math.max(temp + nums[i], nums[i]);
            result = Math.max(result, temp);
        }
        return result;
    }
}
