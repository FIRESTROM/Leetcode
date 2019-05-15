class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = nums.length - 1;
        for (int val : nums) {
            if (val == 0) {
                i++;
            } else if (val == 2) {
                j--;
            }
        }
        for (int k = 0; k < i; k++) nums[k] = 0;
        for (int k = i; k <= j; k++) nums[k] = 1;
        for (int k = j + 1; k < nums.length; k++) nums[k] = 2;
    }
}
