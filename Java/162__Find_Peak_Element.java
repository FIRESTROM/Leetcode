class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            if (nums[0] == nums[1]) {
                return -1;
            } else if (nums[0] > nums[1]) {
                return 0;
            } else {
                return 1;
            }
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        int i = 0;
        while (i < nums.length) {
            while (i < nums.length - 1 && nums[i] <= nums[i + 1]) {
                i++;
            }
            if (nums[i] != nums[i - 1]) {
                return i;
            }
            while (i < nums.length - 1 && nums[i] >= nums[i + 1]) {
                i++;
            }
        }
        return -1;

    }
}
