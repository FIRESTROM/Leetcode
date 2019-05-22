class Solution {
    public int triangleNumber(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) continue;
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k]) k++;
                result += k - j - 1;
            }
        }
        return result;
    }
}
