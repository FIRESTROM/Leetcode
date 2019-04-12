import java.util.Arrays;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                if (nums[i] + nums[start] + nums[end] == 0) {
                    result.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[start], nums[end])));
                    start += 1;
                    end -= 1;
                    while (start < end && nums[start] == nums[start - 1]) {
                        start += 1;
                    }
                    while (start < end && nums[end] == nums[end + 1]) {
                        end -= 1;
                    }
                } else if (nums[i] + nums[start] + nums[end] < 0) {
                    start += 1;
                    while (start < end && nums[start] == nums[start - 1]) {
                        start += 1;
                    }
                } else {
                    end -= 1;
                    while (start < end && nums[end] == nums[end + 1]) {
                        end -= 1;
                    }
                }
            }
        }
        return result;

    }
}
