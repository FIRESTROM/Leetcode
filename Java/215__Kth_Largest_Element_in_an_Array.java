class Solution {
    public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = helper(nums, l, r);
            if (mid == k - 1) return nums[k - 1];
            else if (mid < k - 1) l = mid + 1;
            else r = mid - 1;
        }
        return nums[l];
    }

    private int helper(int[] nums, int l, int r) {
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] <= pivot) r--;
            nums[l] = nums[r];
            while (l < r && nums[l] >= pivot) l++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }
}
