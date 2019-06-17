class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
		boolean[] visited = new boolean[nums.length];
		Set<List<Integer>> set = new HashSet<>();
		helper(nums, visited, new ArrayList<>(), set);
		List<List<Integer>> result = new ArrayList<>(set);
		return result;
	}

    private void helper(int [] nums, boolean [] visited, List<Integer> temp, Set<List<Integer>> set) {
		if (temp.size() == nums.length) {
			set.add(new ArrayList<>(temp));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp.add(nums[i]);
				helper(nums, visited, temp, set);
				visited[i] = false;
				temp.remove(temp.size() - 1);
			}
		}
	}
}
