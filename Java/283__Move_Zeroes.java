class Solution {
    public void moveZeroes(int[] nums) {
        int save_index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (save_index != i) {
                    nums[save_index] = nums[i];
                }
                save_index++;
            }
        }
        for (int i = save_index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
