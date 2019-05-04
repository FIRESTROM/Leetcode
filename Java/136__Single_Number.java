class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int val : nums) {
            result = result ^ val;
        }
        return result;
    }
}
