class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        return helper_dfs(candidates, target, 0, new ArrayList<Integer>());
    }

    private List<List<Integer>> helper_dfs(int[] candidates, int target, int index, List<Integer> cur_list) {
        List<List<Integer>> result = new ArrayList<>();
        if (target == 0) {
            result.add(new ArrayList<>(cur_list));
            return result;
        } else if (target < 0) {
            return result;
        }
        for (int i = index; i < candidates.length; i++) {
            cur_list.add(candidates[i]);
            List<List<Integer>> temp = helper_dfs(candidates, target - candidates[i], i, cur_list);
            cur_list.remove(cur_list.size() - 1);
            for (List<Integer> x : temp) {
                result.add(x);
            }
        }
        return result;
    }
}


// Cleaner Solution
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        sumHelper(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void sumHelper(int[] candidates,int index, int target, List<Integer> cur_list, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(cur_list));
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target){
                cur_list.add(candidates[i]);
                sumHelper(candidates, i, target - candidates[i], cur_list, result);
                cur_list.remove(cur_list.size() - 1);
            }
        }
    }
}
