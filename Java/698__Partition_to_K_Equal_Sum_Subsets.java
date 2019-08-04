class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
      int sum = 0;
      for (int val : nums) sum += val;
      if (sum % k > 0)
          return false;
      int target = sum / k;
      Arrays.sort(nums);
      int row = nums.length - 1;
      if (nums[row] > target)
          return false;
      while (row >= 0 && nums[row] == target) {
          row--;
          k--;
      }
      return helper(new int[k], row, nums, target);
    }

    private boolean helper(int[] groups, int row, int[] nums, int target) {
        if (row < 0)
            return true;
        int val = nums[row--];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + val <= target) {
                groups[i] += val;
                if (helper(groups, row, nums, target))
                    return true;
                groups[i] -= val;
            }
            if (groups[i] == 0)
                break;
        }
        return false;
    }
}
