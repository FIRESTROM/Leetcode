class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> nums_lst = new ArrayList<>();
        for (int val : nums)
            nums_lst.add(val);
        backtrack(nums.length, nums_lst, 0);
        return result;
    }

    public void backtrack(int n, List<Integer> nums, int index) {
        if (index == n)
            result.add(new ArrayList<Integer>(nums));

        for (int i = index; i < n; i++) {
            // place i-th integer first
            // in the current permutation
            Collections.swap(nums, index, i);
            // use next integers to complete the permutations
            backtrack(n, nums, index + 1);
            // backtrack
            Collections.swap(nums, index, i);
         }
    }
}
