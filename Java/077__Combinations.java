class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        helper(n, 1, k, new ArrayList<>());
        return result;
    }

    private void helper(int n, int index, int k, List<Integer> cur_arr) {
        if (k == 0) result.add(new ArrayList<>(cur_arr));
        if (index > n) return;
        for (int x = index; x <= n; x++) {
            cur_arr.add(x);
            helper(n, x + 1, k - 1, cur_arr);
            cur_arr.remove(cur_arr.size() - 1);
        }
    }
}
