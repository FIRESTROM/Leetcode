class Solution {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1;) {
            if (nums[i] != nums[i + 1]) {
                result[count] = nums[i];
                count++;
                i++;
            } else
                i = i + 2;
        }
        if (count == 1) result[1] = nums[nums.length - 1];
        return result;
    }
}
