class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> result = new ArrayList<>();
        helper(0, n, result, "", "");
        return result;
    }

    void helper(int index, int n, List<String> result, String left, String right) {
        if (index * 2 == n) {
            result.add(left + right);
            return;
        } else if (index * 2 + 1 == n) {
            result.add(left + "1" + right);
            result.add(left + "8" + right);
            result.add(left + "0" + right);
            return;
        }
        helper(index + 1, n, result, left + "1", "1" + right);
        helper(index + 1, n, result, left + "8", "8" + right);
        helper(index + 1, n, result, left + "6", "9" + right);
        helper(index + 1, n, result, left + "9", "6" + right);
        if (index !=0)
             helper(index + 1, n, result, left + "0", "0"+ right);
    }
}
