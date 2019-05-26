class Solution {

    Set<List<Integer>> result_set = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(0, candidates, target, new ArrayList<>());
        List<List<Integer>> result = new ArrayList<>(result_set);
        return result;
    }

    private void helper(int index, int[] candidates, int target, List<Integer> cur_arr) {
        if (target == 0) result_set.add(new ArrayList<>(cur_arr));
        if (target < 0) return;
        if (index == candidates.length) return;

        for (int cur = index; cur < candidates.length; cur++) {
            cur_arr.add(candidates[cur]);
            helper(cur + 1, candidates, target - candidates[cur], cur_arr);
            cur_arr.remove(cur_arr.size() - 1);
        }
    }
}
