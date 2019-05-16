class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        helper("", n, 0, 0);
        return result;
    }

    private void helper(String cur, int n, int left, int right) {
        if (left > n || left < right) return;
        if (left == n && right == n) result.add(cur);
        helper(cur + "(", n, left + 1, right);
        helper(cur + ")", n, left, right + 1);
    }
}
