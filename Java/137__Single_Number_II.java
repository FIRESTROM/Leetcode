class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = -1;
        boolean found = false;
        int i = 0;
        while (found == false) {
            found = false;
            if (i == nums.length - 1) {
                result = nums[i];
                found = true;
                break;
            }
            if (nums[i] == nums[i + 1]) {
                i+=3;
                continue;
            } else {
                result = nums[i];
                found = true;
                break;
            }
        }
        return result;
    }
}
