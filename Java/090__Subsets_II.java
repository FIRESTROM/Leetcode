class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0)
            return Collections.emptyList();
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        subSetHelper(nums, new ArrayList<Integer>(), result, 0);
        return result;
    }

    private void subSetHelper(int[] nums, List<Integer> tempList, List<List<Integer>> result, int start) {
        result.add(new ArrayList<Integer>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            tempList.add(nums[i]);
            subSetHelper(nums, tempList, result, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
