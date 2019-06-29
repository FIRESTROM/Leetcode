class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        if (nums[l] < nums[r]) return nums[l];
        else if (nums[l] == nums[r]) {
            int result = nums[l];
            for (int i = 0; i < nums.length; i++)
                if (nums[i] < result)
                    result = nums[i];
            return result;
        } else {
            while (l + 1 < r) {
                int mid = (l + r) / 2;
                if (nums[mid] <= nums[r]) r = mid;
                else l = mid;
            }
            return nums[r] < nums[l] ? nums[r] : nums[l];
        }
    }
}
