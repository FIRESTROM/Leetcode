class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int idx = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (count == 2) {
                    continue;
                } else {
                    count++;
                    nums[idx] = nums[i];
                    idx++;
                }
            } else {
                count = 1;
                nums[idx] = nums[i];
                idx++;
            }
        }
        return idx;
    }
}
