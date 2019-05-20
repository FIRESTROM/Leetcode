class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums[0] == target) return 0;
		if (target == nums[nums.length - 1]) return nums.length - 1;
		if (target > nums[nums.length - 1]) return nums.length;
        int l = 0, r = nums.length;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return r + 1;
    }
}
