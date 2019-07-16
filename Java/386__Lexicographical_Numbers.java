class Solution {
    List<Integer> result;
    int N;

    public List<Integer> lexicalOrder(int n) {
        result = new ArrayList<>();
        N = n;
        for (int i = 1; i <= Math.min(n, 9); i++)
            dfs(i);

        return result;
    }

    private void dfs(int num) {
        result.add(num);
        for (int i = 0; i <= 9; i++) {
            if (num * 10 + i <= N) {
                dfs(num * 10 + i);
            }
        }
    }
}
