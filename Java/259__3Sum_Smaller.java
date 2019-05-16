class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) return 0;
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] >= target) break;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[j + 1] >= target) break;
                while (j < k && nums[i] + nums[j] + nums[k] >= target) k--;
                result += k - j;
                j++;
            }
        }
        return result;
    }
}
