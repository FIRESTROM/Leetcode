class Solution {
    public int threeSumClosest(int[] nums, int target) {

        int min_val = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < Math.abs(min_val - target)) {
                    min_val = sum;
                }
                if (sum - target > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return min_val;
    }
}
