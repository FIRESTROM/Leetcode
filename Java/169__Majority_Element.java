class Solution {
    public int majorityElement(int[] nums) {
         return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int start, int end) {
        int[] result = new int[2];
        if (start == end) {
            return nums[start];
        }
        int mid = (start + end) / 2;
        int left_val = helper(nums, start, mid);
        int right_val = helper(nums, mid + 1, end);
        if (left_val == right_val) {
            return left_val;
        }
        int left_cnt = count(nums, left_val, start, end);
        int right_cnt = count(nums, right_val, start, end);
        return left_cnt > right_cnt ? left_val : right_val;
    }

    private int count(int[] nums, int target, int start, int end) {
        int result = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == target)
                result++;
        }
        return result;
    }
}
