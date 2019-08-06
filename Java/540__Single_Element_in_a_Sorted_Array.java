class Solution {
    public int singleNonDuplicate(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
            if (i >= 2 && ((nums[i] ^ nums[i - 1]) == 0) && (xor != 0))
                return xor;
        }
        return xor;
    }
}
