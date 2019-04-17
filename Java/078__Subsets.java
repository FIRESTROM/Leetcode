class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int val : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list = new ArrayList<>(result.get(i));
                list.add(val);
                result.add(list);
            }
        }
        return result;
    }
}

// Backtracing Solution
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, new ArrayList<>(), 0, nums);
        return result;
    }

    private void backtracking(List<List<Integer>> result, List<Integer> temp_list, int index, int[] nums) {
        result.add(new ArrayList<>(temp_list));
        for (int i = index; i < nums.length; i++) {
            temp_list.add(nums[i]);
            backtracking(result, temp_list, i + 1, nums);
            temp_list.remove(temp_list.size() - 1);
        }
    }
}
