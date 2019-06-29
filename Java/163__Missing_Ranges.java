class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        if (nums.length == 0) {
            if (upper == lower) result.add(String.valueOf(lower));
            else result.add(helper(lower - 1, upper + 1));
            return result;
        }
        if (nums[0] - lower > 0 || (lower < 0 && nums[0] >= 0))
            result.add(helper(lower - 1, nums[0]));
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i + 1] - nums[i] > 1 || (nums[i] < 0 && nums[i + 1] >= 0))
                result.add(helper(nums[i], nums[i + 1]));
        if (upper - nums[nums.length - 1] > 0 || (nums[nums.length - 1] < 0 && upper >= 0))
            result.add(helper(nums[nums.length - 1], upper + 1));
        return result;
    }

    private String helper(int low, int high){
        if (high - low == 2)
            return String.valueOf(high - 1);
        return String.valueOf(low + 1) + "->" + String.valueOf(high - 1);
    }
}
