class Solution {
    public boolean canJump(int[] nums) {
        int max_i = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + nums[i] > max_i) {
                max_i = i + nums[i];
            }
            if (max_i == i && i != nums.length - 1) {
                return false;
            }
        }
        return true;
    }
}
