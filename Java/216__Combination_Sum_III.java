class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        helper(k, n, 1, new ArrayList<>());
        return result;
    }

    private void helper(int k, int rest_n, int start, List<Integer> cur) {
        if (k == 0) {
            if (rest_n == 0) result.add(new ArrayList<>(cur));
            else return;
        }
        if (rest_n <= 0) return;
        if (start >= 10 || start > rest_n) return;
        helper(k, rest_n, start + 1, cur);
        cur.add(start);
        helper(k - 1, rest_n - start, start + 1, cur);
        cur.remove(cur.size() - 1);
    }
}
