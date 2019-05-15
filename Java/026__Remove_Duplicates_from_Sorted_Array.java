class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int i = 0, j = 0;
        while (j < nums.length) {
            nums[i] = nums[j];
            while (j < nums.length - 1 && nums[j] == nums[j + 1]) j++;
            i++;
            j++;
        }
        return i;
    }
}
