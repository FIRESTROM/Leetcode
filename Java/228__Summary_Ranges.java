class Solution {
    public List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (start == Integer.MAX_VALUE) {
                start = nums[i];
            } else {
                if (end == Integer.MIN_VALUE) {
                    if (nums[i] == start + 1) {
                        end = nums[i];
                    } else {
                        result.add(Integer.toString(start));
                        start = nums[i];
                    }
                } else {
                    if (nums[i] == end + 1) {
                        end = nums[i];
                    } else {
                        result.add(Integer.toString(start) + "->" + Integer.toString(end));
                        start = nums[i];
                        end = Integer.MIN_VALUE;
                    }
                }
            }
        }
        if (end == Integer.MIN_VALUE) {
            result.add(Integer.toString(start));
        } else {
            result.add(Integer.toString(start) + "->" + Integer.toString(end));
        }
        return result;

    }
}
